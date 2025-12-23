package com.app.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args)  {
        ExecutorService e = Executors.newFixedThreadPool(5);
        try {
            Future<String> res = e.submit(() -> "Result");
            System.out.println(res.get());
        }catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }finally {
            e.shutdown();
        }
    }
}
