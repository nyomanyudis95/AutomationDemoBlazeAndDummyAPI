package com.automation.demoblaze.stepDef;

import com.automation.demoblaze.utils.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactStepDef extends BaseTest {
    @When("user click button close in contact modal")
    public void userClickButtonCloseInContactModal() {
        contactModalComponent.clickBtnClose();
    }

    @Then("contact modal is hide")
    public void contactModalIsHide() {
        contactModalComponent.assertContactModalIsHide();
    }

    @When("user input email in Contact Modal with {string}")
    public void userInputEmailInContactModalWith(String email) {
        contactModalComponent.inputEmail(email);
    }

    @And("user input contact name in Contact Modal with {string}")
    public void userInputContactNameInContactModalWith(String contact) {
        contactModalComponent.inputContact(contact);
    }

    @And("user input message in Contact Modal with {string}")
    public void userInputMessageInContactModalWith(String message) {
        contactModalComponent.inputMessage(message);
    }

    @And("user click button Send in Contact Modal")
    public void userClickButtonSendInContactModal() {
        contactModalComponent.clickBtnSend();
    }
}
