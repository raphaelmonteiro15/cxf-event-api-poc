package com.raphaelmonteiro;

import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Flow.Subscriber;

public class MySubscriber implements Subscriber<Employee> {

    private Subscription subscription;
    private int counter = 0;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.counter++;
        subscription.request(1);
        System.out.println("Requested 1 item");
    }

    @Override
    public void onNext(Employee item) {
        System.out.println("Processing next item " + item);
        this.counter++;
        this.subscription.request(1);

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {
        System.out.println("All done");
    }

    public int getCounter(){
        return this.counter;
    }
}
