package com.raphaelmonteiro;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class Main {

    public static void main(String[]args){
        SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();
        MySubscriber subscriber = new MySubscriber();
        publisher.subscribe(subscriber);
        List<Employee> emps = EmpStub.getEmps();
        emps.forEach(e -> publisher.submit(e));
        while(emps.size() != subscriber.getCounter()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        publisher.close();
        System.out.println("Finishing app");
    }
}
