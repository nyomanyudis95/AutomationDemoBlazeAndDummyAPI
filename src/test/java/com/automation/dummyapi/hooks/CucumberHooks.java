package com.automation.dummyapi.hooks;

import com.automation.dummyapi.utils.BaseTest;
import com.automation.dummyapi.utils.Configuration;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class CucumberHooks extends BaseTest {
    @Before
    public void beforeTest(){
        init();
    }
}
