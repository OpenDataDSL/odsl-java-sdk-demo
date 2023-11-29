package com.opendatadsl.realtime;

import sdk.ODSL;
import sdk.RTD;

public class CurveExample {
		public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.setStage("local");
        odsl.login();

		RTD rtd = odsl.RTD();
		rtd.connect();
		rtd.addMessageHandler("OnDataCreate", new RTDProcessor());
		rtd.addMessageHandler("OnDataUpdate", new RTDProcessor());
		
		// Subscribe to some data
		rtd.subscribe("data", "AAA:EC:2023-11-28");
		rtd.subscribe("data", "AAA:ECS:2023-11-28");

		// Test unsubscribe
		try {
			Thread.sleep(5000);
			rtd.unSubscribe("data", "AAA:ECS:2023-11-28");
		} catch (Exception e) {}
    }
}
