package com.automation.dummyapi.model;

import com.automation.dummyapi.utils.Configuration;
import com.automation.dummyapi.utils.ListFileDataSchema;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;
import java.util.List;

public class UserModel {
    public String userPath = "users/";

    public UserModel(){

    }

    public void getListUser(){
        File file = new File(Configuration.pathFolderDataSchema+ ListFileDataSchema.getListUserSchema);
        RestAssured.given().when()
                .get(userPath)
                .then()
                .log().all();

//        System.out.println(result);

    }
}
