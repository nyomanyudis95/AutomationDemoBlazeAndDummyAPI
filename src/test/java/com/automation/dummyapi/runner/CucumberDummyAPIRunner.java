package com.automation.dummyapi.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = {"com.automation.dummyapi"}
//        tags = "@currentTest"
)
public class CucumberDummyAPIRunner {
}

