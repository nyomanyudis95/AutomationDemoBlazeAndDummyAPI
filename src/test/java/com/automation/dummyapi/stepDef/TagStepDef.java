package com.automation.dummyapi.stepDef;

import com.automation.dummyapi.utils.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;

public class TagStepDef extends BaseTest {
    public String tagName;
    @When("request to get list tag")
    public void requestToGetListTag() {
        response = request.get("tag");
    }

    @Given("get Tag from firstPostID")
    public void getTagFromFirstPostID() {
        List<List<String>> tags= request.get("post")
                .jsonPath()
                .getList("data.tags");

        tagName = tags.get(0).get(0);
    }

    @When("request to get post by tag")
    public void requestToGetPostByTag() {
        response = request.get("tag/"+tagName+"/post");
    }

    @When("request to get post by invalid tag")
    public void requestToGetPostByInvalidTag() {
        response = request.get("tag/!@$$$$/post");
    }
}
