package com.demchyk.home.buisnessobject;

import com.demchyk.home.pageobject.DemoQaMain;

public class DemoQAMainBO {
    private DemoQaMain demoQaMain;

    public DemoQAMainBO(){
        demoQaMain = new DemoQaMain();
    }

    public String getHeaderText(){
        return demoQaMain.getHeaderText();
    }

    public void open() {
        demoQaMain.openPage();
    }
}
