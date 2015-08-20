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
Following are tests that we currently have :-

## Map / Tree
- [Put and Get Test](results/map/PutAndGet_Test.md)
- [Put Running Count Test](results/map/PutRunningCount_Test.md)
- [Bulk Put Remove Test](results/map/BulkPutRemove_Test.md)

### Bulk Put Remove Test
- [HashMap](results/map/0000007.md)
- [ConcurrentHashMap](results/map/0000008.md)
- [ConcurrentSkipListMap](results/map/0000009.md)

## List
### Set adn Get Test
- [ArrayList - SetAndGet Test](results/list/0000001.md)
- [CopyOnWriteArrayList - SetAndGet Test](results/list/0000002.md)

## Set
### Set and Get Test
- [HashSet - SetAndGet Test](results/set/0000001.md)
- [ConcurrentSkipListSet - SetAndGet Test](results/set/0000002.md)
- [CopyOnWriteArraySet - SetAndGet Test](results/set/0000003.md)

## Queue
### Offer And Pool Test

## Miscs
- [TwoActorsTest](results/misc/0000001.md)


