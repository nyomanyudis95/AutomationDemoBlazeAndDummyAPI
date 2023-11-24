package com.automation.demoblaze.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public Wait<WebDriver> wait;
    public WebDriverWait reloadWait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.reloadWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

}
