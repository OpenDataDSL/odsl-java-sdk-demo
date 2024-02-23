package com.opendatadsl.realtime;

import sdk.ODSL;
import sdk.RTD;

public class CurveManagementExample {
	public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.login();

		RTD rtd = odsl.RTD();
		rtd.connect();
		rtd.addMessageHandler("OnCurveMessage", new RTDProcessor());
		
		// Subscribe to the curve management messages for an ondate
		rtd.subscribe("curve", "2023-11-27");
    }
}
