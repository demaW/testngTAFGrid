package com.demchyk.home.core;

import org.openqa.selenium.WebDriver;

public class DriverProvider {
    private static WebDriver driverInstance;

    private DriverProvider(){}

    public static WebDriver getDriver(){
        if (driverInstance == null){
            DriverFactory driverFactory = new DriverFactory();
            driverInstance = driverFactory.getDriverVersion();
        }
        return driverInstance;
    }

    public static void closeDriver() {
        if (driverInstance != null) {
            driverInstance.close();
            driverInstance.quit();
            driverInstance = null;
        }
    }
}
