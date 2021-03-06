# Quiescent Consistency

## Criterias / Definition 

### Definition (informal)
- Operations to appear in a one-at-a-time sequential order
- Operations separated by a period of quiesence (a period in which no operation is executing, 
eg. no open call) to appear to take effect in their real-time order.

### Reordering is acceptable
Section 6 of [1] 

" We have choosen to formalise quiescent consistency in a way that matches the informal
description as closely as possible, however, since we are formalising an informal description
there might be valid alternatives to our definition above. In particular, our formalisation 
has some specific consequences, since it embodies the idea that quiescent consistency 
does not necessarily preserve program order. This means that one is even allowed to 
reorder the operations of a single process. So the following history (not occurring for our 
queue example): "

```
 T1  |---------e(a)----------------------------------|
 T2       |---d():b---|    |---e(b)---|
```

"where b is visibly dequeued before being enqueued, is accepted, since it can be reordered to 
the sequential history:"

```
 T1                                |---e(a)---|
 T2  |---e(b)---|   |---d():b---| 
```

"However strange this may seen, it appears that most informal discussion on quiescent consistency 
view this as a consequence of the definition."



## Our Case

Say we have a Queue subjected to the following sequence of queuing and unqueing  
```
T1  |--e(1)--|    |--e(3)--|         | Quiescent |           |--d():3--|         |--d():1--|
T2         |--e(2)--|    |--e(4)--|  | Period    | |--d():4--|         |--d():2--|
```

Based on [1], the above outcome is possible. This is due to the fact that quiescent consistency 
allows the following reordering

```
T1          |--e(3)--|        |--e(1)--| 
T2 |--e(4)--|        |--e(2)--|          
```
The outcome from T1 and T2's point of view seems counter intuitive of a queue's function, FIFO, 
but resembles more of a stack, FILO.



## References
[1] - Quiescent Consistency: Defining and Verifying Relaxed Linearizability: John Derrick, Brijesh Dongol et al.
