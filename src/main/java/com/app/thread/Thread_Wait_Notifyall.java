package com.app.thread;

public class Thread_Wait_Notifyall {
    public static void main(String[] args) {
        Object object = new Object();
        Thread t1 = new Thread(()->{
            synchronized (object){
                try{
                    System.out.println("Thread1 is starting");
                    object.wait();
                    System.out.println("Thread1 is completed");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (object){
                try{
                    System.out.println("Thread2 is starting");
                    object.wait();
                    System.out.println("Thread2 is completed");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Runnable r = ()->{
            synchronized (object){
                System.out.println("Threads are notifying");
                object.notifyAll();
            }
        };

        t1.start();
        new Thread(r).start();
        t2.start();
    }
}
