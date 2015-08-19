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
        - LinkedBlockingQueue
        - PriorityBlockingQueue

TransferQueue
-------------
    - LinkedTransferQueue

Deque
-----
    - ConcurrentLinkedDeque

    BlockingDeque
    -------------
        - LinkedBlockingDequeue


Non JDK Data Structures from Synchrobench
=========================================
Hashtable
---------
    - hashtables.lockfree.NonBlockingCliffHashMap
    - hashtables.lockfree.NonBlockingFriendlyHashMap
    - hashtables.sequential.SequentialHashIntSet
    - hashtables.lockbased.LazyListBasedSet
    - hashtables.lockbased.LockedLinkedListIntSet

Linkedlist
----------
    - linkedlists.lockbased.lazyutils.LazyList
    - linkedlists.lockfree.NonBlockingLinkedListSet
    - linkedlists.lockfree.NonBlockingLinkedListSetRTTI
    - linkedlists.sequential.SequentialLinkedListIntSet
    - linkedlists.sequential.SequentialLinkedListSortedSet

Queue
-----
    - queues.sequential.SequentialQueueIntSet

Skiplist
--------
    - skiplists.lockfree.NonBlockingFriendlySkipListMap
    - skiplists.lockfree.NonBlockingJavaSkipListMap
    - skiplists.sequential.SequentialSkipListIntSet

Tree / Map
----------
    - trees.lockbased.LockBasedFriendlyTreeMap
    - trees.lockbased.StanfordTreeMap
    - trees.lockbased.LogicalOrderingAVL
    - trees.lockfree.NonBlockingTorontoBSTMap
    - trees.sequential.SequentialRBTreeIntSet




Questions:-
-----------
    - What are the difference between j.u.Vector and Synchrobench's Vector
    - What are the changes between j.u.Vector, Synchrobench's Vector and SequentialVector
    - What are the difference between Synchrobench's LockedBasedJavaHashMap and j.u.HashMap

