package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        System.out.println("\nPrint all numbers in the ReactiveSources.intNumbersFlux stream:\n");
        ReactiveSources.intNumbersFlux().subscribe(System.out::println);


        // Print all users in the ReactiveSources.userFlux stream
        System.out.println("\nPrint all users in the ReactiveSources.userFlux stream:\n");
        ReactiveSources.userFlux().subscribe(System.out::println);


        System.out.println("Press a key to end");
        System.in.read();
    }

}
