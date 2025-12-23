package com.app;

public class Thread_Wait_Notify {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t = new Thread(()->{
            synchronized (lock){
                try {
                    System.out.println("Thread_Wait...");
                    lock.wait();
                    System.out.println("Thread_completed");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Runnable r = ()->{
            synchronized (lock){
                System.out.println("Thread is notifying");
                lock.notify();
            }
        };

        t.start();
        new Thread(r).start();
    }
}
