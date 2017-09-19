package com.demchyk.home;

import com.demchyk.home.core.DriverProvider;
import com.demchyk.home.utils.PropertyController;
import com.demchyk.home.utils.exceptions.NoSuchPropertyException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    private static final String RESOURCES_PATH = "resources";
    Logger logger = Logger.getLogger(BaseClass.class);

    @BeforeSuite
    public void cleanUp() {
        //handleResourcesDir();
        DriverProvider.getDriver().manage().timeouts().pageLoadTimeout(Long.parseLong(PropertyController.readProperty(
                PropertyController.DRIVER_PAGE_LOAD_WAIT)), TimeUnit.SECONDS);
        DriverProvider.getDriver().manage().timeouts().implicitlyWait(Long.parseLong(PropertyController.readProperty(
                PropertyController.DRIVER_WAIT_IMPLICITLY)), TimeUnit.SECONDS);
    }

    private void handleResourcesDir() {
        logger.info("resource dir about to be cleared");
        File directory = new File(RESOURCES_PATH);
        if (!directory.exists()){
            directory.mkdir();
        }
        try {
            FileUtils.cleanDirectory(new File(RESOURCES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("resource dir cleared");
    }
}
