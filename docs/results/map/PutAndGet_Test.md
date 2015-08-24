# PutAndGet Tests

## Summary
 * Player 1 puts (1,1) into the map and expects to get 1 back from get(1).
 * Player 2 puts (2,1) into the map and expects to get 1 back from get(2).


## Output
### 1. HashMap
```
./run_HashMap_PutAndGet_Test.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test PutAndGetHashMap_TestUnit_1 - Put and get hash map (unit1)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test PutAndGetHashMap_TestUnit_1 (Put and get hash map (unit1)) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutAndGet_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1,-1]    73,339              FORBIDDEN           Player 1 get back expected value while Player 2 did not
	[-1,1]    69,282              FORBIDDEN           Player 1 did not get back expected value but Player 2 did
	[1,1]     17,030,879          ACCEPTABLE          Both player 1 and 2 get back expected values
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception
	[1,-2]    0                   FORBIDDEN           Player 2 throws Exception
	[-1,-2]   0                   FORBIDDEN           Player 1 result is unexpected, Player 2 throws exception
	[-1,-1]   0                   FORBIDDEN           Both player 1 and player 2 did not get back expected value
	[-2,-1]   0                   FORBIDDEN           Player 1 throws Exception, Player 2 results is unexpected


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```

### 2. ConcurrentHashMap
```
./run_ConcurrentHashMap_PutAndGet_Test.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test ConcurrentHashMap_PutAndGet_Test - ConcurrentHashMap Put and get Test
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
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test ConcurrentHashMap_PutAndGet_Test (ConcurrentHashMap Put and get Test) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutAndGet_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1,1]     16,933,500          ACCEPTABLE          Both player 1 and 2 get back expected values
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception
	[1,-2]    0                   FORBIDDEN           Player 2 throws Exception
	[1,-1]    0                   FORBIDDEN           Player 1 get back expected value while Player 2 did not
	[-1,1]    0                   FORBIDDEN           Player 1 did not get back expected value but Player 2 did
	[-1,-2]   0                   FORBIDDEN           Player 1 result is unexpected, Player 2 throws exception
	[-1,-1]   0                   FORBIDDEN           Both player 1 and player 2 did not get back expected value
	[-2,-1]   0                   FORBIDDEN           Player 1 throws Exception, Player 2 results is unexpected


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```


### 3. ConcurrentSkipListMap
```
./run_ConcurrentSkipListMap_PutAndGet_Test.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test ConcurrentSkipListMap_PutAndGet_Test - ConcurrentSkipListMap Put and Get Test
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
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test ConcurrentSkipListMap_PutAndGet_Test (ConcurrentSkipListMap Put and Get Test) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutAndGet_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1,1]     19,423,500          ACCEPTABLE          Both player 1 and 2 get back expected values
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception
	[1,-2]    0                   FORBIDDEN           Player 2 throws Exception
	[-1,-2]   0                   FORBIDDEN           Player 1 result is unexpected, Player 2 throws exception
	[-1,1]    0                   FORBIDDEN           Player 1 did not get back expected value but Player 2 did
	[1,-1]    0                   FORBIDDEN           Player 1 get back expected value while Player 2 did not
	[-1,-1]   0                   FORBIDDEN           Both player 1 and player 2 did not get back expected value
	[-2,-1]   0                   FORBIDDEN           Player 1 throws Exception, Player 2 results is unexpected


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```

### 4. LockBasedFriendlyTreeMap
```
	Unsupported operation of j.u.Map prevent further linearisation tests
```


