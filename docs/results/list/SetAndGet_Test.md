<!--
    #
    # SetAndGetArrayListTest
    #
-->
# ArrayList_SetAndGet_Test

## Summary
Player 1 try to insert an integer '1' into index 1 and then try to get back the integer at
index 1.

Player 2 try to insert an integer '1' into index 2 and then try to get back the integer at
index 2.

Both players are doing the operation at the same time without synchronisation


## Sample output
### ArrayList
```
$>./run_ArrayList_SetAndGet_Test.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SetAndGetArrayListTest_Unit1 - Set and get array list test (unit 1)
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
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test SetAndGetArrayListTest_Unit1 (Set and get array list test (unit 1)) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/list/SetAndGet_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[-2,-2]   10,813,500          FORBIDDEN           Player 1 and 2 thrown exception
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception
	[1,-2]    0                   FORBIDDEN           Player 2 throws exception
	[1,-1]    0                   FORBIDDEN           Player 1 get back value inserted, Player 2 did not get back value expected
	[-1,1]    0                   FORBIDDEN           Player 1 did not get back value inserted, Player 2 get back value inserted
	[-1,-2]   0                   FORBIDDEN           Player 1 gets back unexpected result, Player 2 throws exception
	[-1,-1]   0                   FORBIDDEN           Player 1 and 2 do not get back expected value
	[1,1]     0                   ACCEPTABLE          Player 1 and 2 got back expected values
	[-2,-1]   0                   FORBIDDEN           Player 1 throws exception, Player 2 get back unexpected value


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !

```

### CopyOnWriteArrayList
```
./run_List_SetAndGetTest_CopyOnWriteArrayList.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test CopyOnWriteArrayList_SetAndGet_Test - CopyOnWriteArrayList Set and get test
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test CopyOnWriteArrayList_SetAndGet_Test (CopyOnWriteArrayList Set and get test) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/list/SetAndGet_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[-2,-2]   9,823,500           FORBIDDEN           Player 1 and 2 thrown exception
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception
	[1,-2]    0                   FORBIDDEN           Player 2 throws exception
	[-1,-2]   0                   FORBIDDEN           Player 1 gets back unexpected result, Player 2 throws exception
	[-1,1]    0                   FORBIDDEN           Player 1 did not get back value inserted, Player 2 get back value inserted
	[1,-1]    0                   FORBIDDEN           Player 1 get back value inserted, Player 2 did not get back value expected
	[-1,-1]   0                   FORBIDDEN           Player 1 and 2 do not get back expected value
	[-2,-1]   0                   FORBIDDEN           Player 1 throws exception, Player 2 get back unexpected value
	[1,1]     0                   ACCEPTABLE          Player 1 and 2 got back expected values


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```