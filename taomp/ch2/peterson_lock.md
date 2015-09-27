Chapter 2, page 27

```java
// Peterson Lock
1.  class Peterson implements Lock {
2.      // thread-local index 0 or 1
3.      private volatile boolean[] flag = new boolean[2];
4.      private volatile int victim;
5.      public void lock() {
6.        int i = ThreadID.get();
7.        int j = 1-i;
8.        flag[i] = true; // i'm interested
9.        victim = i;     // you go first
10.       while(flag[j] && victim == i) {}; // wait
11.     }
12.     public void unlock() {
13.       int i = ThreadID.get();
14.       flag[i] = false; // i'm not interested
15.     }
16. }
```
