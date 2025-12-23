package com.app.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(()->"Tamannaur")
                .thenApply(val-> val+" Aktar")
                .thenApply(val-> val + " Hussain")
                .exceptionally(Throwable::getMessage) //.exceptionally(e->e.getMessage())
                .thenAccept(System.out::println);


        //

        CompletableFuture<String> s1 = CompletableFuture.supplyAsync(() -> "Tamannaur")
                .thenApply(val -> val + " Aktar");

        CompletableFuture<String> s2 = CompletableFuture.supplyAsync(() -> " Hussain");

        CompletableFuture<String> res = s1.thenCombine(s2, (val1, val2) -> val1 + val2);
        res.exceptionally(Throwable::getMessage);
        System.out.println(res.join());

        //

    }
}
