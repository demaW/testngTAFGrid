package com.demchyk.home.core;

import com.demchyk.home.utils.PropertyController;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private Logger logger = Logger.getLogger(DriverFactory.class);

    WebDriver getDriverVersion() {
        WebDriver driver;
        String driverVersion = readDriverVersion();
        switch (driverVersion) {
            case "chrome":
                logger.info("Chrome sys var is: " + System.getProperty(PropertyController.CHROMEPATH));
                if (System.getProperty(PropertyController.CHROMEPATH) == null ||
                        System.getProperty(PropertyController.CHROMEPATH).isEmpty()) {
                    System.setProperty(PropertyController.CHROMEPATH, PropertyController.readProperty(PropertyController.CHROMEPATH));
                }
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chromeRemote":
                DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
                driver = null;
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.setProperty(PropertyController.CHROMEPATH, PropertyController.readProperty(PropertyController.CHROMEPATH));
                driver = new ChromeDriver();
        }
        return driver;
    }

    private String readDriverVersion() {
        String version;
        version = PropertyController.readProperty(PropertyController.WEBRDIVER);
        return version;
    }

}
