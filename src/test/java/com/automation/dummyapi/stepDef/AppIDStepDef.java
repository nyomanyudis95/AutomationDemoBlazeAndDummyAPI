package com.automation.dummyapi.stepDef;

import com.automation.dummyapi.utils.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;

public class AppIDStepDef extends BaseTest {
    @Given("get List User")
    public void getListUser() {
        userModel.getListUser();
    }

    @When("request api with path {string} and method {string}")
    public void requestApiWithPathAndMethod(String path, String method) {
        switch (method){
            case "get":{
                response = request.get(path);
            }
        }
    }

    @Given("set header without api-key")
    public void setHeaderWithoutApiKey() {
        request =  RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");

    }

    @Then("check respond api_id_missing")
    public void checkRespondApi_id_missing() {
        response.then()
                .assertThat()
                .body("error", Matchers.equalTo("APP_ID_MISSING"));
    }




    @Given("set header with invalid api-key")
    public void setHeaderWithInvalidApiKey() {
        request =  RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("api-key","!@$(*$&*(!@&$");
    }
}
