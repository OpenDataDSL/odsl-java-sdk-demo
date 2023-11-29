package com.opendatadsl.examples;

import com.walkfares.odsl.var.Var;
import com.walkfares.odsl.var.basic.VarDynamicObject;

import sdk.ODSL;

public class ReadMasterData {
    public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.setStage("local");
        odsl.login();

		Var var = odsl.get("object", "private", "ICE.EL.NLB");
        VarDynamicObject vdo = (VarDynamicObject) var;
		System.out.println(vdo.getProperties());
    }
	
}
