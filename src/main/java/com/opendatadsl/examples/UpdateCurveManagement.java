package com.opendatadsl.examples;

import com.opendatadsl.odsl.var.basic.VarSimpleObject;
import sdk.ODSL;

public class UpdateCurveManagement {
		public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.login();

		// Update the export status for a curve build
		VarSimpleObject build = new VarSimpleObject("#MATBAROFEX.AR.CRN.CME.FUT:SETTLE:2023-11-27");
		build.newLevel("status").newLevel("export").set("SAP", "complete");

		odsl.update("curve", "private", build, "build");
    }
}
