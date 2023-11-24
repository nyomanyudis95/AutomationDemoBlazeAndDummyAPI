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

import java.util.List;

public class CartPage extends BasePage {
    By listItemSelector = By.className("success");

    By btnOrderSelector = By.className("btn-success");





    public CartPage(WebDriver driver){
        super(driver);
    }

    public WebElement getFirstItem(){
        wait.until(ExpectedConditions.presenceOfElementLocated(listItemSelector));
        return driver.findElements(listItemSelector).get(0);
    }

    public void clickBtnDeleteFirstItem(){
        getFirstItem().findElement(By.tagName("a")).click();
    }

    public void clickBtnOrder(){
        wait.until(ExpectedConditions.presenceOfElementLocated(btnOrderSelector));
        driver.findElement(btnOrderSelector).click();
    }

    public void checkFirstItemInformation(ProductSchema selectedProduct){
        List<WebElement> listInformationProduct = getFirstItem().findElements(By.tagName("td"));
        String imageProduct = listInformationProduct.get(0)
                .findElement(By.tagName("img"))
                .getAttribute("src");
        String nameProduct = listInformationProduct.get(1)
                .getText();
        String priceProduct = listInformationProduct.get(2)
                .getText();

        Assertions.assertEquals(imageProduct,selectedProduct.getImage());
        Assertions.assertEquals(nameProduct,selectedProduct.getName());
        Assertions.assertEquals(priceProduct,selectedProduct.getPrice().replace("$",""));
    }

    public void checkListItemIsEmpty(){
        int totalItem = driver.findElements(listItemSelector).size();
        Assertions.assertEquals(0,totalItem);
    }

    public void waitReloadCartPage(){
        WebElement element = driver.findElement(btnOrderSelector);
        reloadWait.until(ExpectedConditions.stalenessOf(element));
    }

}
