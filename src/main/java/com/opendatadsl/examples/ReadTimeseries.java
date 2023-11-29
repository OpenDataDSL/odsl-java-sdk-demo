package com.opendatadsl.examples;

import com.walkfares.odsl.var.timeseries.VarTimeSeries;

import sdk.ODSL;

public class ReadTimeseries {
	    public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.setStage("local");
        odsl.login();

		VarTimeSeries var = (VarTimeSeries) odsl.get("data", "private", "ICE.EL.NLB:SETTLE:M01");
		System.out.println(var.getValues());
    }
}
