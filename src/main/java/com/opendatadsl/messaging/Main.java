package com.opendatadsl.messaging;

import sdk.ODSL;
import sdk.Messaging;

public class Main {
    public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.login();

        Messaging messaging = odsl.messaging();
        messaging.receiveAndDelete("exports", new MessageProcessor(), new ErrorProcessor());
    }
}