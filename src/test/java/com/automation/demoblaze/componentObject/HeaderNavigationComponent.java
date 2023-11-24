package com.automation.demoblaze.componentObject;

import com.automation.demoblaze.utils.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderNavigationComponent extends BasePage {

    By btnMainIconDemoBlaze = By.id("nava");
    By btnSignUp = By.id("signin2");
    By btnSignIn = By.id("login2");
    By btnCart = By.linkText("Cart");
    By btnLogOut = By.id("logout2");
    By btnNameOfUser = By.id("nameofuser");

    By navBar = By.className("navbar-nav");
    By btnContact = By.cssSelector("[data-target='#exampleModal']");
    By btnAboutUs = By.cssSelector("[data-target='#videoModal']");
    By signUpModal = By.id("signInModal");
    By loginModal = By.id("logInModal");
    By aboutUsModal = By.id("videoModal");
    By contactModal = By.id("exampleModal");

    public HeaderNavigationComponent(WebDriver driver){
        super(driver);
    }

    public WebElement getBtnHome(){
        return driver.findElement(navBar)
                .findElements(By.tagName("li"))
                .get(0)
                .findElement(By.tagName("a"));
    }

    public void clickBtnSignUp(){
        driver.findElement(btnSignUp).click();
    }
    public void clickBtnSignIn(){
        driver.findElement(btnSignIn).click();
    }
    public void clickBtnCart(){
        driver.findElement(btnCart).click();
    }
    public void clickBtnContact(){
        driver.findElement(btnContact).click();
    }
    public void clickBtnAboutUs(){
        driver.findElement(btnAboutUs).click();
    }
    public void clickBtnHome(){
        getBtnHome().click();
    }
    public void clickBtnIconNav(){
        driver.findElement(btnMainIconDemoBlaze).click();
    }
    public void clickBtnLogOut(){
        driver.findElement(btnLogOut).click();
    }

    public void assertSignUpModalIsDisplayed(){
        WebElement modalSignUp = driver.findElement(signUpModal);
        wait.until(d -> modalSignUp.isDisplayed());
        Assertions.assertEquals(true,modalSignUp.isDisplayed());
    }

    public void assertSignInModalIsDisplayed(){
        WebElement modalSignIn = driver.findElement(loginModal);
        wait.until(d -> modalSignIn.isDisplayed());
        Assertions.assertEquals(true,modalSignIn.isDisplayed());
    }

    public void assertContactModalIsDisplayed(){
        WebElement modalContact = driver.findElement(contactModal);
        wait.until(d -> modalContact.isDisplayed());
        Assertions.assertEquals(true,modalContact.isDisplayed());
    }

    public void assertAboutUsModalIsDisplayed(){
        WebElement modalAboutUs = driver.findElement(aboutUsModal);
        wait.until(d -> modalAboutUs.isDisplayed());
        Assertions.assertEquals(true,modalAboutUs.isDisplayed());
    }

    public void assertUserAlreadyLogin( String username){
        WebElement btnNavLogOut = driver.findElement(btnLogOut);
        WebElement btnNavNameOfUser = driver.findElement(btnNameOfUser);

        wait.until(d -> btnNavLogOut.isDisplayed());
        Assertions.assertEquals(true,btnNavLogOut.isDisplayed());
        wait.until(d -> btnNavNameOfUser.isDisplayed());
        Assertions.assertEquals(true,btnNavNameOfUser.isDisplayed());

        String textNameOfUser = btnNavNameOfUser.getText();
        Assertions.assertEquals(textNameOfUser,"Welcome "+username);
    }

    public void assertUserAlreadyLogout(){
        WebElement btnNavLogOut = driver.findElement(btnLogOut);
        WebElement btnNavNameOfUser = driver.findElement(btnNameOfUser);

        wait.until(d -> !btnNavLogOut.isDisplayed());
        Assertions.assertEquals(false,btnNavLogOut.isDisplayed());
        wait.until(d -> !btnNavNameOfUser.isDisplayed());
        Assertions.assertEquals(false,btnNavNameOfUser.isDisplayed());
    }

}
