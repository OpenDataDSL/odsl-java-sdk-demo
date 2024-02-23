package com.opendatadsl.examples;

import com.opendatadsl.function.CurveFunctions;
import com.opendatadsl.odsl.var.basic.VarDynamicObject;
import com.opendatadsl.odsl.var.curve.VarCurve;

import sdk.ODSL;

public class ReadCurveDeriveNewUpdate {
    public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.login();

		// Read ICE Settle curve
		VarCurve var = (VarCurve) odsl.get("data", "private", "ICE.EL.NLB:SETTLE:2023-10-20");

		// Bootstrap to arbitrage free monthly curve
		VarCurve curve = new CurveFunctions().bootstrapCurve(odsl.getContext(), var);
		curve.setId("ICE_BOOTSTRAPPED");

		// Save back to ODSL
		VarDynamicObject AAA = new VarDynamicObject("AAA");
		AAA.add(curve);
		odsl.update("object", "private", AAA);
    }
}
