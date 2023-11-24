package com.automation.demoblaze.componentObject;

import com.automation.demoblaze.utils.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class ContactModalComponent extends BasePage {
    By modalContactSelector = By.id("exampleModal");

    By inputEmailSelector = By.id("recipient-email");
    By inputContactNameSelector = By.id("recipient-name");
    By inputMessageSelector = By.id("message-text");

    By btnCloseSelector = By.className("btn-secondary");
    By btnSendSelector = By.className("btn-primary");

    public ContactModalComponent(WebDriver driver){
        super(driver);
    }

    public WebElement getBtnCloseWebElement(){
        return driver.findElement(modalContactSelector).findElement(btnCloseSelector);
    }
    public WebElement getBtnSendWebElement(){
        return driver.findElement(modalContactSelector).findElement(btnSendSelector);
    }
    public void inputEmail(String email){
        driver.findElement(inputEmailSelector).sendKeys(email);
    }
    public void inputContact(String contact){
        driver.findElement(inputContactNameSelector).sendKeys(contact);
    }
    public void inputMessage(String message){
        driver.findElement(inputMessageSelector).sendKeys(message);
    }
    public void clickBtnSend(){
        getBtnSendWebElement().click();
    }
    public void clickBtnClose(){
        getBtnCloseWebElement().click();
    }

    public void assertContactModalIsHide(){
        WebElement modal = driver.findElement(modalContactSelector);
        wait.until(d -> !modal.isDisplayed());
        Assertions.assertEquals(false,modal.isDisplayed());
    }

}
