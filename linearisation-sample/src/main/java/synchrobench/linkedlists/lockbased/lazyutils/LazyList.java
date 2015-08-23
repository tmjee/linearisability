package synchrobench.linkedlists.lockbased.lazyutils;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;


/**
 *
 * @author Erik Sapir & Lior Zibi
 *
 * Lazy list implementation: lock-free contains method.
 * removed element are first removed logically and only than physically
 *
 * @param T Item type.
 */
public class LazyList<T> implements List<T>  {
        /**
         * First list Node
         */
        volatile private Node m_head;
 
        /**
         * counter for number of element in the list
         */
        volatile private SnapshotCounter m_counter;
 
        /**
         * Constructor
         */
        public LazyList(int numOfThreads) {
                // Add sentinels to start and end
                this.m_head  = new Node(Integer.MIN_VALUE);
                this.m_head.m_next = new Node(Integer.MAX_VALUE);
   
                m_counter = new SnapshotCounter(numOfThreads);
        }
 

        public boolean add(T item, int threadID) {
                int key = item.hashCode();
               
                while (true) {
                        Node pred = this.m_head;
                        Node curr = m_head.m_next;
                       
                        //search for first element equal or greater than the new element
                        while (curr.m_key < key) {
                                pred = curr; curr = curr.m_next;
                        }
                       
                        pred.lock();
     
                        try {
                                curr.lock();
       
                                try {          
                                        //validate theat pred and curr are not deleted and
                                        //that pred.next = curr
                                        if (validate(pred, curr)) {
                                                if (curr.m_key == key) {
                                                        // element is already in list - nothing to add
                                                        return false;
                                                } else {            
                                                        // add new element to list
                                                        Node Node = new Node(item);
                                                        Node.m_next = curr;
                                                        pred.m_next = Node;
                 
                                                        //element added successfully - increment number of element in list
                                                        m_counter.inc(threadID);
             
                                                        return true;
                                                }
                                        }
                                } finally {
                                        curr.unlock(); // always unlock
                                }
                        } finally {
                                pred.unlock(); // always unlock
                        }
                }
        }
 
        public boolean remove(T item, int threadID) {
                int key = item.hashCode();
               
                while (true) {
                        Node pred = this.m_head;
                        Node curr = m_head.m_next;
                       
                        //search for first element equal or greater than element to be removed
                        while (curr.m_key < key) {
                                pred = curr; curr = curr.m_next;
                        }
                       
                        pred.lock();
                       
                        try {
                                curr.lock();
                               
                                try {
                                        if (validate(pred, curr)) {
                                                if (curr.m_key != key) {
                                                        // element was not found in list - nothing to remove
                                                        return false;
                                                } else {        
                                                        //element was found in list - first logically remove, than
                                                        //physically remove
                                                       
                                                        curr.marked = true;     // logically remove
                                                        pred.m_next = curr.m_next;  // physically remove
                     
                                                        //element removed successfully - decrement number of elements in list
                                                        m_counter.dec(threadID);
             
                                                        return true;
                                                }
                                        }
                                } finally {  // always unlock curr
                                        curr.unlock();
                                }
                        } finally { // always unlock pred
                                pred.unlock();
                        }
                }
        }
 
        public boolean contains(T item, int threadID) {
                int key = item.hashCode();
                Node curr = this.m_head;
   
                //search for first element equal or greater than element we are searching
                while (curr.m_key < key)
                        curr = curr.m_next;
               
                //return true iff found element in list and it is not logically removed
                return curr.m_key == key && !curr.marked;
        }
 
        public void clean(int threadID) {
               
                m_head.lock();
                Node curr = m_head.m_next;
               
                try {
                       
                        //go over each and every element in list and remove it.
                        while (curr.m_key != Integer.MAX_VALUE){
                                curr.lock();
                               
                                try {
                                        curr.marked = true;     // logically remove
                                        m_head.m_next = curr.m_next;  // physically remove
                 
                                        //element removed successfully - decrement number of elements in list
                                        m_counter.dec(threadID);
                               
                                } finally {
                                        curr.unlock(); //always unlock
                                }
                               
                                curr = m_head.m_next;
                       
                        }
                } finally {
                        m_head.unlock(); //always unlock
                }                
        }

