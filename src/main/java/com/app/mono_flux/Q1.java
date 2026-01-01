package com.app.mono_flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Q1 {
    public static void main(String[] args) {
        String hotel = "Marriott";
        getUpperCase(Mono.just(hotel)).subscribe(System.out::println);

        convertStringToMono(hotel).subscribe(System.out::println);

        List<String> hotels = Arrays.asList("Marriott", "ITC", "Ritz Cartlon");
        convertListToFlux(hotels).subscribe(System.out::println);

        convertStringToFlux("Marriott", "ITC", "Ritz Cartlon")
                .subscribe(System.out::println);

        convertListToFlux(hotels)
                .subscribe(
                    name->System.out.println("Hotel: "+ name),
                    error -> System.out.println("Error: "+error.getMessage()),
                        ()->System.out.println("Completed")
                );

        combineTwoMonos(Mono.just("Marriott"), Mono.just("ITC"))
                .subscribe(System.out::println);
    }
    public static Mono<String> getUpperCase(Mono<String> hotelName){
        return hotelName.map(String::toUpperCase);
    }

    public static Mono<String> convertStringToMono(String hotelName){
        return Mono.just(hotelName.toUpperCase());
    }

    public static Flux<String> convertListToFlux(List<String> hotelNames){
        return Flux.fromIterable(hotelNames);
    }

    public static Flux<String> convertStringToFlux(String... hotelNames){
        return Flux.fromIterable(Arrays.asList(hotelNames));
    }

    public static Flux<String> combineTwoMonos(Mono<String> hotelName1, Mono<String> hotelName2){
        return Flux.concat(hotelName1, hotelName2);
    }

    public static Flux<String> combineTwoFluxs(Flux<String> hotelName1, Flux<String> hotelName2){
        return Flux.concat(hotelName1, hotelName2);
    }

    public static Flux<String> convertfromMono(Mono<List<String>> hotelName){
        //return Flux.fromIterable(Objects.requireNonNull(hotelName.block()));
        return hotelName.flatMapMany(Flux::fromIterable);
        //both are correct
    }
    public static Flux<String> convertfromFlux(Flux<List<String>> hotelName){
        return hotelName.flatMap(Flux::fromIterable);
    }

    public static List<String> convertFromMono(Mono<List<String>> hotelName){
        return hotelName.block();
    }
}
