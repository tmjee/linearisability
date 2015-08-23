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
8.    | s.NonBlockingFriendlyHashMap             |    F/T      |    F/T            |    T
9.    | s.NonBlockingFriendlySkipListMap         |    F        |    P              |    F/T
10.   | s.NonBlockingTorontoBSTMap               |    P        |    P              |    T

- [Put and Get Test](results/map/PutAndGet_Test.md)
- [Put Running Count Test](results/map/PutRunningCount_Test.md)
- [Bulk Put Remove Test](results/map/BulkPutRemove_Test.md)

## List
- [Get and Set Test](results/list/GetAndSet_Test.md)

## Set
- [Get and Set Test](results/set/GetAndSet_Test.md)

## Queue
- [Offer and Poll Test](results/queue/OfferAndPoll_Test.md)

## Miscs
- [TwoActorsTest](results/misc/Actors_TwoRunning_Test.md)


