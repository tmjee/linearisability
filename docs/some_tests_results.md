# Hardware & Software Specs.

## CPU
```
    $> sudo lshw -class processor
        description: CPU
        product: Core i7 (To Be Filled By O.E.M.)
        vendor: Intel Corp.
        physical id: 4
        bus info: cpu@0
        version: Intel(R) Core(TM) i7-3630QM CPU @ 2.40GHz
        serial: To Be Filled By O.E.M.
        slot: U3E1
        size: 1792MHz
        capacity: 4GHz
        width: 64 bits
        clock: 100MHz
        configuration: cores=4 enabledcores=4 threads=8
```

## Memory
```
   $> sudo lshw -class memory
        L1 Cache: 32KB, Internal, Write-Through, Instruction Cache
        L2 Cache: 256KB, Internal, Write-Through, Unified Cache
        L3 Cache: 6MB, Internal, Write-Back, Unified Cache
        System Memory: 16GB x 4
```


## JDK
```
    $> java -version
        java version "1.8.0_45"
        Java(TM) SE Runtime Environment (build 1.8.0_45-b14)
        Java HotSpot(TM) 64-Bit Server VM (build 25.45-b02, mixed mode)
```

## Testing Conditions
Conditions                        | Descriptions
--------------------------------- | -------------
Iterations                        |  5 iterations
Strides per iteration             |  100 to 10000
Time per Iteration                |  5000 ms

# Tests
Following are tests that we currently have 

No   | Test Result Flags    |   Decription 
---- | -------------------- | -----------------------------------------------
1.   |    P                 |   Pass
2.   |    E                 |   Exception Thrown
3.   |    U                 |   Unsupported operation (cannot tests)
4.   |    T                 |   Timeout
5.   |    F                 |   Failed (contains Forbidden results)


## Map / Tree

No    | Data Structures                          |  PutAndGet  |  PutRunningCount  |  BulkPutRemove 
----- | ---------------------------------------- | ----------- | ----------------- | ---------------
1.    | j.u.HashMap                              |    F        |    F              |    F/T
2.    | j.u.c.ConcurrentHashMap                  |    P        |    P              |    P
3.    | j.u.c.ConcurrentSkipListMap              |    P        |    P              |    P
4.    | s.LockBasedFriendlyTreeMap               |    U        |    U              |    U
5.    | s.LockBasedStanfordTreeMap               |    P        |    P              |    P
6.    | s.LogicalOrderingAVL                     |    P        |    P              |    P
7.    | s.NonBlockingCliffHashMap                |    P        |    P              |    P
8.    | s.NonBlockingFriendlyHashMap             |    P        |    F              |    F
9.    | s.NonBlockingFriendlySkipListMap         |    F        |    P              |    T
10.   | s.NonBlockingTorontoBSTMap               |    P        |    P              |    P
11.   | s.SnapHashMap                            |    P        |    P              |    P

- [PutAndGet test results](results/map/PutAndGet_Test.md)
- [PutRunningCount test results](results/map/PutRunningCount_Test.md)
- [BulkPutRemove test results](results/map/BulkPutRemove_Test.md)

## List

No    | Data Structures                          |  SetAndGet  
----- | ---------------------------------------- | -----------
1.    | j.u.ArrayList                            |   F/E
2.    | j.u.c.CopyOnWriteArrayList               |   P

- [GetandSet test results](results/list/GetAndSet_Test.md)


## Set
No    | Data Structures                          |  SetAndGet  
----- | ---------------------------------------- | -----------
1.    | j.u.HashSet                              |   F
2.    | j.u.c.CopyOnWriteArraySet                |   P
3.    | j.u.c.ConcurrentSkipListSet              |   P
4.    | s.LinkedSet                              |   P
5.    | s.SequentialHashSet                      |
6.    | s.SequentialRBTreeIntSet                 |
7.    | s.LazyListBasedSet                       |
8.    | s.LazyLinkedListSortedSet                |
9.    | s.LockedLinkedListIntSet                 |
10.   | s.NonBlockingLinkedListSet               |
11.   | s.NonBlockingLinkedListSetRTTI           |
12.   | s.SequentialLinkedListIntSet             |
13.   | s.SequentialLinkedListSortedSet          |
14.   | s.SequentialQueueIntSet                  |
15.   | s.SequentialSkipListIntSet               |

- [GetAndSet test results](results/set/GetAndSet_Test.md)

## Queue
No    | Data Structures                          |  SetAndGet  
----- | ---------------------------------------- | -----------
1.    | PriorityQueue                            |   F/T/E
2.    | ConcurrentLinkedQueue                    |   P
3.    | ArrayBlockingQueue                       |   P

- [OfferAndPoll test results](results/queue/OfferAndPoll_Test.md)

## Miscs
No   |  Data Structure                           |  TwoRunning
---- | ----------------------------------------- | -------------
1.   |  Two Actor                                |   P

- [TwoActors test results](results/misc/Actors_TwoRunning_Test.md)


