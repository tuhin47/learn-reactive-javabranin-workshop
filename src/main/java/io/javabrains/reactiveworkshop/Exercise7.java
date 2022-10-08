package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        ReactiveSources.intNumbersFlux().log().filter(integer -> integer > 5).subscribe(System.out::println);

        // Print 10 times each value from intNumbersFlux that's greater than 5
        ReactiveSources.intNumbersFlux().filter(integer -> integer > 5).map(integer -> integer*10).subscribe(System.out::println);

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        ReactiveSources.intNumbersFlux().filter(integer -> integer > 5).take(3).subscribe(integer -> System.out.println("integer = " + integer));

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        ReactiveSources.intNumbersFlux().filter(integer -> integer > 20).defaultIfEmpty(-1).subscribe(integer -> System.out.println("integer = " + integer));

        // Switch ints from intNumbersFlux to the right user from userFlux
        ReactiveSources.intNumbersFlux().flatMap(integer -> ReactiveSources.userFlux().filter(user -> integer.equals(user.getId()))).subscribe(user -> System.out.println("user = " + user));
        // Print only distinct numbers from intNumbersFluxWithRepeat
        ReactiveSources.intNumbersFluxWithRepeat().distinct().subscribe(integer -> System.out.println("integer = " + integer));

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        ReactiveSources.intNumbersFluxWithRepeat().distinctUntilChanged().subscribe(integer -> System.out.println("integer = " + integer));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
