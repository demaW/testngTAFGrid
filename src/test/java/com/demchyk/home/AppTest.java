package com.demchyk.home;

import com.demchyk.home.buisnessobject.DemoQAMainBO;
import com.demchyk.home.core.DriverProvider;
import org.testng.Assert;
import org.testng.annotations.*;

public class AppTest {
    private DemoQAMainBO demoQAMainBO;

    @BeforeMethod
    public void setUp() {
        DriverProvider.getDriver();
    }

    @Test
    public void method1Test() {
        demoQAMainBO = new DemoQAMainBO();
        demoQAMainBO.open();
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Home".contentEquals(demoQAMainBO.getHeaderText()));
    }

    @Test
    void method2Test() {
        DriverProvider.getDriver().get("http://google.com");
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void method3Test() {
        DriverProvider.getDriver().get("http://bing.com");
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    void method4Test() {
        DriverProvider.getDriver().get("http://yahoo.com");
        try {
            Thread.sleep(12200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterMethod
    public void closeDriver() {
        if (DriverProvider.getDriver() != null) {
            DriverProvider.closeDriver();
        }
    }
}
