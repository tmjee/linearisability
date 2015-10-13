# Linearisable 
Informally, all executions must occured indivisably, take effect some time between start
and end of execution and occurred in real time order unless interleaved.

- if every method is `synchronzied`
- if every field is `volatile`

Then the java program can be said to be Lineraisable, because there exists a global 
happens-before relationship between all methods invocation and field access.


# Sequentially Consistency
Informally, every thread sees the executions as if they happens in program order.

- if each thread has a lock
- if every method the thread calls is `synchronized` against that lock
- if every field access is `synchronized` against that lock

Then the java program can be said to be sequentially consistent, because there exists a 
happens-before relationship that prevents ordering between invocations/executions in 
a particular thread.



# Quiescent Consistency
Informally, every executions could be order in anyway as long as those executions that 
happens before the quiescent period happens before it and those that happens after the 
quiescent period happens after it. Quiescent period is a period where there is no open 
call.

I'm not sure how this gets translated to java code.

```java
Phaser phaser = new Phaser();

public void doAndAwaitQuiescentPeriod(Runnable r) {
    phaser.register();
    r.run();
    phaser.arriveAndAwaitAdvance();
}
```

To run a series of executions and then trigger a Quiescent Period we do 
```java

new Thread(()->{
  doAndAwaitQuiescentPeriod(()->{
     execution1();
     execution2();
     execution3();
  });
}).start();

new Thread(()->{
  doAndAwaitQuiescentPeriod(()->{
    execution4();
    execution5();
    execution6();
  });
}).start();
 
```




