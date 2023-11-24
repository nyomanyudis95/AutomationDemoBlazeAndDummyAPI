package com.automation.demoblaze.componentObject;

import com.automation.demoblaze.utils.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginModalComponent extends BasePage {
    By modalLogin = By.id("logInModal");
    By btnClose = By.className("btn-secondary");
    By btnSignUp = By.className("btn-primary");
    By inputUserName = By.id("loginusername");
    By inputPassword = By.id("loginpassword");

    public LoginModalComponent(WebDriver driver){
        super(driver);
    }

    public WebElement getBtnClose(){
        return driver.findElement(modalLogin)
                .findElement(btnClose);
    }

    public WebElement getBtnLogin(){
        return driver.findElement(modalLogin)
                .findElement(btnSignUp);
    }

    public void clickBtnClose(){
        getBtnClose().click();
    }

    public void clickBtnLogin(){
        getBtnLogin().click();
    }

    public void typeInputUsername(String username){
        driver.findElement(inputUserName).sendKeys(username);
    }

    public void typeInputPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void assertModalLoginisHide(){
        WebElement modal = driver.findElement(modalLogin);
        wait.until(d -> !modal.isDisplayed());
        Assertions.assertEquals(false,modal.isDisplayed());
    }


}
