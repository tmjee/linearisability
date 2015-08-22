# BulkPutRemove

## Summary
 * Player 1 put (0,0) till (299,299) into the map
 * Player 2 remove (0,0) till (99,00) from the map.
 * Arbiter makes sure the size is 200 (300 - 100)

## Output
### HashMap
```
./run_Map_BulkPutRemove_HashMap.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test HashMap_BulkPutRemove_Test - HashMap Bulk Put Remove Test
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@21ad965d cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:94)
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3137a5a7 cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:94)
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
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
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@6a29ea21 cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:94)
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@776eec97 cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:94)
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
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
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@488d8e1c cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:94)
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@1dc0e75d cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:94)
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
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
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@510d4258 cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:94)
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@7c7ee0a9 cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:94)
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
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
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@70d0ca0c cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:94)
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@2a9851a cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:94)
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
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
	at linearisation.generated.HashMap_BulkPutRemove_Test_TestUnit1_Runner.internalRun(HashMap_BulkPutRemove_Test_TestUnit1_Runner.java:68)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:33)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1942406066.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test HashMap_BulkPutRemove_Test (HashMap Bulk Put Remove Test) :-

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

### ConcurrentHashMap
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

### ConcurrentSkipListMap
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


###


