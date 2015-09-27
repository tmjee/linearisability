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

## Issues
- line 3. flag is volatile, but this is only for the reference of boolean[] array, not each entry in it
- line 10. piggybacking is not right
- line 14, piggybacking is not right


## Piggybacking 
Following is a two cone diagram from jeremy manson's blog[1]
```
 \                           /
  \                         /
   \  other writes / reads /
    \ volatile write      /
      -------------------
                          happens-before
                                       ------------------
                                     /   volatile read    \
                                   /  other writes /reads  \
                                 /                          \
```

Some of my understandings
- volatile write in java issues a full memory barrier 
- volatile write (write release) happens before volatile read (read acquire)
- volatile read will not only see the previous latest volatile write but also all 'other writes / reads'
because volatile write is translated to a full memory barrier.


## Changes 
```java
// Peterson Lock changes
1.  class Peterson implements Lock {
2.      // thread-local index 0 or 1
3.      private volatile boolean[] flag = new boolean[2];
4.      private volatile int victim;
5.      public void lock() {
6.        int i = ThreadID.get();
7.        int j = 1-i;
8.        flag[i] = true; // i'm interested
9.        victim = i;     // (write release) you go first
10.       while(/* read acquire */ victim == i && flag[j]) {}; // wait
11.     }
12.     public void unlock() {
13.       int i = ThreadID.get();
14.       flag[i] = false; // i'm not interested
15.       victim = i; // (write release) 
16.     }
17. }
```

| Line | Description |
| 9.  | Write release, to make sure that `flag[i]= true1` is available in main memory|
| 10. | Read acquire first by doing `victim == i`, so when we do `flag[j]`, we get the latest from main memory|
| 15. | Write release, so that `flat[i] = false` is written to main memory|


## References
[1] - http://jeremymanson.blogspot.com.au/2008/11/what-volatile-means-in-java.html
