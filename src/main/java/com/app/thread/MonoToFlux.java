package com.app.thread;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoToFlux {
    public static void main(String[] args) {
//        Flux<String> flux = Flux.just("a", "b", "c");
//        flux.subscribe(System.out::println);
          func().subscribe(System.out::println);
    }

    public static Flux<String> func(){
        Mono<List<String>> res = Mono.just(List.of("a", "b", "c"));
        //res.flatMapMany(list->Flux.fromIterable(list));
        return res.flatMapMany(Flux::fromIterable);
    }
}
