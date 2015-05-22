package com.raphaelmonteiro.examples;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class SecondActor extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Exception {
		System.out.println(message.toString());
		final ActorRef actorRef = getContext().actorOf(Props.create(MyActor.class), "simple-actor");
		actorRef.tell(2, getSelf());
	}

}
