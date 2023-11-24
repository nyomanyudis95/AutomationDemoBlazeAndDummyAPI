package com.automation.demoblaze.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/website",
        glue = {"com.automation.demoblaze"}
)
public class CucumberRunner {
}
