# SetAndGet Test

## Summary
 * Player 1 puts (1,1) into the list and expect to get 1 back from get(1).
 * Player 2 puts (2,1) into the list and expect to get 1 back from get(1)


## Sample output
### ArrayList
```
./run_Queue_OfferAndPoll_PriorityQueue.sh 
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test PriorityQueue_OfferAndPoll_Test - PriorityQueue Offer and Poll Test
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Pool_Thread_1,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_1,10,main] exception 
java.lang.NullPointerException
	at java.lang.Integer.compareTo(Integer.java:1216)
	at java.lang.Integer.compareTo(Integer.java:52)
	at java.util.PriorityQueue.siftUpComparable(PriorityQueue.java:656)
	at java.util.PriorityQueue.siftUp(PriorityQueue.java:647)
	at java.util.PriorityQueue.offer(PriorityQueue.java:344)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player1(Abstract_Queue_OfferAndPoll_Test.java:37)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player1(PriorityQueue_OfferAndPoll_Test.java:33)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker1.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:219)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:148)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:181)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$0(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:72)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$13/1095044979.call(Unknown Source)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@752f8eef timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3d826e7 timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@752f8eef already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@3d826e7 already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Pool_Thread_4,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_3,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_4,10,main] exception 
[linearisability] Thread[Pool_Thread_3,10,main] exception 
java.lang.NullPointerException
	at java.util.PriorityQueue.siftDownComparable(PriorityQueue.java:703)
	at java.util.PriorityQueue.siftDown(PriorityQueue.java:689)
	at java.util.PriorityQueue.poll(PriorityQueue.java:595)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player2(Abstract_Queue_OfferAndPoll_Test.java:53)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player2(PriorityQueue_OfferAndPoll_Test.java:38)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker2.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:231)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:148)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:181)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$1(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:76)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$14/375142620.call(Unknown Source)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
java.lang.NullPointerException
	at java.lang.Integer.compareTo(Integer.java:1216)
	at java.lang.Integer.compareTo(Integer.java:52)
	at java.util.PriorityQueue.siftUpComparable(PriorityQueue.java:656)
	at java.util.PriorityQueue.siftUp(PriorityQueue.java:647)
	at java.util.PriorityQueue.offer(PriorityQueue.java:344)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player1(Abstract_Queue_OfferAndPoll_Test.java:37)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player1(PriorityQueue_OfferAndPoll_Test.java:33)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker1.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:219)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:148)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:181)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$0(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:72)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$13/1095044979.call(Unknown Source)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@43b08d8f timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@35dfd5a timeout cancelled task, cancellation result =true
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@43b08d8f already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@35dfd5a already cancelled
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
	at java.util.PriorityQueue.siftDownComparable(PriorityQueue.java:703)
	at java.util.PriorityQueue.siftDown(PriorityQueue.java:689)
	at java.util.PriorityQueue.poll(PriorityQueue.java:595)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player2(Abstract_Queue_OfferAndPoll_Test.java:53)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player2(PriorityQueue_OfferAndPoll_Test.java:38)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker2.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:231)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:148)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:181)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$1(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:76)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$14/375142620.call(Unknown Source)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
	at java.util.PriorityQueue.siftDownComparable(PriorityQueue.java:701)
	at java.util.PriorityQueue.siftDown(PriorityQueue.java:689)
	at java.util.PriorityQueue.poll(PriorityQueue.java:595)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player2(Abstract_Queue_OfferAndPoll_Test.java:53)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player2(PriorityQueue_OfferAndPoll_Test.java:38)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker2.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:231)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:148)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:181)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$1(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:76)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$14/375142620.call(Unknown Source)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_6,10,main] -> worker exit 
[linearisability] Thread[Pool_Thread_5,10,main] -> worker exit 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> worker exit 
[linearisability] Thread[Pool_Thread_6,10,main] -> worker exit 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_6,10,main] -> Player 1 throws Exception 
[linearisability] Thread[Pool_Thread_5,10,main] exception 
[linearisability] Thread[Pool_Thread_6,10,main] exception 
java.lang.NullPointerException
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> Player 2 throws Exception
[linearisability] Thread[Pool_Thread_5,10,main] exception 
java.lang.NullPointerException
[linearisability] Thread[Pool_Thread_5,10,main] -> worker exit 
[linearisability] Thread[Pool_Thread_6,10,main] -> worker exit 
[linearisability] Thread[Scheduler_Thread_1,10,main] -> 

	Summary of Test PriorityQueue_OfferAndPoll_Test (PriorityQueue Offer and Poll Test) :- 

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/queue/OfferAndPoll_Test.md

	Id        Count               Expectation         Description                                                                                         
	--------  -----------------   ------------------  ---------------------------------                                                                   
	[0,-1]    37                  FORBIDDEN           Exception observed, size is not good                                                                
	[-1,1]    38,063              FORBIDDEN           FIFO not observed, size is good                                                                     
	[-1,0]    0                   FORBIDDEN           FIFO not observed, exception observed                                                               
	[1,-1]    0                   FORBIDDEN           FIFO observed, size is not good                                                                     
	[1,0]     0                   FORBIDDEN           FIFO observed, exception observed                                                                   
	[0,1]     0                   FORBIDDEN           Exception observed, size is good                                                                    
	[1,1]     0                   ACCEPTABLE          FIFO observed, size is good                                                                         
	[0,0]     0                   FORBIDDEN           Exception observed                                                                                  


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
