package com.opendatadsl.examples;

import com.walkfares.odsl.var.Var;

import sdk.ODSL;

public class ReadMasterData {
    public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.setStage("local");
        odsl.login();

		Var var = odsl.get("object", "private", "ICE.EL.NLB");
		System.out.println(var);
    }
	
}
