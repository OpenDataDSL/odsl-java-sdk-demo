package com.opendatadsl.examples;

import com.opendatadsl.odsl.var.timeseries.VarTimeSeries;

import sdk.ODSL;

public class ReadTimeseries {
	    public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.login();

		VarTimeSeries var = (VarTimeSeries) odsl.get("data", "public", "#ABN_FX.EURGBP:SPOT");
		System.out.println(var.getValues());
    }
}
