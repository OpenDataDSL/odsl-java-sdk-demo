package com.opendatadsl.examples;

import com.walkfares.calendar.UTCDate;
import com.walkfares.odsl.var.VarExpiryCalendar;
import com.walkfares.odsl.var.basic.VarDynamicObject;
import com.walkfares.odsl.var.curve.VarCurve;
import com.walkfares.odsl.var.curve.VarCurveDate;

import sdk.CurveBuildLog;
import sdk.CurveManager;
import sdk.ODSL;

public class UpdateCurve {
	public static void main(String[] args) {
		// Log in
        ODSL odsl = new ODSL();
        odsl.setStage("local");
        odsl.login();

		// Get the curve manager and create a build log
		CurveManager curveManager = odsl.curveManager();
		CurveBuildLog build = curveManager.startCurveBuild("AAA:C:2023-12-04");

		try {
			// Create the curve basics
			VarExpiryCalendar expcal = odsl.getContext().getExpiryCalendarCache().get("#RDCEM");
			VarCurveDate ondate = new VarCurveDate(UTCDate.of(2023, 12, 4), expcal);
			VarCurve curve = new VarCurve("C", ondate);
			build.addLogMessage("info", "Starting Curve Build");

			// Add some data
			curve.add("M01", "12.1");
			curve.add("M02", "12.2");
			curve.add("M03", "12.3");
			curve.add("M04", "12.4");
			curve.add("M05", "12.5");
			curve.add("M06", "12.6");

			// Save the curve
			build.addLogMessage("info", "Finished Curve Build");
			build.addLogMessage("info", "Saving Curve");
			VarDynamicObject AAA = new VarDynamicObject("AAA");
			AAA.add(curve);
			odsl.update("object", "private", AAA);

			// Mark the build as complete
			build.complete();
		} catch (Exception e) {
			// Mark the build as failed
			build.failed(e.getMessage());
		}
    }
}
