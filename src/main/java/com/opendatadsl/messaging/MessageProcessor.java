package com.opendatadsl.messaging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;

import org.joda.time.LocalDateTime;

import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.messaging.servicebus.ServiceBusReceivedMessageContext;

public class MessageProcessor implements Consumer<ServiceBusReceivedMessageContext> {

	@Override
	public void accept(ServiceBusReceivedMessageContext context) {
		ServiceBusReceivedMessage message = context.getMessage();
		String subject = message.getSubject();
		String content = message.getBody().toString();
		String contenttype = message.getContentType();
		String filename = subject + "_" + new LocalDateTime().toString().replace(":", "-");
		if (contenttype.equals("application/xml"))
			filename += ".xml";
		if (contenttype.equals("text/ssv"))
			filename += ".csv";
		try {
			Files.write(Path.of(filename), content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
