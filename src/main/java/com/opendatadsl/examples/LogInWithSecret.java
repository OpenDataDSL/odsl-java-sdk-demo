package com.opendatadsl.examples;

import com.opendatadsl.odsl.var.Var;

import sdk.ODSL;

public class LogInWithSecret {
    static String tenant = System.getenv("ODSL_TENANT");
    static String appid = System.getenv("ODSL_APP_ID");
    static String secret = System.getenv("ODSL_APP_SECRET");

    public static void main(String[] args) {
        ODSL odsl = new ODSL();
        odsl.loginWithSecret(tenant, appid, secret);

		Var var = odsl.get("data", "public", "#ABN_FX.EURGBP:SPOT");
		System.out.println(var);
    }

}
