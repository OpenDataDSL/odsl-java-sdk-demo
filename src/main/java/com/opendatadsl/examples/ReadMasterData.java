package com.opendatadsl.examples;

import com.opendatadsl.odsl.var.Var;
import com.opendatadsl.odsl.var.basic.VarDynamicObject;

import sdk.ODSL;

public class ReadMasterData {
    public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.login();

		Var var = odsl.get("object", "private", "ICE.EL.NLB");
        VarDynamicObject vdo = (VarDynamicObject) var;
		System.out.println(vdo.getProperties());
    }
	
}
