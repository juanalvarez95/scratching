package com.tevolvers.scratchingfallabelashop.utils;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Variable {
    private static Variable instance = null;
    private EnvironmentVariables environmentVariables;

    private Variable() {
        environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    }

    public static Variable fromProperties() {
        if (instance == null) {
            instance = new Variable();
        }
        return instance;
    }

    public String getValue(String key) {
        return environmentVariables.getProperty(key);
    }
}
