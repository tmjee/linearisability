# Java Collections

### Interfaces
```
+ j.u.Collection 
  + j.u.List
  + j.u.Set
    + j.u.SortedSet
      + j.u.NavigableSet
  + j.u.Queue
    + j.u.c.BlockingQueue
      + j.u.c.TransferQueue
    + j.u.Deque
      + j.u.c.BlockingDeque
+ j.u.Map
  + j.u.SortedMap
    + j.u.NavigableMap
      + j.u.c.ConcurrentNavigableMap
  + j.u.c.ConcurrentMap
```


### `j.u.Set` implementations
```
+ j.u.AbstractCollection
  + j.u.AbstractSet                     implements j.u.Set
      + j.u.TreeSet                     implements j.u.SortedSet, j.u.NavigableSet
      + j.u.c.ConcurrentSkipListSet     implements j.u.SortedSet, j.u.NavigableSet
      + j.u.EnumSet
      + j.u.HashSet
        + j.u.LinkedHashSet
```

### `j.u.List` implementations
```
+ j.u.AbstractCollection
  + j.u.AbstractList                    implements j.u.List
    + j.u.ArrayList
    + j.u.Vector
    + j.u.AbstractSequentialList
      + j.u.LinkedList
  + j.u.c.CopyOnWriteArrayList          implement j.u.List
```


### `j.u.Queue` implementations
```
+j.u.AbstractCollection
  + j.u.AbstractQueue                   implements j.u.Queue
    + j.u.c.ArrayBlockingQueue          implements j.u.c.BlockingQueue
    + j.u.c.SynchronousQueue            implements j.u.c.BlockingQueue
    + j.u.c.DelayedQueue                implements j.u.c.BlockingQueue
    + j.u.c.LinkedBlockingQueue         implements j.u.c.BlockingQueue
    + j.u.c.ConcurrentBlockingQueue     implements j.u.c.BlockingQueue
    + j.u.c.PriorityBlocingQueue        implements j.u.c.BlockingQueue
    + j.u.c.LinkedTransferQueue         implements j.u.c.TransferQueue
    + j.u.c.ConcurrentLinkedQueue
    + j.u.PriorityQueue
```



### `j.u.Deque` implementations (can also be used as Queue)
```
+ j.u.AbstractQueue                   implements j.u.Deque
  + j.u.LinkedList
  + j.u.ArrayDeque
  + j.u.c.ConcurrentLinkedDeque 
  + j.u.c.LinkedBlockingDeque         implements j.u.c.BlockingDeque
```


### `j.u.Map` implementations
```
+ j.u.Dictionary 
  + j.u.Hashtable                     implements j.u.Map
+ j.u.AbstractMap                     implements j.u.Map
  + j.u.HashMap
    + j.u.LinkedHashMap
  + j.u.WeakHashMap
  + j.u.IdentityHashMap
  + j.u.EnumMap
  + j.u.TreeMap                       implements j.u.NavigableMap
  + j.u.c.ConcurrentSkipListMap       implements j.u.ConcurrentNavigableMap
```






