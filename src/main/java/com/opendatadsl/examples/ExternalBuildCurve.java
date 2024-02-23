package com.opendatadsl.examples;

import sdk.*;
import com.opendatadsl.odsl.var.curve.*;

public class ExternalBuildCurve {
    public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.login();

        Messaging messaging = odsl.messaging();
        CurveBuildMessage build = messaging.waitForCurveBuildMessage("matlab");
        VarCurve curve = build.createCurve();
        CurveBuildLog log = build.getLogger();
        log.info("Starting Curve Build");

        try {
            // Add some data
            VarCurve base = build.get("BASE");
            for (VarContract vc : base.getContracts().contracts()) {
                double newval = vc.getDoubleValue() * 1.1;
                vc.setDoubleValue(newval);
                curve.add(vc);
            }

            // Save the curve
            log.info("Finished Curve Build");
            log.info("Saving Curve");
            build.saveCurve(curve);

            // Mark the build as complete
            log.complete();
        } catch (Exception e) {
            // Mark the build as failed
            log.failed(e.getMessage());
        }
    }

}
