package com.demchyk.home.core;

import org.openqa.selenium.WebDriver;

public class DriverProvider {
    private static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();

    private DriverProvider(){}

    public static WebDriver getDriver(){
        if (driverInstance.get() ==null){
            DriverFactory driverFactory = new DriverFactory();
            driverInstance.set(driverFactory.getDriverVersion());
        }
        return driverInstance.get();
    }

    public static void closeDriver() {
        if (driverInstance.get() != null) {
            driverInstance.get().close();
            driverInstance.get().quit();
            driverInstance.set(null);
        }
    }
}
