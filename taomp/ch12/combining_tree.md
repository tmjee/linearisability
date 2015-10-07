# Combining Tree

"The Art of MultiProcessor Programming" pg. 260 section 12.3


### Idea
- threads access leaves
- only one can win and got up the parent, looser (second) waits
- As it goes up the tree values, winner (`firstValue`) looser (`secondValue`) are accumulated
- The eventual value (total of `firstValue` and `secondValue`) will be distributed downwards to Nodes

### States
- Idle
- First
- Second

### Mutex conditions
- Node's Lock
  - keep precombine(), combine() and op() in sync
  - can't precombine() or combine() until secondValue is valid


### Phases
#### precombine()
  Determine if this thread is the first or not

#### combine()
  Combine `firstValue` and `secondValue`. 
  
#### op()
  Figure out result (if it's Root aready)
  Else accumulate intermediate value in `secondValue` and `notifyAll()` to let 
  other threads accumulate after unlocking.
  
#### distribute()
  distrubute final result (firstValue + accumulated secondaryValues in op())
  

