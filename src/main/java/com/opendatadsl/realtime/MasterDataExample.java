package com.opendatadsl.realtime;

import sdk.ODSL;
import sdk.RTD;

public class MasterDataExample {
    public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.login();

		RTD rtd = odsl.RTD();
		rtd.connect();
		rtd.addMessageHandler("OnObjectUpdate", new RTDProcessor());
		rtd.addMessageHandler("OnDataUpdate", new RTDProcessor());
		rtd.subscribe("object", "AAA");
    }
}
