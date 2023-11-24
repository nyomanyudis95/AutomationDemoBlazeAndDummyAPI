package com.automation.demoblaze.componentObject;

import com.automation.demoblaze.utils.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class SignUpModalComponent extends BasePage {
    By modalSignUp = By.id("signInModal");
    By btnClose = By.className("btn-secondary");
    By btnSignUp = By.className("btn-primary");
    By inputUserName = By.id("sign-username");
    By inputPassword = By.id("sign-password");

    public SignUpModalComponent(WebDriver driver){
       super(driver);
    }

    public WebElement getBtnClose(){
        return driver.findElement(modalSignUp)
                .findElement(btnClose);
    }

    public WebElement getBtnSignUp(){
        return driver.findElement(modalSignUp)
                .findElement(btnSignUp);
    }

    public void clickBtnClose(){
        getBtnClose().click();
    }

    public void clickBtnSignUp(){
        getBtnSignUp().click();
    }

    public void typeInputUsername(String username){
        driver.findElement(inputUserName).sendKeys(username);
    }

    public void typeInputPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void assertModalSignUpisHide(){
        WebElement modal = driver.findElement(modalSignUp);
        wait.until((d) -> !modal.isDisplayed());
        Assertions.assertEquals(false,modal.isDisplayed());
    }


}
