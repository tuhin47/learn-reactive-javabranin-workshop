package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        System.out.println("\n// Print the value from intNumberMono when it emits\n");
        ReactiveSources.intNumberMono().subscribe(System.out::println);

        // Get the value from the Mono into an integer variable
        System.out.println("\n// Get the value from the Mono into an integer variable\n");
        Integer block = ReactiveSources.intNumberMono().block();
        System.out.println(block);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
