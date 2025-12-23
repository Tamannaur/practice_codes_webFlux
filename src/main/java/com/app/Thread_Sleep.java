package com.app;

public class Thread_Sleep {
    public static void main(String[] args) {
        Runnable r = ()->{
            try{
                long startTime = System.currentTimeMillis();
                Thread.sleep(1000);
                long endTime = System.currentTimeMillis();

                long duration = endTime - startTime;
                System.out.println("Total duration: "+duration);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        Thread t = new Thread(r);
        t.start();

    }
}
