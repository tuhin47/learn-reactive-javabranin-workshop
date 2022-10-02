package io.javabrains.reactiveworkshop;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("\n--- Print all numbers in the intNumbersStream stream: ");
        Consumer<Integer> printInt = integer -> System.out.print(integer+ " ");
        StreamSources.intNumbersStream().forEach(printInt);

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("\n--- Print numbers from intNumbersStream that are less than 5: ");
        Predicate<Integer> lessThan5 = integer -> integer < 5;
        StreamSources.intNumbersStream().filter(lessThan5).forEach(printInt);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("\n--- Print the second and third numbers in intNumbersStream that's greater than 5: ");
        Predicate<Integer> greaterThan5 = integer -> integer > 5;
        StreamSources.intNumbersStream().filter(greaterThan5).forEach(printInt);

        //  Print the first number in intNumbersStream that's greater than 5.  If nothing is found, print -1
        System.out.println("\n--- Print the first number in intNumbersStream that's greater than 5.  If nothing is found, print -1: ");
        System.out.print(StreamSources.intNumbersStream().filter(greaterThan5).findFirst().orElse(-1));

        // Print first names of all users in userStream
        System.out.println("\n--- Print first names of all users in userStream: ");
        Consumer<User> printFirstName = user -> System.out.print(user.getFirstName() + " ");
        StreamSources.userStream().forEach(printFirstName);

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("\n--- Print first names in userStream for users that have IDs from number stream: ");
        BiPredicate<User, Stream<Integer>> idInStream = (user, integerList) -> integerList.anyMatch(integer -> integer.equals(user.getId()));
        StreamSources.userStream().filter(user -> idInStream.test(user,StreamSources.intNumbersStream())).forEach(printFirstName);

    }

}
