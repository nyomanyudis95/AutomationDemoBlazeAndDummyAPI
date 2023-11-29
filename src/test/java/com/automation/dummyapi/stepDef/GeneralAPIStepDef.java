package com.automation.dummyapi.stepDef;

import com.automation.dummyapi.utils.BaseTest;
import com.automation.dummyapi.utils.Configuration;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.Map;

public class GeneralAPIStepDef extends BaseTest {

    @Given("set header with valid api key")
    public void setHeaderWithValidApiKey() {
        request =  RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id",Configuration.appID);
    }

    @And("check data schema with file {string}")
    public void checkDataSchemaWithFile(String fileDataSchema) {
        File file = new File(Configuration.pathFolderDataSchema+fileDataSchema);
        response.then()
                .log().all()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(file));
    }


    @And("check status response by {string}")
    public void checkStatusResponseBy(String status) {
       int statusCode =  response.getStatusCode();
        Assertions.assertEquals(statusCode,Integer.parseInt(status));
    }

    @And("check error message by {string}")
    public void checkErrorMessageBy(String message) {
        response.then()
                .assertThat()
                .body("error", Matchers.equalTo(message));
    }

    @Given("set body with key {string} and {string}")
    public void setBodyWithKeyAnd(String key, String value) {
        bodyObject.put(key,value);
    }

    @Given("set body with:")
    public void setBodyWith( Map<String, String> body) {
        String[] listKey = body.get("key").split(";");
        String[] listValue = body.get("value").split(";");
        for(int i = 0; i < listKey.length ; i ++){
            bodyObject.put(listKey[i],listValue[i]);
        }
    }
}