### 5. LockBasedStanfordTreeMap
```
./run_Map_PutAndGetTest_LockBasedStanfordTreeMap.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbLockBasedStanfordTreeMap_PutAndGet_Test -
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test SbLockBasedStanfordTreeMap_PutAndGet_Test () :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutAndGet_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1,1]     18,753,500          ACCEPTABLE          Both player 1 and 2 get back expected values
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception
	[1,-2]    0                   FORBIDDEN           Player 2 throws Exception
	[-1,-2]   0                   FORBIDDEN           Player 1 result is unexpected, Player 2 throws exception
	[-1,1]    0                   FORBIDDEN           Player 1 did not get back expected value but Player 2 did
	[1,-1]    0                   FORBIDDEN           Player 1 get back expected value while Player 2 did not
	[-1,-1]   0                   FORBIDDEN           Both player 1 and player 2 did not get back expected value
	[-2,-1]   0                   FORBIDDEN           Player 1 throws Exception, Player 2 results is unexpected


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```

### 6. LogicalOrderingAVL
```
./run_Map_PutAndGetTest_LogicalOrderingAVL.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbLogicalOrderingAVL_PutAndGet_Test -
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
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
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test SbLogicalOrderingAVL_PutAndGet_Test () :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutAndGet_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1,1]     17,293,500          ACCEPTABLE          Both player 1 and 2 get back expected values
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception
	[1,-2]    0                   FORBIDDEN           Player 2 throws Exception
	[-1,-2]   0                   FORBIDDEN           Player 1 result is unexpected, Player 2 throws exception
	[-1,1]    0                   FORBIDDEN           Player 1 did not get back expected value but Player 2 did
	[1,-1]    0                   FORBIDDEN           Player 1 get back expected value while Player 2 did not
	[-1,-1]   0                   FORBIDDEN           Both player 1 and player 2 did not get back expected value
	[-2,-1]   0                   FORBIDDEN           Player 1 throws Exception, Player 2 results is unexpected


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```


### 7. NonBlockingCliffHashMap
```
./run_Map_PutAndGetTest_NonBlockingCliffHashMap.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbNonBlockingCliffHashMap_PutAndGet_Test -
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
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

	Summary of Test SbNonBlockingCliffHashMap_PutAndGet_Test () :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutAndGet_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1,1]     10,753,500          ACCEPTABLE          Both player 1 and 2 get back expected values
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception
	[1,-2]    0                   FORBIDDEN           Player 2 throws Exception
	[-1,-2]   0                   FORBIDDEN           Player 1 result is unexpected, Player 2 throws exception
	[-1,1]    0                   FORBIDDEN           Player 1 did not get back expected value but Player 2 did
	[1,-1]    0                   FORBIDDEN           Player 1 get back expected value while Player 2 did not
	[-1,-1]   0                   FORBIDDEN           Both player 1 and player 2 did not get back expected value
	[-2,-1]   0                   FORBIDDEN           Player 1 throws Exception, Player 2 results is unexpected


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```


### 8. NonBlockingFriendlyHashMap
```
./run_Map_PutAndGetTest_NonBlockingFriendlyHashMap.sh 
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbNonBlockingFriendlyHashMap_PutAndGet_Test - 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit 
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@405ecb22 timeout cancelled task, cancellation result =true
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit 
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@405ecb22 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@7d1fa9f4 timeout cancelled task, cancellation result =true
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit 
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@6d997232 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@7d1fa9f4 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@6d997232 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@7b909f59 timeout cancelled task, cancellation result =true
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit 
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@7b909f59 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@4d214cd2 timeout cancelled task, cancellation result =true
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit 
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@4d214cd2 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> 

	Summary of Test SbNonBlockingFriendlyHashMap_PutAndGet_Test () :- 

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutAndGet_Test.md

	Id        Count               Expectation         Description                                                                                         
	--------  -----------------   ------------------  ---------------------------------                                                                   
	[-1,-1]   500                 FORBIDDEN           Both player 1 and player 2 did not get back expected value                                          
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception                                                                           
	[1,-2]    0                   FORBIDDEN           Player 2 throws Exception                                                                           
	[-1,-2]   0                   FORBIDDEN           Player 1 result is unexpected, Player 2 throws exception                                            
	[-1,1]    0                   FORBIDDEN           Player 1 did not get back expected value but Player 2 did                                           
	[1,-1]    0                   FORBIDDEN           Player 1 get back expected value while Player 2 did not                                             
	[-2,-2]   0                   FORBIDDEN           Player 1 and Player 2 both throws exception                                                         
	[-2,-1]   0                   FORBIDDEN           Player 1 throws Exception, Player 2 results is unexpected                                           
	[1,1]     0                   ACCEPTABLE          Both player 1 and 2 get back expected values                                                        


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```


