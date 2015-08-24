# BulkPutRemove Tests

## Summary
 * Player 1 put (0,0) till (299,299) into the map
 * Player 2 remove (0,0) till (99,00) from the map.
 * Arbiter makes sure the size is 200 (300 - 100)

## Output
### 1. HashMap
```
./run_Map_BulkPutRemove_HashMap.sh 
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test HashMap_BulkPutRemove_Test - HashMap Bulk Put Remove Test
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@473997eb timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@14838010 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@473997eb already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@14838010 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3649d5e8 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@460d088 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3649d5e8 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@460d088 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3e667513 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3c8006c7 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3e667513 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3c8006c7 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@1189b35f timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@2d033997 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@1189b35f already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@2d033997 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@2f5a45af timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@1ba11e52 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@2f5a45af already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@1ba11e52 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> 

	Summary of Test HashMap_BulkPutRemove_Test (HashMap Bulk Put Remove Test) :- 

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/BulkPutRemove_Test.md

	Id        Count               Expectation         Description                                                                                         
	--------  -----------------   ------------------  ---------------------------------                                                                   
	[-1]      515                 FORBIDDEN           size after bulk insert and delete is not good                                                       
	[1]       185                 ACCEPTABLE          size after bulk insert and delete is good                                                           


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```

### 2. ConcurrentHashMap
```
./run_Map_BulkPutRemove_ConcurrentHashMap.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test ConcurrentHashMap_BulkPutRemove_Test - ConcurrentHashMap Bulk Put Remove Test
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

	Summary of Test ConcurrentHashMap_BulkPutRemove_Test (ConcurrentHashMap Bulk Put Remove Test) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/BulkPutRemove_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1]       673,500             ACCEPTABLE          size after bulk insert and delete is good
	[-1]      0                   FORBIDDEN           size after bulk insert and delete is not good


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```

### 3. ConcurrentSkipListMap
```
./run_Map_BulkPutRemove_ConcurrentSkipListMap.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test ConcurrentSkipListMap_BulkPutRemove_Test - ConcurrentSkipListMap Bulk Put Remove Test
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

	Summary of Test ConcurrentSkipListMap_BulkPutRemove_Test (ConcurrentSkipListMap Bulk Put Remove Test) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/BulkPutRemove_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1]       563,500             ACCEPTABLE          size after bulk insert and delete is good
	[-1]      0                   FORBIDDEN           size after bulk insert and delete is not good


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
./run_Map_BulkPutRemove_LockBasedStanfordTreeMap.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbLockBasedStanfordTreeMap_BulkPutRemove_Test -
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
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
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test SbLockBasedStanfordTreeMap_BulkPutRemove_Test () :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/BulkPutRemove_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1]       273,500             ACCEPTABLE          size after bulk insert and delete is good
	[-1]      0                   FORBIDDEN           size after bulk insert and delete is not good


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```


### 6. LogicalOrderingAVL
```
./run_Map_BulkPutRemove_LogicalOrderingAVL.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbLogicalOrderingAVL_BulkPutRemove_Test -
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
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test SbLogicalOrderingAVL_BulkPutRemove_Test () :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/BulkPutRemove_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1]       193,500             ACCEPTABLE          size after bulk insert and delete is good
	[-1]      0                   FORBIDDEN           size after bulk insert and delete is not good


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```

### 7. NonBlockingCliffHashMap
```
./run_Map_BulkPutRemove_NonBlockingCliffHashMap.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbNonBlockingCliffHashMap_BulkPutRemove -
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
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
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test SbNonBlockingCliffHashMap_BulkPutRemove () :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/BulkPutRemove_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1]       413,500             ACCEPTABLE          size after bulk insert and delete is good
	[-1]      0                   FORBIDDEN           size after bulk insert and delete is not good


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```

