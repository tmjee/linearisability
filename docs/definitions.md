# Definitions

## Blocking
Where process/thread gives up it's allocated time slot, reverting back to lower-level (possibly os) scheduling intervention 
for it's next allocated slot of execution, when it's attempt to get access to a monitor failed, that's blocking

## Non-Blocking
The opposite of blocking. Process / Thread that never willingly gives up it's allocated slot of execution, but rather could
possibly attempt to 'loop to success'. Lock-Free and Wait-Free are non-blocking.

## Lock-Free
Guarantee system-wide progress but not thread/process-wide progress. Eg. cas implementation where a particular 
thread/process couldpotentially be starving while others made progress. Lock-free "loop-to-success" could potentially 
be unbounded under high contention.

## Wait-Free
Guarantee both system-wide progress and also thread/process-wide progress. Wait-free "loop-to-success" by definition 
will need to be bounded (finite-steps), hence the name "wait-free"

