package com.automation.dummyapi.stepDef;

import com.automation.dummyapi.utils.BaseTest;
import io.cucumber.java.en.When;

public class CommentStepDef extends BaseTest {
    @When("request to get list comment")
    public void requestToGetListComment() {
        response = request.get("comment");
    }


}
