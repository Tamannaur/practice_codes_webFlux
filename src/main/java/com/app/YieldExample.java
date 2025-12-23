package com.app;

public class YieldExample {
    public static void main(String[] args) {
        Runnable r = ()->{
            int i = 0;
            while (i++<2){
                System.out.println(Thread.currentThread().getName()+" : "+i);
                Thread.yield();
            }
        };
        Thread t1 = new Thread(r,"Thread-1");
        Thread t2 = new Thread(r,"Thread-2");
        t1.start();
        t2.start();
    }
}
