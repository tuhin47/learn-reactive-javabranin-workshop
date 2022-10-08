package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        ReactiveSources.intNumbersFlux().count().subscribe(aLong -> System.out.println("aLong = " + aLong));

        // Collect all items of intNumbersFlux into a single list and print it
        ReactiveSources.intNumbersFlux().collectList().subscribe(integers -> System.out.println("integers = " + integers));

        // Transform to a sequence of sums of adjacent two numbers
        ReactiveSources.intNumbersFlux()
                .buffer(2)
                .map(integers -> integers.stream().reduce(0, (integer, integer2) -> integer + integer2))
                .subscribe(integer -> System.out.println("integer = " + integer));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
