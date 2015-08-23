# SetAndGet Test

## Summary
 * Player 1 add 1 into the set and expects the set to contains 1.
 * Player 2 add 2 into the set and expects the set to contains 2.

## Output
### HashSet
```
./run_HashSet_SetAndGet_Test.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SetAndGetHashSetTest_Unit1 - Set and get hashset test (unit 1)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test SetAndGetHashSetTest_Unit1 (Set and get hashset test (unit 1)) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/set/SetAndGet_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1,-1]    24,521              FORBIDDEN           Player 1 retrieved value added, Player 2 did not retrieved value added
	[-1,1]    25,039              FORBIDDEN           Player 1 did not retrieved value added, Player 2 retrieved value added
	[1,1]     17,813,940          ACCEPTABLE          Player 1 retrieved value added, Player 2 retrieved value added.
	[-1,-1]   0                   FORBIDDEN           Player 1 did not retrieved value added, Player 2 did not retrieved value added


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !

```

### ConcurrentSkipListSet
```
./run_Set_SetAndGet_ConcurrentSkipListSet.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test ConcurrentSkipListSet_SetAndGet_Test - ConcurrentSkipListSet Set and Get Test
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test ConcurrentSkipListSet_SetAndGet_Test (ConcurrentSkipListSet Set and Get Test) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/set/SetAndGet_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[-2,-2]   1,933,500           UNKNOWN             unknown
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception
	[1,-2]    0                   FORBIDDEN           Player 2 throws exception
	[-1,-2]   0                   FORBIDDEN           Player 1 result is incorrect, Player 2 throws exception
	[-1,1]    0                   FORBIDDEN           Player 1 did not retrieved value added, Player 2 retrieved value added
	[1,-1]    0                   FORBIDDEN           Player 1 retrieved value added, Player 2 did not retrieved value added
	[-1,-1]   0                   FORBIDDEN           Player 1 did not retrieved value added, Player 2 did not retrieved value added
	[-2,-1]   0                   FORBIDDEN           Player 2 throws exception, Player 2 result is incorrect
	[1,1]     0                   ACCEPTABLE          Player 1 retrieved value added, Player 2 retrieved value added.


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !

```

### CopyOnWriteArraySet
```
./run_Set_SetAndGet_CopyOnWriteArraySet.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test CopyOnWriteArraySet_SetAndGet_Test - CopOnWriteArraySet Set and Get Test
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test CopyOnWriteArraySet_SetAndGet_Test (CopOnWriteArraySet Set and Get Test) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/set/SetAndGet_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1,1]     17,743,500          ACCEPTABLE          Player 1 retrieved value added, Player 2 retrieved value added.
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception
	[1,-2]    0                   FORBIDDEN           Player 2 throws exception
	[-1,-2]   0                   FORBIDDEN           Player 1 result is incorrect, Player 2 throws exception
	[-1,1]    0                   FORBIDDEN           Player 1 did not retrieved value added, Player 2 retrieved value added
	[1,-1]    0                   FORBIDDEN           Player 1 retrieved value added, Player 2 did not retrieved value added
	[-1,-1]   0                   FORBIDDEN           Player 1 did not retrieved value added, Player 2 did not retrieved value added
	[-2,-1]   0                   FORBIDDEN           Player 2 throws exception, Player 2 result is incorrect


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```

