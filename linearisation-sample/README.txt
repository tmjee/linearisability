#
#
#   Readme.txt
#
#


Following are the data structures we planned to include in our Linearisability toolkit's tests

Concurrent Data Structure From JDK
====================================
Map
---
    - ConcurrentHashMap
    - ConcurrentSkipListMap

Set
---
    - ConcurrentSkipListSet
    - CopyOnWriteArraySet

List
----
    - CopyOnWriteArrayList

Queue
-----
    - ConcurrentLinkedQueue

    BlockingQueue
    -------------
        - ArrayBlockingQueue
        - LinkedBlockingQueue
        - PriorityBlockingQueue

Deque
-----
    - ConcurrentLinkedDeque

    BlockingDeque
    -------------
        - LinkedBlockingDequeue

TransferQueue
-------------
    - LinkedTransferQueue



Non JDK Data Structures from Synchrobench
=========================================

Map
---
#   - synchrobench.hashtables.lockbased.LockBasedJavaHashMap (same as j.u.c.ConcurrentHashMap)
    - synchrobench.hashtables.lockfree.NonBlockingCliffHashMap
    - synchrobench.hashtables.lockfree.NonBlockingFriendlyHashMap
    - synchrobench.trees.lockbased.LockBasedFriendlyTreeMap
    - synchrobench.trees.lockbased.LockBasedStanfordTreeMap
    - synchrobench.trees.lockbased.LogicalOrderingAVL
    - synchrobench.trees.lockfree.NonBlockingTorontoBSTMap
    - synchrobench.skiplists.lockfree.NonBlockingFriendlySkipListMap
#   - synchrobench.skiplists.lockfree.NonBlockingJavaSkipListMap (same as j.u.c.ConcurrentSkipListMap)



Set
---
    - synchrobench.hashtables.sequential.SequentialHashIntSet
    - synchrobench.trees.sequential.SequentialRBTreeIntSet
    - synchrobench.linkedlists.lockbased.LazyListBasedSet
    - synchrobench.linkedlists.lockbased.LazyLinkedListSortedSet
    - synchrobench.linkedlists.lockbased.LockedLinkedListIntSet
    - synchrobench.linkedlists.lockfree.NonBlockingLinkedListSet
    - synchrobench.linkedlists.lockfree.NonBlockingLinkedListSetRTTI
    - synchrobench.linkedlists.sequential.SequentialLinkedListIntSet
    - synchrobench.linkedlists.sequential.SequentialLinkedListSortedSet
    - synchrobench.queues.sequential.SequentialQueueIntSet
    - synchrobench.skiplists.sequential.SequentialSkipListIntSet

List
----
    - synchrobench.linkedlists.lockbased.lazyutils.LazySet


Questions:-
-----------
    - What are the difference between j.u.Vector and Synchrobench's Vector
    - What are the changes between j.u.Vector, Synchrobench's Vector and SequentialVector
    - What are the difference between Synchrobench's LockedBasedJavaHashMap and j.u.HashMap

