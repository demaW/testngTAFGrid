package com.demchyk.home.pageobject;

import com.demchyk.home.core.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQaMain extends AbstractPage{
    private static final String SITE_URL = "http://demoqa.com/";
    private static final String HEADER_XP = "//h1[@class='entry-titlesd']";

    private WebDriver driver;

    @FindBy(xpath = HEADER_XP)
    private WebElement header;

    public DemoQaMain(){
        this.driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage(){
        driver.get(SITE_URL);
    }

    public String getHeaderText() {
        return header.getText();
    }
}
