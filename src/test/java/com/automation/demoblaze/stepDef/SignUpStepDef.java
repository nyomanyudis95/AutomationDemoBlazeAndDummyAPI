package com.automation.demoblaze.stepDef;

import com.automation.demoblaze.utils.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpStepDef extends BaseTest {
    @When("user click button close in sign up modal")
    public void userClickButtonCloseInSignUpModal() {
        signUpModalComponent.clickBtnClose();
    }

    @Then("Sign Up Modal will be hide")
    public void signUpModalWillBeHide() {
        signUpModalComponent.assertModalSignUpisHide();
    }

    @When("user click button Sign Up")
    public void userClickButtonSignUp() {
        signUpModalComponent.clickBtnSignUp();
    }

    @Then("show alert {string}")
    public void showAlert(String message) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assertions.assertEquals(message,alertText);
        alert.accept();
    }

    @When("user filled username with {string}")
    public void userFilledUsernameWith(String username) {
        signUpModalComponent.typeInputUsername(username);
    }

    @When("user filled password with {string}")
    public void userFilledPasswordWith(String password) {
        signUpModalComponent.typeInputPassword(password);
    }
}
