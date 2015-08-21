/* SnapTree - (c) 2009 Stanford University - PPL */

// CopyOnWriteManager
package synchrobench.trees.lockbased.stanfordutils;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/** Manages copy-on-write behavior for a concurrent tree structure.  It is
 *  assumed that the managed structure allows concurrent mutation, but that no
 *  mutating operations may be active when a copy-on-write snapshot of tree is
 *  taken.  Because it is difficult to update the size of data structure in a
 *  highly concurrent fashion, the <code>CopyOnWriteManager</code> also manages
 *  a running total that represents the size of the contained tree structure.
 *  <p>
 *  Users should implement the {@link #freezeAndClone(Object)} and
 *  {@link #cloneFrozen(Object)} methods.
 */
abstract public class CopyOnWriteManager<E> implements Cloneable {
    
    /** This is basically a stripped-down CountDownLatch.  Implementing our own
     *  reduces the object count by one, and it gives us access to the
     *  uninterruptable acquireShared.
     */
    private class Latch extends AbstractQueuedSynchronizer {
        Latch(final boolean triggered) {
            setState(triggered ? 0 : 1);
        }

        public int tryAcquireShared(final int acquires) {
            // 1 = success, and followers may also succeed
            // -1 = failure
            return getState() == 0 ? 1 : -1;
        }

        public boolean tryReleaseShared(final int releases) {
            // Before, state is either 0 or 1.  After, state is always 0.
            return compareAndSetState(1, 0);
        }
    }

    private static final int MUTATE = 1;
    private static final int MUTATE_AFTER_FREEZE = 2;
    private static final int BULK_READ = 3;
    private static final int BULK_READ_AFTER_FREEZE = 4;

    private class COWEpoch extends EpochNode {

        /** Tripped after this COWEpoch is installed as active. */
        private final Latch _activated;

        /** True iff this is a mutating epoch. */
        final boolean mutationAllowed;

        /** The value used by this epoch. */
        E value;

        /** The computed size of <code>value</code>, as of the beginning of
         *  this epoch.
         */
        int initialSize;

        /** A frozen E equal to <code>value</code>, if not <code>dirty</code>. */
        private volatile E _frozenValue;

        /** True if any mutations have been performed on <code>value</code>. */
        volatile boolean dirty;

        /** The epoch that will follow this one, created on demand. */
        final AtomicReference<COWEpoch> successorRef = new AtomicReference<COWEpoch>(null);
                
        /** A ticket on the successor, released when this epoch is closed. */
        Epoch.Ticket successorTicket;

        /** True if the successor should freeze and clone this epoch's value. */  
        boolean freezeRequested;

        private COWEpoch(final boolean mutationAllowed) {
            this._activated = new Latch(false);
            this.mutationAllowed = mutationAllowed;
        }

        public COWEpoch(final E value, final E frozenValue, final int initialSize) {
            this._activated = new Latch(true); // pre-triggered
            this.mutationAllowed = true;
            this.value = value;
            this.initialSize = initialSize;
            this._frozenValue = frozenValue;
            this.dirty = frozenValue == null;
        }

        EpochNode attemptInitialArrive() {
            return super.attemptArrive();
        }

        @Override
        public EpochNode attemptArrive() {
            final EpochNode ticket = super.attemptArrive();
            if (ticket != null && !dirty) {
                dirty = true;
                _frozenValue = null;
            }
            return ticket;
        }

        private void setFrozenValue(final E v) {
            if (!dirty) {
                _frozenValue = v;
                if (dirty) {
                    _frozenValue = null;
                }
            }
        }

        E getFrozenValue() {
            final E v = _frozenValue;
            return dirty ? null : v;
        }

        protected void onClosed(final int dataSum) {
            assert(dataSum == 0 || dirty);

            final COWEpoch succ = successorRef.get();
            if (freezeRequested) {
                succ.value = freezeAndClone(value);
                succ.setFrozenValue(value);
            }
            else {
                succ.value = value;
                if (dirty) {
                    succ.dirty = true;
                }
                else {
                    succ.setFrozenValue(_frozenValue);
                }
            }
            succ.initialSize = initialSize + dataSum;

            _active = succ;
            successorTicket.leave(0);
            succ._activated.releaseShared(1);
        }

        public void awaitActivated() {
            _activated.acquireShared(1);
        }

        public COWEpoch getOrCreateSuccessor(final boolean preferredMutation) {
            final COWEpoch existing = successorRef.get();
            if (existing != null) {
                return existing;
            }

            final COWEpoch repl = new COWEpoch(preferredMutation);
            if (attemptInstallSuccessor(repl)) {
                return repl;
            }

            return successorRef.get();
        }

        public boolean attemptInstallSuccessor(final COWEpoch succ) {
            final Epoch.Ticket t = succ.attemptInitialArrive();
            if (successorRef.compareAndSet(null, succ)) {
                successorTicket = t;
                beginClose();
                return true;
            }
            else {
                return false;
            }
        }
    }

    private volatile COWEpoch _active;

    /** Creates a new {@link CopyOnWriteManager} holding
     *  <code>initialValue</code>, with an assumed size of
     *  <code>initialSize</code>.
     */
    public CopyOnWriteManager(final E initialValue, final int initialSize) {
        _active = new COWEpoch(initialValue, null, initialSize);
    }

