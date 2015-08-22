# OfferAndPoll

## Summary
 *  Player 1 'offered' the queue 5000 (sequential starting with zero) entries.
 *  Player 2 'poll' the queue for 3000 entries. Player 2 should get 0 to 2999 as
 *  queue is FIFO.
 *  Arbiter validates the size of the queue. It should be 2000 (5000 - 3000).
 *  Player 1 and 2 are run concurrently while Arbiter is run only after both
 *  player 1 and 2 have ended. A barrier exists to make sure both player ended
 *  before Arbiter starts.

## Output

### PriorityQueue
```
./run_Queue_OfferAndPoll_PriorityQueue.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test PriorityQueue_OfferAndPoll_Test - PriorityQueue Offer and Poll Test
[linearisability] Thread[Scheduler_Thread_1,10,main] -> verification run ok
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #0
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.ExecutionException: java.lang.NullPointerException
	at java.util.concurrent.FutureTask.report(FutureTask.java:122)
	at java.util.concurrent.FutureTask.get(FutureTask.java:206)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:107)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.internalRun(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:79)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:46)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1763847188.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.NullPointerException
	at java.lang.Integer.compareTo(Integer.java:1216)
	at java.lang.Integer.compareTo(Integer.java:52)
	at java.util.PriorityQueue.siftUpComparable(PriorityQueue.java:656)
	at java.util.PriorityQueue.siftUp(PriorityQueue.java:647)
	at java.util.PriorityQueue.offer(PriorityQueue.java:344)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player1(Abstract_Queue_OfferAndPoll_Test.java:36)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player1(PriorityQueue_OfferAndPoll_Test.java:33)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker1.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:211)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:140)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:173)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$0(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:64)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$13/1403102367.call(Unknown Source)
	... 4 more
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@22cb1a1c cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:107)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.internalRun(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:79)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:46)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1763847188.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.ExecutionException: java.lang.NullPointerException
	at java.util.concurrent.FutureTask.report(FutureTask.java:122)
	at java.util.concurrent.FutureTask.get(FutureTask.java:206)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:107)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.internalRun(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:79)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:46)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1763847188.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.NullPointerException
	at java.lang.Integer.compareTo(Integer.java:1216)
	at java.lang.Integer.compareTo(Integer.java:52)
	at java.util.PriorityQueue.siftUpComparable(PriorityQueue.java:656)
	at java.util.PriorityQueue.siftUp(PriorityQueue.java:647)
	at java.util.PriorityQueue.offer(PriorityQueue.java:344)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player1(Abstract_Queue_OfferAndPoll_Test.java:36)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player1(PriorityQueue_OfferAndPoll_Test.java:33)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker1.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:211)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:140)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:173)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$0(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:64)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$13/1403102367.call(Unknown Source)
	... 4 more
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.CancellationException
	at java.util.concurrent.FutureTask.report(FutureTask.java:121)
	at java.util.concurrent.FutureTask.get(FutureTask.java:206)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:107)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.internalRun(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:79)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:46)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1763847188.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #1
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.ExecutionException: java.lang.NullPointerException
	at java.util.concurrent.FutureTask.report(FutureTask.java:122)
	at java.util.concurrent.FutureTask.get(FutureTask.java:206)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:107)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.internalRun(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:79)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:46)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1763847188.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.NullPointerException
	at java.lang.Integer.compareTo(Integer.java:1216)
	at java.lang.Integer.compareTo(Integer.java:52)
	at java.util.PriorityQueue.siftUpComparable(PriorityQueue.java:656)
	at java.util.PriorityQueue.siftUp(PriorityQueue.java:647)
	at java.util.PriorityQueue.offer(PriorityQueue.java:344)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player1(Abstract_Queue_OfferAndPoll_Test.java:36)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player1(PriorityQueue_OfferAndPoll_Test.java:33)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker1.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:211)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:140)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:173)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$0(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:64)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$13/1403102367.call(Unknown Source)
	... 4 more
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.ExecutionException: java.lang.NullPointerException
	at java.util.concurrent.FutureTask.report(FutureTask.java:122)
	at java.util.concurrent.FutureTask.get(FutureTask.java:206)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:107)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.internalRun(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:79)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:46)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1763847188.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.NullPointerException
	at java.util.PriorityQueue.siftDownComparable(PriorityQueue.java:703)
	at java.util.PriorityQueue.siftDown(PriorityQueue.java:689)
	at java.util.PriorityQueue.poll(PriorityQueue.java:595)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player2(Abstract_Queue_OfferAndPoll_Test.java:49)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player2(PriorityQueue_OfferAndPoll_Test.java:38)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker2.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:223)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:140)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:173)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$1(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:68)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$14/975709521.call(Unknown Source)
	... 4 more
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #2
[linearisability] Thread[Scheduler_Thread_1,10,main] -> future java.util.concurrent.FutureTask@24a70556 cancel=true
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:107)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.internalRun(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:79)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:46)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1763847188.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.ExecutionException: java.lang.NullPointerException
	at java.util.concurrent.FutureTask.report(FutureTask.java:122)
	at java.util.concurrent.FutureTask.get(FutureTask.java:206)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:107)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.internalRun(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:79)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:46)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1763847188.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.NullPointerException
	at java.util.PriorityQueue.siftDownComparable(PriorityQueue.java:703)
	at java.util.PriorityQueue.siftDown(PriorityQueue.java:689)
	at java.util.PriorityQueue.poll(PriorityQueue.java:595)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player2(Abstract_Queue_OfferAndPoll_Test.java:49)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player2(PriorityQueue_OfferAndPoll_Test.java:38)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker2.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:223)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:140)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:173)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$1(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:68)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$14/975709521.call(Unknown Source)
	... 4 more
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.CancellationException
	at java.util.concurrent.FutureTask.report(FutureTask.java:121)
	at java.util.concurrent.FutureTask.get(FutureTask.java:206)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:107)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.internalRun(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:79)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:46)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1763847188.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #3
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.ExecutionException: java.lang.NullPointerException
	at java.util.concurrent.FutureTask.report(FutureTask.java:122)
	at java.util.concurrent.FutureTask.get(FutureTask.java:206)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:107)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.internalRun(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:79)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:46)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1763847188.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.NullPointerException
	at java.lang.Integer.compareTo(Integer.java:1216)
	at java.lang.Integer.compareTo(Integer.java:52)
	at java.util.PriorityQueue.siftUpComparable(PriorityQueue.java:656)
	at java.util.PriorityQueue.siftUp(PriorityQueue.java:647)
	at java.util.PriorityQueue.offer(PriorityQueue.java:344)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player1(Abstract_Queue_OfferAndPoll_Test.java:36)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player1(PriorityQueue_OfferAndPoll_Test.java:33)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker1.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:211)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:140)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:173)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$0(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:64)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$13/1403102367.call(Unknown Source)
	... 4 more
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.ExecutionException: java.lang.NullPointerException
	at java.util.concurrent.FutureTask.report(FutureTask.java:122)
	at java.util.concurrent.FutureTask.get(FutureTask.java:206)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:107)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.internalRun(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:79)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:46)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1763847188.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.NullPointerException
	at java.util.PriorityQueue.siftDownComparable(PriorityQueue.java:703)
	at java.util.PriorityQueue.siftDown(PriorityQueue.java:689)
	at java.util.PriorityQueue.poll(PriorityQueue.java:595)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player2(Abstract_Queue_OfferAndPoll_Test.java:49)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player2(PriorityQueue_OfferAndPoll_Test.java:38)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker2.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:223)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:140)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:173)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$1(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:68)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$14/975709521.call(Unknown Source)
	... 4 more
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.ExecutionException: java.lang.NullPointerException
	at java.util.concurrent.FutureTask.report(FutureTask.java:122)
	at java.util.concurrent.FutureTask.get(FutureTask.java:206)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:107)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.internalRun(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:79)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:46)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1763847188.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.NullPointerException
	at java.lang.Integer.compareTo(Integer.java:1216)
	at java.lang.Integer.compareTo(Integer.java:52)
	at java.util.PriorityQueue.siftUpComparable(PriorityQueue.java:656)
	at java.util.PriorityQueue.siftUp(PriorityQueue.java:647)
	at java.util.PriorityQueue.offer(PriorityQueue.java:344)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player1(Abstract_Queue_OfferAndPoll_Test.java:36)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player1(PriorityQueue_OfferAndPoll_Test.java:33)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker1.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:211)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:140)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:173)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$0(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:64)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$13/1403102367.call(Unknown Source)
	... 4 more
[linearisability] Thread[Scheduler_Thread_1,10,main] exception
java.util.concurrent.ExecutionException: java.lang.NullPointerException
	at java.util.concurrent.FutureTask.report(FutureTask.java:122)
	at java.util.concurrent.FutureTask.get(FutureTask.java:206)
	at com.tmjee.linearisation.processor.Runner.waitFor(Runner.java:107)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.internalRun(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:79)
	at com.tmjee.linearisation.processor.Runner.run(Runner.java:46)
	at com.tmjee.linearisation.processor.Linearisation$2.run(Linearisation.java:57)
	at com.tmjee.linearisation.processor.Scheduler.lambda$schedule$4(Scheduler.java:51)
	at com.tmjee.linearisation.processor.Scheduler$$Lambda$12/1763847188.run(Unknown Source)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.NullPointerException
	at java.util.PriorityQueue.siftDownComparable(PriorityQueue.java:703)
	at java.util.PriorityQueue.siftDown(PriorityQueue.java:689)
	at java.util.PriorityQueue.poll(PriorityQueue.java:595)
	at com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test$AbstractTestUnit._player2(Abstract_Queue_OfferAndPoll_Test.java:49)
	at com.tmjee.linearisation.sample.PriorityQueue_OfferAndPoll_Test$TestUnit1.player2(PriorityQueue_OfferAndPoll_Test.java:38)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$Worker2.runPlayerAction(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:223)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.runPlayer(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:140)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$BaseWorker.run(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:173)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.lambda$internalRun$1(PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner.java:68)
	at linearisation.generated.PriorityQueue_OfferAndPoll_Test_TestUnit1_Runner$$Lambda$14/975709521.call(Unknown Source)
	... 4 more
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test PriorityQueue_OfferAndPoll_Test (PriorityQueue Offer and Poll Test) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/queue/OfferAndPoll_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[-1,1]    0                   FORBIDDEN           FIFO not observed, size is good
	[1,-1]    0                   FORBIDDEN           FIFO observed, size is not good
	[1,1]     0                   ACCEPTABLE          FIFO observed, size is good


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```


