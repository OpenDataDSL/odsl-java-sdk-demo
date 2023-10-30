package com.opendatadsl.messaging;

import java.util.function.Consumer;

import com.azure.messaging.servicebus.ServiceBusErrorContext;

public class ErrorProcessor implements Consumer<ServiceBusErrorContext> {

	@Override
	public void accept(ServiceBusErrorContext context) {
		System.err.println("Error occurred while receiving message: " + context.getException());
	}
	
}
