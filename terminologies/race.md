# Data Race

- Condition when 2 or more threads accessing a common memory location where at least one of them is a write and 
there is no synchronisation involves.
- Semantic error
- Relies on timing and ordering of events
- Race conditions can cause data race but not necessarily.



# Race Conditions
- Threads accessing common resource, but that doesn't necessarily means there is a data race.

| Thread x | Thread y |
|----------|----------|
| lock     |  lock    |
| x=10     |  x=11    |
| unlock   |  unlock  |

Thread x and thread y either can obtain lock first, so there is a race condition, but because of 
the mutual lock that need to be acquired before writing to x, there is no data race.


