package com.automation.demoblaze.utils;

import com.automation.demoblaze.componentObject.ContactModalComponent;
import com.automation.demoblaze.componentObject.HeaderNavigationComponent;
import com.automation.demoblaze.componentObject.LoginModalComponent;
import com.automation.demoblaze.componentObject.SignUpModalComponent;
import com.automation.demoblaze.pageObject.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static SignUpModalComponent signUpModalComponent;
    protected static LoginModalComponent loginModalComponent;
    protected static HeaderNavigationComponent headerNavigationComponent;
    protected static AboutUsModalPage aboutUsModalPage;
    protected static ContactModalComponent contactModalComponent;
    protected static OrderModalPage orderModalPage;
    protected static ProductPage productPage;
    protected static CartPage cartPage;
    protected static Wait<WebDriver> wait;
    protected static WebDriverWait reloadWait;


    public void initDriverAndPage(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver(options);
        this.homePage = new HomePage(driver);
        this.productPage = new ProductPage(driver);
        this.cartPage = new CartPage(driver);
        this.headerNavigationComponent = new HeaderNavigationComponent(driver);
        this.reloadWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.signUpModalComponent = new SignUpModalComponent(driver);
        this.loginModalComponent = new LoginModalComponent(driver);
        this.aboutUsModalPage = new AboutUsModalPage(driver);
        this.contactModalComponent = new ContactModalComponent(driver);
        this.orderModalPage = new OrderModalPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
}
