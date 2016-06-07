package com.raphaelmonteiro.examples;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MyActor extends UntypedActor {
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object message) throws Exception {
		if(message instanceof Integer)
			getSender().tell((Integer)message * 2, getSelf());
		else
			unhandled(message);
	}
	
}
