package com.automation.demoblaze.pageObject;

import com.automation.demoblaze.utils.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class AboutUsModalPage extends BasePage {
    By modalAboutUs = By.id("videoModal");
    By btnClose = By.className("btn-secondary");
    By videoAboutUs = By.id("example-video_html5_api");

    public AboutUsModalPage(WebDriver driver){
        super(driver);
    }

    public WebElement getBtnClose(){
        return driver.findElement(modalAboutUs)
                .findElement(btnClose);
    }
    public void clickBtnClose(){
        getBtnClose().click();
    }
    public void assertModalAboutUsisHide(){
        WebElement modal = driver.findElement(modalAboutUs);
        wait.until(d -> !modal.isDisplayed());
        Assertions.assertEquals(false,modal.isDisplayed());
    }








}
