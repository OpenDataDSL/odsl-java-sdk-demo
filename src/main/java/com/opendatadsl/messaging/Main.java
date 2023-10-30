package com.opendatadsl.messaging;

import sdk.ODSL;
import sdk.Messaging;

public class Main {
    public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.setStage("local");
        odsl.login();

        Messaging messaging = odsl.messaging();
        messaging.receiveAndDelete("matlab", new MessageProcessor(), new ErrorProcessor());
    }
}