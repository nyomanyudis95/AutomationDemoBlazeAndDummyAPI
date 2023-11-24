package com.automation.demoblaze.hooks;

import com.automation.demoblaze.utils.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks extends BaseTest {
    @Before
    public void beforeCucumber(){
        initDriverAndPage();
    }

    @After
    public void afterCucumber(){
        driver.close();
    }
}
