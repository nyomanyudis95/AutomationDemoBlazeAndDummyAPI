package com.automation.demoblaze.stepDef;

import com.automation.demoblaze.utils.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginStepDef extends BaseTest {
    @When("user click button close in sign in modal")
    public void userClickButtonCloseInSignInModal() {
        loginModalComponent.clickBtnClose();
    }

    @Then("Sign In Modal will be hide")
    public void signInModalWillBeHide() {
        loginModalComponent.assertModalLoginisHide();
    }

    @When("user click button Login")
    public void userClickButtonLogin() {
        loginModalComponent.clickBtnLogin();
    }

    @When("user filled username in Login Modal with {string}")
    public void userFilledUsernameInLoginModalWith(String username) {
        loginModalComponent.typeInputUsername(username);
    }

    @When("user filled password in Login Modal with {string}")
    public void userFilledPasswordInLoginModalWith(String password) {
        loginModalComponent.typeInputPassword(password);
    }


    @And("Assert you are already login with username {string}")
    public void assertYouAreAlreadyLoginWithUsername(String username) {
        headerNavigationComponent.assertUserAlreadyLogin(username);
    }

    @Then("show alert change your password")
    public void showAlertChangeYourPassword() {
//        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        alert.accept();
    }

    @And("Assert user has cookies token")
    public void assertUserHasCookiesToken() {
        Cookie cookie1 = driver.manage().getCookieNamed("tokenp_");
        Assertions.assertNotNull(cookie1);
    }
}
