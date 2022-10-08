package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;
import java.time.Duration;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        ReactiveSources.intNumbersFluxWithException().subscribe(
                integer -> System.out.println("integer = " + integer),
                throwable -> System.out.println("throwable.getMessage() = " + throwable.getMessage())
        );

        // Print values from intNumbersFluxWithException and continue on errors
        ReactiveSources.intNumbersFluxWithException().onErrorContinue((throwable, o) -> System.out.println("throwable = " + throwable.getMessage()))
                .subscribe(
                        integer -> System.out.println("integer = " + integer));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException().onErrorResume(throwable -> Flux.just(-1, -2).delayElements(Duration.ofMillis(500)))
                .subscribe(integer -> System.out.println("integer = " + integer));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
