package com.opendatadsl.examples;

import com.walkfares.calendar.UTCDate;
import com.walkfares.odsl.var.VarExpiryCalendar;
import com.walkfares.odsl.var.basic.VarDynamicObject;
import com.walkfares.odsl.var.curve.VarCurve;
import com.walkfares.odsl.var.curve.VarCurveDate;

import sdk.ODSL;

public class UpdateCurve {
	public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.setStage("local");
        odsl.login();

		VarExpiryCalendar expcal = odsl.getContext().getExpiryCalendarCache().get("#RDCEM");
		VarCurveDate ondate = new VarCurveDate(UTCDate.of(2023, 10, 26), expcal);
		VarCurve curve = new VarCurve("C", ondate);

		curve.add("M01", "12.1");
		curve.add("M02", "12.2");
		curve.add("M03", "12.3");
		curve.add("M04", "12.4");
		curve.add("M05", "12.5");
		curve.add("M06", "12.6");

		VarDynamicObject AAA = new VarDynamicObject("AAA");
		AAA.add(curve);
		odsl.update("object", "private", AAA);
    }
}
