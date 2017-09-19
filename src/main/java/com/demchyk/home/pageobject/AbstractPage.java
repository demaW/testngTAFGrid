package com.demchyk.home.pageobject;

import com.demchyk.home.core.DriverProvider;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

abstract class AbstractPage {
    abstract void openPage();

    public void waitForElement(Function condition){
        WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), 15);
        wait.until(condition);
    }

}
