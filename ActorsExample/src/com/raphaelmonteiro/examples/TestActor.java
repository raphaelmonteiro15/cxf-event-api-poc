package com.raphaelmonteiro.examples;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class TestActor{

	public static void main (String[]args){
		final ActorSystem actorSystem = ActorSystem.create("actor-system");
		final ActorRef actorRef = actorSystem.actorOf(Props.create(SecondActor.class), "simple-actor");
		
		actorRef.tell(2, null);
		
		System.out.println("Bye");
		actorSystem.shutdown();
	}
}
