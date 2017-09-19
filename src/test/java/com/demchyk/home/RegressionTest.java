package com.demchyk.home;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegressionTest extends BaseClass{

    @BeforeClass
    public void setUp(){
        System.out.println("In regression");
    }

    @Test
    public void methodReg1Test(){
        System.out.println("Method 1");
    }

    @Test void methodReg2Test(){
        System.out.println("Method 2");
        Assert.assertTrue(false, "failed");
    }
}
