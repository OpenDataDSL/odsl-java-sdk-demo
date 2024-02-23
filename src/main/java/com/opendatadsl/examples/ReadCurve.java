package com.opendatadsl.examples;

import com.opendatadsl.function.CurveFunctions;
import com.opendatadsl.odsl.var.curve.VarCurve;

import sdk.ODSL;

public class ReadCurve {
    public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.login();

		VarCurve var = (VarCurve) odsl.get("data", "private", "ICE.EL.NLB:SETTLE:2023-10-20");
		System.out.println(var);

		VarCurve bscurve = new CurveFunctions().bootstrapCurve(odsl.getContext(), var);
		System.out.println(bscurve);
    }
	
}
