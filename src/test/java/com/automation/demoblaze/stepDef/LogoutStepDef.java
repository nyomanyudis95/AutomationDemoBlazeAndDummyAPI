package com.automation.demoblaze.stepDef;

import com.automation.demoblaze.utils.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Cookie;

public class LogoutStepDef extends BaseTest {
    @And("user click button logout in header navigation")
    public void userClickButtonLogoutInHeaderNavigation() {
        headerNavigationComponent.clickBtnLogOut();
    }

    @Then("Assert user already logout")
    public void assertUserAlreadyLogout() {
        headerNavigationComponent.assertUserAlreadyLogout();
    }

    @And("Assert user dont have cookies token")
    public void assertUserDontHaveCookiesToken() {
        Cookie cookie = driver.manage().getCookieNamed("tokenp_");
        Assertions.assertNull(cookie);
    }
}
