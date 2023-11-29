package com.automation.dummyapi.stepDef;

import com.automation.dummyapi.responseDataSchema.ListUserSchema;
import com.automation.dummyapi.responseDataSchema.UserDetailSchema;
import com.automation.dummyapi.utils.BaseTest;
import com.automation.dummyapi.utils.StringUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class UserStepDef extends BaseTest {
    public String userID;

    @When("request to get list user")
    public void requestToGetListUser() {
        response = request.get("user");
    }

    @When("request to get user by userID")
    public void requestToGetUserByUserID() {
        response = request.get("user/"+userID);
    }

    @Given("get first userID")
    public void getFirstUserID() {
        List<String> listUser = request.get("user")
                .jsonPath()
                .getList("data.id");
        userID = listUser.get(0);
    }

    @When("request to get user by invalid userID")
    public void requestToGetUserByInvalidUserID() {
        response = request.get("user/%@%@$%%");
    }

    @When("request create user")
    public void requestCreateUser() {
        if(bodyObject.length() == 0) response = request.post("user/create");
        else {
            response = request.body(bodyObject.toString()).post("user/create");
            userID = response.getBody().jsonPath().getString("id");
        }
    }

    @When("request to get post by userID")
    public void requestToGetPostByUserID() {
        response = request.get("user/"+userID+"/post");
    }

    @Given("set body create user with generated user")
    public void setBodyGeneratedUser() {
        bodyObject = new JSONObject();
        bodyObject.put("firstName",StringUtility.getSaltString());
        bodyObject.put("lastName",StringUtility.getSaltString());
        bodyObject.put("email",StringUtility.getSaltString()+"@gmail.com");
    }

    @When("request to get comment by userID")
    public void requestToGetCommentByUserID() {
        response = request.get("user/"+userID+"/comment");
    }

    @When("request to get comment by invalid userID")
    public void requestToGetCommentByInvalidUserID() {
        response = request.get("user/!@#!!#/comment");
    }

    @When("request to get post by invalid userID")
    public void requestToGetPostByInvalidUserID() {
        response = request.get("user/!@#!!#/post");
    }

    @And("check respond data create user same with body")
    public void checkRespondDataCreateUserSameWithBody() {
//        response.getBody().jsonPath()
        String firstName = response.getBody().jsonPath().getString("firstName");
        String lastName = response.getBody().jsonPath().getString("lastName");
        String email = response.getBody().jsonPath().getString("email");
        String registerDateTime = response.getBody().jsonPath().getString("registerDate");
        String[] registerDateArray = registerDateTime.substring(0,10).split("-");
        String updatedDateTime = response.getBody().jsonPath().getString("updatedDate");
        String[] updatedDateArray = updatedDateTime.substring(0,10).split("-");



//        LocalDate dateNow = LocalDate.now();
//        LocalDate dateUpdate = LocalDate.of(Integer.parseInt(updatedDateArray[0]),Integer.parseInt(updatedDateArray[1]),Integer.parseInt(updatedDateArray[2]));
//        LocalDate dateRegister = LocalDate.of(Integer.parseInt(registerDateArray[0]),Integer.parseInt(registerDateArray[1]),Integer.parseInt(registerDateArray[2]));
        Assertions.assertEquals(bodyObject.get("firstName"),firstName);
        Assertions.assertEquals(bodyObject.get("lastName"),lastName);
        Assertions.assertEquals( bodyObject.get("email").toString().toLowerCase(),email.toLowerCase());
//        Assertions.assertEquals(0,dateNow.compareTo(dateRegister));
//        Assertions.assertEquals(0,dateNow.compareTo(dateUpdate));
    }

    @And("check respond data create user by error message must be filled")
    public void checkRespondDataCreateUserByErrorMessageMustBeFilled() {
        String errorEmail = response.getBody().jsonPath().getString("data.email");
        String errorFirstName = response.getBody().jsonPath().getString("data.firstName");
        String errorLastName = response.getBody().jsonPath().getString("data.lastName");

        Assertions.assertEquals("Path `email` is required.",errorEmail);
        Assertions.assertEquals("Path `firstName` is required.",errorFirstName);
        Assertions.assertEquals("Path `lastName` is required.",errorLastName);
    }

    @Given("set body create user with empty string")
    public void setBodyCreateUserWithEmptyString() {
        bodyObject = new JSONObject();
        bodyObject.put("firstName","");
        bodyObject.put("lastName","");
        bodyObject.put("email","");
    }

    @Given("set body create user with invalid format email")
    public void setBodyCreateUserWithInvalidFormatEmail() {
        bodyObject = new JSONObject();
        bodyObject.put("firstName",StringUtility.getSaltString());
        bodyObject.put("lastName",StringUtility.getSaltString());
        bodyObject.put("email","!@415%%");
    }

    @And("check respond data create user by error message invalid format email")
    public void checkRespondDataCreateUserByErrorMessageInvalidFormatEmail() {
        String errorEmail = response.getBody().jsonPath().getString("data.email");

        Assertions.assertEquals("Path `email` is invalid ("+bodyObject.get("email")+").",errorEmail);
    }

    @Given("set body create user with existing email")
    public void setBodyCreateUserWithExistingEmail() {
        List<String> listUser = request.get("user")
                .jsonPath()
                .getList("data.id");
        userID = listUser.get(0);
        String email = request.get("user/"+userID)
                .jsonPath()
                .getString("email");

        bodyObject = new JSONObject();
        bodyObject.put("firstName",StringUtility.getSaltString());
        bodyObject.put("lastName",StringUtility.getSaltString());
        bodyObject.put("email",email);

    }

    @And("check respond data create user by error message existing email")
    public void checkRespondDataCreateUserByErrorMessageExistingEmail() {
        String errorEmail = response.getBody().jsonPath().getString("data.email");

        Assertions.assertEquals("Email already used",errorEmail);
    }

    @When("request delete user with invalid userID")
    public void requestDeleteUserWithInvalidUserID() {
        response = request.delete("user/!@$!%@515");
    }

    @And("check respond data delete user with same userID")
    public void checkRespondDataDeleteUserWithSameUserID() {
        String resUserID = response.getBody().jsonPath().getString("id");
        Assertions.assertEquals(resUserID,userID);
    }

    @When("request delete user")
    public void requestDeleteUser() {
        response = request.delete("user/"+userID);
    }
}
