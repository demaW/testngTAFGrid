package com.demchyk.home.utils;

import com.demchyk.home.utils.exceptions.NoSuchPropertyException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyController {
    private static final Logger logger = Logger.getLogger(PropertyController.class);

    public static final String WEBRDIVER = "webdriver.driver.version";
    public static final String CHROMEPATH = "webdriver.chrome.driver";
    public static final String DRIVER_PAGE_LOAD_WAIT = "webdriver.timeout.pageload";
    public static final String DRIVER_WAIT_IMPLICITLY = "webdriver.wait.implicitly";

    private static final String PROPS_PATH = "src/main/resources/conf.properties";

    private static Properties instance;

    private PropertyController() {

    }

    private static Properties getProp() {
        if (instance == null) {
            instance = loadProperties();
        }
        return instance;
    }

    public static String readProperty(String propertyName){
        String prop = getProp().getProperty(propertyName);
        if (prop == null) try {
            throw new NoSuchPropertyException("Property "+ propertyName +" is null");
        } catch (NoSuchPropertyException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return prop;
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        Path propFilePath = Paths.get(PROPS_PATH);
        try {
            logger.info("Getting properties from file");
            InputStream inputStream = Files.newInputStream(propFilePath);
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Config file was now found... " + e.getMessage());
            e.printStackTrace();
        }
        return properties;
    }
}