### ConcurrentLinkedQueue
```
./run_Queue_OfferAndPoll_ConcurrentLinkedQueue.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test ConcurrentLinkedQueue_OfferAndPoll_Test - ConcurrentLinkedQueue Offer and Poll Test
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
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test ConcurrentLinkedQueue_OfferAndPoll_Test (ConcurrentLinkedQueue Offer and Poll Test) :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/queue/OfferAndPoll_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[-1,1]    63,500              FORBIDDEN           FIFO not observed, size is good
	[1,-1]    0                   FORBIDDEN           FIFO observed, size is not good
	[1,1]     0                   ACCEPTABLE          FIFO observed, size is good


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```


### ArrayBlockingQueue
```
./run_Queue_OfferAndPoll_ArrayBlockingQueue.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test ArrayBlockingQueue_OfferAndPoll_Test -
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
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] -> iteration #4
[linearisability] Thread[Pool_Thread_1,10,main] -> worker exit
[linearisability] Thread[Pool_Thread_2,10,main] -> worker exit
[linearisability] Thread[Scheduler_Thread_1,10,main] ->

	Summary of Test ArrayBlockingQueue_OfferAndPoll_Test () :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/queue/OfferAndPoll_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[-1,1]    31,500              FORBIDDEN           FIFO not observed, size is good
	[1,-1]    0                   FORBIDDEN           FIFO observed, size is not good
	[1,1]     0                   ACCEPTABLE          FIFO observed, size is good


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```


### LinkedBlockingQueue
```
./run_Queue_OfferAndPoll_LinkedBlockingQueue.sh
[linearisability] Thread[main,5,main] -> Scheduler waiting for tests to finish ...
[linearisability] Thread[Scheduler_Thread_1,10,main] -> Running test LinkedBlockingQueue_OfferAndPoll_Test -
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

	Summary of Test LinkedBlockingQueue_OfferAndPoll_Test () :-

	References:
		- https://github.com/tmjee/linearisability/blob/master/docs/results/queue/OfferAndPoll_Test.md

	Id        Count               Expectation         Description
	--------  -----------------   ------------------  ---------------------------------
	[-1,1]    31,500              FORBIDDEN           FIFO not observed, size is good
	[1,-1]    0                   FORBIDDEN           FIFO observed, size is not good
	[1,1]     0                   ACCEPTABLE          FIFO observed, size is good


[linearisability] Thread[main,5,main] -> Scheduler end.
[linearisability] Thread[main,5,main] -> Shutdown pool ...
[linearisability] Thread[main,5,main] -> Pool end.
[linearisability] Thread[main,5,main] -> Bye !
```
