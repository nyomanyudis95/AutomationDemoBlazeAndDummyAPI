package com.automation.demoblaze.pageObject;

import com.automation.demoblaze.dataSchema.ProductSchema;
import com.automation.demoblaze.utils.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    By iconLinkSelector = By.id("nava");

    // ==== product information selector
    By productDescriptionSelector = By.id("more-information");
    By productPriceSelector = By.className("price-container");
    By productNameSelector = By.cssSelector("h2.name");
    By containerImageSelector = By.id("imgp");
    // ==== product information selector

    By btnNavCartSelector = By.id("cartur");
    By btnAddCartSelector = By.linkText("Add to cart");

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void waitReloadProductPage(WebDriverWait reloadWait){
        WebElement element = driver.findElement(productDescriptionSelector);
        reloadWait.until(ExpectedConditions.stalenessOf(element));
    }

    public void clickBtnAddCart(){
        wait.until(ExpectedConditions.presenceOfElementLocated(btnAddCartSelector));
        driver.findElement(btnAddCartSelector).click();
    }
    public void clickBtnNavCart() { driver.findElement(btnNavCartSelector).click();}

    public void checkSelectedProductInformation(ProductSchema product){
        wait.until(ExpectedConditions.presenceOfElementLocated(productNameSelector));
        String textProductName = driver.findElement(productNameSelector).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(productPriceSelector));
        String textProductPrice = driver.findElement(productPriceSelector).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(productDescriptionSelector));
        String textProductDescription = driver.findElement(productDescriptionSelector)
                .findElement(By.tagName("p"))
                .getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(containerImageSelector));
        String urlImage = driver.findElement(containerImageSelector)
                .findElement(By.tagName("img"))
                .getAttribute("src");

        Assertions.assertEquals(textProductDescription,product.getDescription());
        Assertions.assertEquals(textProductPrice.split(" ")[0],product.getPrice());
        Assertions.assertEquals(textProductName,product.getName());
        Assertions.assertEquals(urlImage,product.getImage());
    }


}