### 9. NonBlockingFriendlySkipListMap
```
./run_Map_PutAndGetTest_NonBlockingFriendlySkipListMap.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbNonBlockingFriendlySkipListMap_PutAndGet_Test -
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
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

	Summary of Test SbNonBlockingFriendlySkipListMap_PutAndGet_Test () :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutAndGet_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[-1,1]    861                 FORBIDDEN           Player 1 did not get back expected value but Player 2 did
	[1,1]     3,012,639           ACCEPTABLE          Both player 1 and 2 get back expected values
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception
	[1,-2]    0                   FORBIDDEN           Player 2 throws Exception
	[-1,-2]   0                   FORBIDDEN           Player 1 result is unexpected, Player 2 throws exception
	[1,-1]    0                   FORBIDDEN           Player 1 get back expected value while Player 2 did not
	[-1,-1]   0                   FORBIDDEN           Both player 1 and player 2 did not get back expected value
	[-2,-1]   0                   FORBIDDEN           Player 1 throws Exception, Player 2 results is unexpected


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```

### 10. NonBlockingTorontoBSTMap
```
./run_Map_PutAndGetTest_NonBlockingTorontoBSTMap.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbNonBlockingTorontoBSTMap_PutAndGet_Test -
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
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
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test SbNonBlockingTorontoBSTMap_PutAndGet_Test () :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutAndGet_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1,1]     17,503,500          ACCEPTABLE          Both player 1 and 2 get back expected values
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception
	[1,-2]    0                   FORBIDDEN           Player 2 throws Exception
	[-1,-2]   0                   FORBIDDEN           Player 1 result is unexpected, Player 2 throws exception
	[-1,1]    0                   FORBIDDEN           Player 1 did not get back expected value but Player 2 did
	[1,-1]    0                   FORBIDDEN           Player 1 get back expected value while Player 2 did not
	[-1,-1]   0                   FORBIDDEN           Both player 1 and player 2 did not get back expected value
	[-2,-1]   0                   FORBIDDEN           Player 1 throws Exception, Player 2 results is unexpected


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```

### SnapHashMap
```
./run_Map_PutAndGet_SnapHashMap.sh 
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbSnapHashMap_PutAndGet_Test - 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
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

	Summary of Test SbSnapHashMap_PutAndGet_Test () :- 

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutAndGet_Test.md

	Id        Count               Expectation         Description                                                                                         
	--------  -----------------   ------------------  ---------------------------------                                                                   
	[1,1]     15,293,500          ACCEPTABLE          Both player 1 and 2 get back expected values                                                        
	[-2,1]    0                   FORBIDDEN           Player 1 throws exception                                                                           
	[1,-2]    0                   FORBIDDEN           Player 2 throws Exception                                                                           
	[-1,-2]   0                   FORBIDDEN           Player 1 result is unexpected, Player 2 throws exception                                            
	[-1,1]    0                   FORBIDDEN           Player 1 did not get back expected value but Player 2 did                                           
	[1,-1]    0                   FORBIDDEN           Player 1 get back expected value while Player 2 did not                                             
	[-1,-1]   0                   FORBIDDEN           Both player 1 and player 2 did not get back expected value                                          
	[-2,-2]   0                   FORBIDDEN           Player 1 and Player 2 both throws exception                                                         
	[-2,-1]   0                   FORBIDDEN           Player 1 throws Exception, Player 2 results is unexpected                                           


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```
