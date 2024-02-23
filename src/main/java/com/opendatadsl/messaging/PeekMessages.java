package com.opendatadsl.messaging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.joda.time.LocalDateTime;

import com.azure.messaging.servicebus.ServiceBusReceivedMessage;

import sdk.Messaging;
import sdk.ODSL;

public class PeekMessages {
	public static void main(String[] args) {
		ODSL odsl = new ODSL();    
        odsl.login();

        Messaging messaging = odsl.messaging();
		ServiceBusReceivedMessage peekMessage = messaging.peekMessage("exports");
		String subject = peekMessage.getSubject();
		String content = peekMessage.getBody().toString();
		String contenttype = peekMessage.getContentType();
		String filename = subject + "_" + new LocalDateTime().toString().replace(":", "-");
		if (contenttype.equals("application/xml"))
			filename += ".xml";
		try {
			Files.write(Path.of(filename), content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
