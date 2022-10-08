package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks

        /*ReactiveSources.intNumberMono().subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println(throwable.getMessage()),
                () -> System.out.println("Finally")
        );
        */

        // Subscribe to a flux using an implementation of BaseSubscriber

        BaseSubscriber<Integer> subscriber = new MySubscriber<>();
        ReactiveSources.intNumbersFluxWithException()
                .subscribe(subscriber);
        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        request(1);
    }

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened!");
        request(1);
    }

    @Override
    protected void hookOnError(Throwable throwable) {
        System.out.println("Error happened in MySubscriber " + throwable.getMessage());
        System.exit(5);
    }
}