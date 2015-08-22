
# HashMap_PutRunningCount_Test

## Summary
 * Player 1 puts 1000 entries into the map from (0,0) till (999,999)
 * Player 2 puts 2000 entries into the map from (1000,1000) till (2999,2999)
 * Arbiter expects to see a size of 3000 (1000 from player 1 and 2000 from
 * player 2).

## Output
### HashMap
```
/run_Map_PutRunningCount_HashMap.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test PutRunningCountHashMapTest_TestUnit1 - Put and do running count (unit1)
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
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@45ef71be cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:94)
	at linearisation.generated.HashMap_PutRunningCount_Test_TestUnit1_Runner.internalRun(HashMap_PutRunningCount_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/254413710.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@2c336953 cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:94)
	at linearisation.generated.HashMap_PutRunningCount_Test_TestUnit1_Runner.internalRun(HashMap_PutRunningCount_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/254413710.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.CancellationException
	at java.util.concurrent.FutureTask.report(FutureTask.java:121)
	at java.util.concurrent.FutureTask.get(FutureTask.java:206)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:94)
	at linearisation.generated.HashMap_PutRunningCount_Test_TestUnit1_Runner.internalRun(HashMap_PutRunningCount_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/254413710.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test PutRunningCountHashMapTest_TestUnit1 (Put and do running count (unit1)) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutRunningCount_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[-1]      45                  FORBIDDEN           Running count for player 1 and 2 do not match expected result
	[1]       60,755              ACCEPTABLE          Running count for player 1 and 2 match expected result


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```

### ConcurrentHashMap
```
./run_Map_PutRunningCount_ConcurrentHashMap.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test ConcurrentHashMap_PutRunningCount_Test - ConcurrentHashMap Put Running Count Test
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

	Summary of Test ConcurrentHashMap_PutRunningCount_Test (ConcurrentHashMap Put Running Count Test) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutRunningCount_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1]       67,100              ACCEPTABLE          Running count for player 1 and 2 match expected result
	[-1]      0                   FORBIDDEN           Running count for player 1 and 2 do not match expected result


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```


### ConcurrentSkipListMap
```
./run_Map_PutRunningCount_ConcurrentSkipListMap.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test ConcurrentSkipListMap_PutRunningCount_Test - ConcurrentSkipListMap Put Running Count Test
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
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test ConcurrentSkipListMap_PutRunningCount_Test (ConcurrentSkipListMap Put Running Count Test) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutRunningCount_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[1]       57,100              ACCEPTABLE          Running count for player 1 and 2 match expected result
	[-1]      0                   FORBIDDEN           Running count for player 1 and 2 do not match expected result


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```