### 8. NonBlockingFriendlyHashMap
```
./run_Map_BulkPutRemove_NonBlockingFriendlyHashMap.sh 
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbNonBlockingFriendlyHashMap_BulkPutRemove_Test - 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@2be9781d timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@77ff023a timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@2be9781d already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@77ff023a already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@405ecb22 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@7d1fa9f4 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@405ecb22 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@7d1fa9f4 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@4d214cd2 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@4df10c8b timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@4d214cd2 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@4df10c8b already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@53ca5617 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@169a9db1 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@53ca5617 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@169a9db1 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@41a18d38 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@394f7a8 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@41a18d38 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@394f7a8 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> 

	Summary of Test SbNonBlockingFriendlyHashMap_BulkPutRemove_Test () :- 

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/BulkPutRemove_Test.md

	Id        Count               Expectation         Description                                                                                         
	--------  -----------------   ------------------  ---------------------------------                                                                   
	[-1]      0                   FORBIDDEN           size after bulk insert and delete is not good                                                       
	[1]       0                   ACCEPTABLE          size after bulk insert and delete is good                                                           


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```



### 9. NonBlockingFriendlySkipListMap
```
./run_Map_BulkPutRemove_NonBlockingFriendlySkipListMap.sh 
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbNonBlockingFriendlySkipListMap_BulkPutRemove_Test - 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@5b138d3e timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@55e984c5 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@514d4177 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@5b138d3e already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@55e984c5 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@514d4177 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@519a8b07 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@1d84f5f5 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3b71986a timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@519a8b07 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@1d84f5f5 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3b71986a already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@19a289dc timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@7c5e267 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@27c7e229 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@19a289dc already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@7c5e267 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@27c7e229 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Pool_Thread_10,10,main] -> worker exit 
[linearisability] Thread[Pool_Thread_12,10,main] -> worker exit 
[linearisability] Thread[Pool_Thread_11,10,main] -> worker exit 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_12,10,main] -> worker exit 
[linearisability] Thread[Pool_Thread_10,10,main] -> worker exit 
[linearisability] Thread[Pool_Thread_11,10,main] -> worker exit 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> 

	Summary of Test SbNonBlockingFriendlySkipListMap_BulkPutRemove_Test () :- 

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/BulkPutRemove_Test.md

	Id        Count               Expectation         Description                                                                                         
	--------  -----------------   ------------------  ---------------------------------                                                                   
	[-1]      46,220              FORBIDDEN           size after bulk insert and delete is not good                                                       
	[1]       80                  ACCEPTABLE          size after bulk insert and delete is good                                                           


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```




### 10. NonBlockingTorontoBSTMap
```
./run_Map_BulkPutRemove_NonBlockingTorontoBSTMap.sh 
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbNonBlockingTorontoBSTMap_BulkPutRemove_Test - 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@5716c318 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@5cb0878e timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@7de22c3 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@5716c318 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@5cb0878e already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@7de22c3 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3e39be27 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@62654726 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3f401d2b timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3e39be27 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@62654726 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3f401d2b already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@64828d7a timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@5c8e3c92 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@4d05c6bf timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@64828d7a already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@5c8e3c92 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@4d05c6bf already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@bb73d34 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@6cff592b timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@36071e7f timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@bb73d34 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@6cff592b already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@36071e7f already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@55e984c5 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@514d4177 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@1b3c65f timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@55e984c5 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@514d4177 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@1b3c65f already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> 

	Summary of Test SbNonBlockingTorontoBSTMap_BulkPutRemove_Test () :- 

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/BulkPutRemove_Test.md

	Id        Count               Expectation         Description                                                                                         
	--------  -----------------   ------------------  ---------------------------------                                                                   
	[-1]      0                   FORBIDDEN           size after bulk insert and delete is not good                                                       
	[1]       0                   ACCEPTABLE          size after bulk insert and delete is good                                                           


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```


### SnapHashMap
```
./run_Map_BulkPutRemove_SnapHashMap.sh 
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test SbSnapHashMap_BulkPutRemove_Test - 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
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
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit 
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> 

	Summary of Test SbSnapHashMap_BulkPutRemove_Test () :- 

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/BulkPutRemove_Test.md

	Id        Count               Expectation         Description                                                                                         
	--------  -----------------   ------------------  ---------------------------------                                                                   
	[1]       563,500             ACCEPTABLE          size after bulk insert and delete is good                                                           
	[-1]      0                   FORBIDDEN           size after bulk insert and delete is not good                                                       


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```


