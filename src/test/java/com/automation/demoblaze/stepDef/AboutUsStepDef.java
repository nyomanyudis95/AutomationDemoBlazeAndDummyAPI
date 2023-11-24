package com.automation.demoblaze.stepDef;

import com.automation.demoblaze.utils.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AboutUsStepDef extends BaseTest {
    @When("user click button close in About Us Modal")
    public void userClickButtonCloseInAboutUsModal() {
        aboutUsModalPage.clickBtnClose();
    }

    @Then("About Us Modal will be hide")
    public void aboutUsModalWillBeHide() {
        aboutUsModalPage.assertModalAboutUsisHide();
    }


}
