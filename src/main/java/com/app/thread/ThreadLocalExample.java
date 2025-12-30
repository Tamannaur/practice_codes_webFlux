package com.app.thread;

public class ThreadLocalExample {
    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = ()->{
            String threadName = "Thread-"+Thread.currentThread().getId();
            threadLocal.set(threadLocal.get() + 1);
            System.out.println(threadName + " Value: "+ threadLocal.get());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

    }
}