        public boolean isEmpty(int threadID) {

                Node curr = this.m_head;
   
                //search an element that exist in the list, both logically and physically
                while (curr.m_key != Integer.MAX_VALUE) {
                        //make sure element was not removed logically
                        if (!curr.marked)
                                return false;
                        curr = curr.m_next;
                }
   
                return true;
        }

        public int size(int threadID) {
                return m_counter.scan_sum();
        }
       
        /**
         * Check that prev and curr are still in list and adjacent
         */
        private boolean validate(Node pred, Node curr) {
                return  !pred.marked && !curr.marked && pred.m_next == curr;
        }



        // =============== List interface implementation =================================

        @Override
        public int size() {
                return 0;
        }

        @Override
        public boolean isEmpty() {
                return false;
        }

        @Override
        public boolean contains(Object o) {
                return false;
        }

        @Override
        public Iterator<T> iterator() {
                return null;
        }

        @Override
        public void forEach(Consumer<? super T> action) {

        }

        @Override
        public Object[] toArray() {
                return new Object[0];
        }

        @Override
        public <T1> T1[] toArray(T1[] a) {
                return null;
        }

        @Override
        public boolean add(T t) {
                return false;
        }

        @Override
        public boolean remove(Object o) {
                return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
                return false;
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
                return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends T> c) {
                return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
                return false;
        }

        @Override
        public boolean removeIf(Predicate<? super T> filter) {
                return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
                return false;
        }

        @Override
        public void replaceAll(UnaryOperator<T> operator) {

        }

        @Override
        public void sort(Comparator<? super T> c) {

        }

        @Override
        public void clear() {

        }

        @Override
        public T get(int index) {
                return null;
        }

        @Override
        public T set(int index, T element) {
                return null;
        }

        @Override
        public void add(int index, T element) {

        }

        @Override
        public T remove(int index) {
                return null;
        }

        @Override
        public int indexOf(Object o) {
                return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
                return 0;
        }

        @Override
        public ListIterator<T> listIterator() {
                return null;
        }

        @Override
        public ListIterator<T> listIterator(int index) {
                return null;
        }

        @Override
        public List<T> subList(int fromIndex, int toIndex) {
                return null;
        }

        @Override
        public Spliterator<T> spliterator() {
                return null;
        }

        @Override
        public Stream<T> stream() {
                return null;
        }

        @Override
        public Stream<T> parallelStream() {
                return null;
        }




        // ===== inner class ==========================================

        /**
         * list Node
         */
        private class Node {
               
                /**
                 * actual item
                 */
                final T m_item;


                /**
                 * item's hash code
                 */
                final int m_key;

                /**
                 * next Node in list
                 */
                volatile Node m_next;

                /**
                 * If true, Node is logically deleted.
                 */
                volatile boolean marked;
               
                /**
                 * Synchronizes Node.
                 */
                Lock m_lock;

                /**
                 * Constructor for usual Node
                 * @param item element in list
                 */
                Node(T item) {      // usual constructor
                        this.m_item = item;
                        this.m_key = item.hashCode();
                        this.m_next = null;
                        this.marked = false;
                        this.m_lock = new ReentrantLock();
                }
               
                /**
                 * Constructor for sentinel Node
                 * @param key should be min or max int value
                 */
                Node(int key) { // sentinel constructor
                        this.m_item = null;
                        this.m_key = key;
                        this.m_next = null;
                        this.marked = false;
                        this.m_lock = new ReentrantLock();
                }

                /**
                 * Lock Node
                 */
                void lock() {m_lock.lock();}
               
                /**
                 * Unlock Node
                 */
                void unlock() {m_lock.unlock();}
        }




}

