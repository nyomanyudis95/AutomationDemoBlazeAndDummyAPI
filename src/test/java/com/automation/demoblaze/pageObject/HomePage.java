package com.automation.demoblaze.pageObject;

import com.automation.demoblaze.dataSchema.ProductSchema;
import com.automation.demoblaze.utils.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    // ========= Selector for navigation
    By btnMainIconDemoBlaze = By.id("nava");
    By btnSignUp = By.id("signin2");
    By btnSignIn = By.id("login2");
    By btnCart = By.id("cartur");
    By btnLogOut = By.id("logout2");
    By btnNameOfUser = By.id("nameofuser");

    By navBar = By.className("navbar-nav");
    By btnContact = By.cssSelector("[data-target='#exampleModal']");
    By btnAboutUs = By.cssSelector("[data-target='#videoModal']");
    By signUpModal = By.id("signInModal");
    By loginModal = By.id("logInModal");
    By aboutUsModal = By.id("videoModal");
    By contactModal = By.id("exampleModal");
    // ========== Selector for navigation

    // === selector for item list
    By containerListItemSelector = By.id("tbodyid");
    By containerItemSelector = By.className("col-lg-4");
    By linkItemNameSelector = By.className("hrefch");
    By itemDescriptionSelector = By.id("article");
    By itemImageSelector = By.className("card-img-top");
    // === selector for item list


    public HomePage(WebDriver driver){
        super(driver);
    }

    public WebElement getFirstItemContainer(){
        return driver.findElement(containerListItemSelector).findElements(containerItemSelector).get(0);
    }

    public ProductSchema getFirstItemInformation(){
        wait.until(d -> driver.findElement(containerListItemSelector).findElements(containerItemSelector).size() > 0);
        WebElement linkName = getFirstItemContainer().findElement(linkItemNameSelector);
        String itemName = linkName.getText();
        String itemLinkID = linkName.getAttribute("href");
        String itemPrice = getFirstItemContainer().findElement(By.tagName("h5")).getText();
        String itemDescription = getFirstItemContainer().findElement(itemDescriptionSelector).getText();
        String itemImage = getFirstItemContainer().findElement(itemImageSelector).getAttribute("src");

        ProductSchema product = new ProductSchema(itemName,itemPrice,itemDescription,itemLinkID,itemImage);
        return product;
    }

    public void clickFirstItemName(){
        getFirstItemContainer().findElement(linkItemNameSelector).click();
    }
    public void clickFirstItemImage(){
        getFirstItemContainer().findElement(By.tagName("a")).click();
    }



    public void waitReloadHomePage(){
        WebElement element = driver.findElement(btnMainIconDemoBlaze);
        reloadWait.until(ExpectedConditions.stalenessOf(element));
    }

    public void waitHomePage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(btnMainIconDemoBlaze));
    }
}
