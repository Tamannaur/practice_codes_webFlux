package com.app.problems;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroOddEven {
    public static void main(String[] args) {
        int n = 5;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        IntConsumer intConsumer = x->System.out.println(x);

        Thread t1 = new Thread(()->{
            try {
                zeroEvenOdd.zero(intConsumer);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                zeroEvenOdd.odd(intConsumer);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(()->{
            try {
                zeroEvenOdd.even(intConsumer);
            }catch (InterruptedException e){}
        });
        t1.start();
        t2.start();
        t3.start();

    }
}
class ZeroEvenOdd {
    private int n;
    private Semaphore zero,even, odd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        zero = new Semaphore(1);
        even = new Semaphore(0);
        odd = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if(i%2 == 0){
                even.release();
            }else{
                odd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2; i<=n; i+=2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i+=2){
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}
