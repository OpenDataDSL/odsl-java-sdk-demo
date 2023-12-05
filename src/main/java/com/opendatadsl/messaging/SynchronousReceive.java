package com.opendatadsl.messaging;

import com.walkfares.odsl.var.Var;
import com.walkfares.odsl.var.VariableParser;
import com.walkfares.odsl.var.basic.VarList;

import sdk.CurveManager;
import sdk.Messaging;
import sdk.ODSL;

public class SynchronousReceive {
    public static void main(String[] args) {
        ODSL odsl = new ODSL();        
        odsl.setStage("dev");
        odsl.login();

        Messaging messaging = odsl.messaging();
        CurveManager curveManager = odsl.curveManager();
        String message = messaging.waitForMessage("etrm");
        Var var = new VariableParser().setContext(odsl.getContext()).toVar(message);
        VarList curves = var.LIST();
        for (Var v : curves.getElements()) {
            System.out.println("Got curve: " + v.getId());
            curveManager.markExportComplete("etrm", v.getId());
        }
        System.out.println("All curves marked complete");
    }
}
