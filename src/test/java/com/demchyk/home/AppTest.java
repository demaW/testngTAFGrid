package com.demchyk.home;

import com.demchyk.home.buisnessobject.DemoQAMainBO;
import com.demchyk.home.core.DriverProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppTest extends BaseClass {
    private DemoQAMainBO demoQAMainBO;

    @BeforeClass
    public void setUp(){
        System.out.println("In regression");
    }

    @Test
    public void method1Test(){
        demoQAMainBO = new DemoQAMainBO();
        demoQAMainBO.open();
        Assert.assertTrue("Home".contentEquals(demoQAMainBO.getHeaderText()));
        System.out.println("Method 1");
    }

    @Test void method2Test(){
        System.out.println("Method 2");
    }

    @AfterMethod
    public void closeDriver(){
        if (DriverProvider.getDriver() != null){
            DriverProvider.closeDriver();
        }
    }
}
