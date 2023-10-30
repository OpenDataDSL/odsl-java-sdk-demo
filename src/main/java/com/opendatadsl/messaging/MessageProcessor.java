package com.opendatadsl.messaging;

import java.util.function.Consumer;

import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.messaging.servicebus.ServiceBusReceivedMessageContext;

public class MessageProcessor implements Consumer<ServiceBusReceivedMessageContext> {

	@Override
	public void accept(ServiceBusReceivedMessageContext context) {
		ServiceBusReceivedMessage message = context.getMessage();
		System.out.println(message.getBody().toString());
	}
	
}
