package com.automation.dummyapi.utils;

import com.automation.dummyapi.model.UserModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class BaseTest {
    protected static UserModel userModel;
    protected static RequestSpecification request;
    protected static Response response;
    protected static JSONObject bodyObject;

    public void init(){
        RestAssured.baseURI = Configuration.baseURL;
        bodyObject = new JSONObject();
    }
}
