package com.automation.dummyapi.stepDef;

import com.automation.dummyapi.utils.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;

public class PostStepDef extends BaseTest {
    public String postID;
    @When("request to get list post")
    public void requestToGetListPost() {
        response = request.get("post");
    }

    @Given("get first postID")
    public void getFirstPostID() {
        List<String> listUser = request.get("post")
                .jsonPath()
                .getList("data.id");
        postID = listUser.get(0);
    }

    @When("request to get post by postID")
    public void requestToGetPostByPostID() {
        response = request.get("post/"+postID);
    }

    @When("request to get comment by postID")
    public void requestToGetCommentByPostID() {
        response = request.get("post/"+postID+"/comment");
    }

    @When("request to get comment by invalid postID")
    public void requestToGetCommentByInvalidPostID() {
        response = request.get("post/!@!@$!/comment");
    }

    @When("request to get post by invalid postID")
    public void requestToGetPostByInvalidPostID() {
        response = request.get("post/!@!@$!");
    }
}