    /** The implementing method must mark <code>value</code> as shared, and
     *  return a new object to use in its place.  Hopefully, the majority of
     *  the work of the clone can be deferred by copy-on-write. 
     */
    abstract protected E freezeAndClone(final E value);

    /** Returns a clone of a frozen E. */
    abstract protected E cloneFrozen(E frozenValue);

    public CopyOnWriteManager<E> clone() {
        final CopyOnWriteManager<E> copy;
        try {
            copy = (CopyOnWriteManager<E>) super.clone();
        }
        catch (final CloneNotSupportedException xx) {
            throw new Error("unexpected", xx);
        }

        COWEpoch a = _active;
        E f = a.getFrozenValue();
        while (f == null) {
            a.freezeRequested = true;
            final COWEpoch succ = a.getOrCreateSuccessor(a.mutationAllowed);
            succ.awaitActivated();
            if (a.value != succ.value) {
                f = a.value;
            }
            a = succ;
        }

        copy._active = new COWEpoch(cloneFrozen(f), f, a.initialSize);
        return copy;
    }

    /** Returns a reference to the tree structure suitable for a read
     *  operation.  The returned structure may be mutated by operations that
     *  have the permission of this {@link CopyOnWriteManager}, but they will
     *  not observe changes managed by other instances.
     */
    public E read() {
        return _active.value;
    }

    /** Obtains permission to mutate the copy-on-write value held by this
     *  instance, perhaps blocking while a concurrent snapshot is being
     *  performed.  {@link Epoch.Ticket#leave} must be called exactly once on
     *  the object returned from this method, after the mutation has been
     *  completed.  The change in size reflected by the mutation should be
     *  passed as the parameter to <code>leave</code>.
     */
    public Epoch.Ticket beginMutation() {
        return begin(true);
    }

    public Epoch.Ticket beginQuiescent() {
        return begin(false);
    }

    private Epoch.Ticket begin(final boolean mutation) {
        final COWEpoch active = _active;
        if (active.mutationAllowed == mutation) {
            final Epoch.Ticket ticket = active.attemptArrive();
            if (ticket != null) {
                return ticket;
            }
        }
        return begin(mutation, active);
    }

    private Epoch.Ticket begin(final boolean mutation, COWEpoch epoch) {
        while (true) {
            COWEpoch succ = epoch.successorRef.get();
            if (succ == null) {
                final COWEpoch newEpoch = new COWEpoch(mutation);
                final Epoch.Ticket newTicket = newEpoch.attemptArrive();
                if (epoch.attemptInstallSuccessor(newEpoch)) {
                    // can't use the ticket until the new epoch is activated
                    newEpoch.awaitActivated();
                    return newTicket;
                }

                // if our CAS failed, somebody else succeeded
                succ = epoch.successorRef.get();
            }

            // is the successor created by someone else suitable?
            if (succ.mutationAllowed == mutation) {
                final Epoch.Ticket ticket = succ.attemptArrive();
                if (ticket != null) {
                    succ.awaitActivated();
                    return ticket;
                }
            }

            epoch = succ;
        }
    }

    /** Returns a reference to the tree structure suitable for a mutating
     *  operation.  This method may only be called under the protection of a
     *  ticket returned from {@link #beginMutation}.
     */
    public E mutable() {
        return _active.value;
    }

    /** Returns a reference to a snapshot of this instance's tree structure
     *  that may be read, but not written.  This is accomplished by suspending
     *  mutation, replacing the mutable root of this manager with the result of
     *  <code>freezeAndClone(root, false)</code>, and then returning a
     *  reference to the old root.  Successive calls to this method may return
     *  the same instance.
     */
    public E frozen() {
        COWEpoch a = _active;
        E f = a.getFrozenValue();
        while (f == null) {
            a.freezeRequested = true;
            final COWEpoch succ = a.getOrCreateSuccessor(a.mutationAllowed);
            succ.awaitActivated();
            if (a.value != succ.value) {
                f = a.value;
            }
            a = succ;
        }
        return f;
    }

    /** Returns a reference to a snapshot of this instance's tree structure,
     *  if one is available without requiring any additional copying, otherwise
     *  returns null.  May be used in combination with {@link #beginQuiescent}
     *  to perform quiescent reads with minimal cost.
     */
    public E availableFrozen() {
        return _active.getFrozenValue();
    }

    /** Returns true if the computed {@link #size} is zero. */
    public boolean isEmpty() {
        // for a different internal implementation (such as a C-SNZI) we might
        // be able to do better than this
        return size() == 0;
    }

    /** Returns the sum of the <code>initialSize</code> parameter passed to the
     *  constructor, and the size deltas passed to {@link Epoch.Ticket#leave}
     *  for all of the mutation tickets.  The result returned is linearizable
     *  with mutations, which requires mutation to be quiesced.  No tree freeze
     *  is required, however.
     */
    public int size() {
        final COWEpoch a = _active;
        final Integer delta = a.attemptDataSum();
        if (delta != null) {
            return a.initialSize + delta;
        }

        // wait for an existing successor, or force one if not already in progress
        final COWEpoch succ = a.getOrCreateSuccessor(a.mutationAllowed); 
        succ.awaitActivated();
        return succ.initialSize;
    }
}
