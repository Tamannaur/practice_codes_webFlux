package com.app.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private final Semaphore semaphore =  new Semaphore(2);

    public void accessSharedResource(String threadName){
        try {
            System.out.println("Accessing shared resource " + threadName);
            semaphore.acquire();
            System.out.println(threadName+ "Got permit");

            Thread.sleep(2000);

            System.out.println(threadName + " is releasing the permit.");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
    public static void main(String[] args) {
        SemaphoreExample semaphoreExample = new SemaphoreExample();
        for (int i =0; i<5; i++){
            String threadName = "Thread-"+i;
            new Thread(()->semaphoreExample.accessSharedResource(threadName)).start();
        }
    }
}
