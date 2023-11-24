package com.automation.demoblaze.pageObject;

import com.automation.demoblaze.dataSchema.OrderSchema;
import com.automation.demoblaze.utils.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;

public class OrderModalPage extends BasePage {
    By orderModalSelector = By.id("orderModal");
    By successPurchaseModalSelector = By.className("sweet-alert");

    By totalPriceSelector = By.id("totalm");

    By inputTextNameSelector = By.id("name");
    By inputTextCountrySelector = By.id("country");
    By inputTextCitySelector = By.id("city");
    By inputTextCardSelector = By.id("card");
    By inputTextMonthSelector = By.id("month");
    By inputTextYearSelector = By.id("year");

    By btnCloseSelector = By.className("btn-secondary");
    By btnPurchaseSelector = By.className("btn-primary");

    By pInformationSuccessModalSelector = By.className("text-muted");
    By btnOKSelector = By.className("confirm");

    public OrderModalPage(WebDriver driver){
        super(driver);
    }

    public void checkOrderModalIsDisplayed(){
        WebElement orderModal = driver.findElement(orderModalSelector);
        wait.until(d -> orderModal.isDisplayed());
        Assertions.assertEquals(true,orderModal.isDisplayed());
    }

    public void checkSuccessPurchaseModalIsDisplayed(){
//        WebElement successModal = driver.findElement(successPurchaseModalSelector);
//        wait.until(d -> successModal.isDisplayed());
        wait.until(ExpectedConditions.presenceOfElementLocated(successPurchaseModalSelector));
        WebElement successModal = driver.findElement(successPurchaseModalSelector);
        Assertions.assertEquals(true,successModal.isDisplayed());
    }

    public void checkInformationSuccessPurchaseModal(OrderSchema order){
        String info = driver.findElement(pInformationSuccessModalSelector).getText();
        String[] infoDetail = info.split("\n");

        String price = infoDetail[1].split(":")[1].replace(" ","").replace("USD","");
        String creditCard = infoDetail[2].split(":")[1];
        String name = infoDetail[3].split(":")[1];
        String[] orderDateArray = infoDetail[4].split(":")[1].replace(" ","").split("/");

        int orderYear = Integer.parseInt(orderDateArray[2]);
        int orderMonth = Integer.parseInt(orderDateArray[1]) + 1;
        int orderDate = Integer.parseInt(orderDateArray[0]);

        LocalDate dateOrder = LocalDate.of(orderYear,orderMonth,orderDate);
        LocalDate dateNow = LocalDate.now();

        Assertions.assertEquals(true,dateNow.equals(dateOrder));
        Assertions.assertEquals(" "+order.getName(),name);
        Assertions.assertEquals(" "+order.getCreditCard(),creditCard);
    }



    public void checkOrderModalIsHide(){
        WebElement orderModal = driver.findElement(orderModalSelector);
        wait.until(d -> !orderModal.isDisplayed());
        Assertions.assertEquals(false,orderModal.isDisplayed());
    }

    public void setInputName(String name){
        driver.findElement(orderModalSelector).findElement(inputTextNameSelector).sendKeys(name);
    }

    public void setInputCountry(String country){
        driver.findElement(orderModalSelector).findElement(inputTextCountrySelector).sendKeys(country);
    }

    public void setInputCity(String city){
        driver.findElement(orderModalSelector).findElement(inputTextCitySelector).sendKeys(city);
    }

    public void setInputCard(String card){
        driver.findElement(orderModalSelector).findElement(inputTextCardSelector).sendKeys(card);
    }

    public void setInputMonth(String month){
        driver.findElement(orderModalSelector).findElement(inputTextMonthSelector).sendKeys(month);
    }

    public void setInputYear(String year){
        driver.findElement(orderModalSelector).findElement(inputTextYearSelector).sendKeys(year);
    }

    public void clickBtnClose(){
        driver.findElement(orderModalSelector).findElement(btnCloseSelector).click();
    }

    public void clickBtnOK(){
//        wait.until(d -> driver.findElement(successPurchaseModalSelector).findElement(btnOKSelector).isDisplayed());
        driver.findElement(successPurchaseModalSelector).findElement(btnOKSelector).click();
    }
    public void clickBtnPurchase(){
        driver.findElement(orderModalSelector).findElement(btnPurchaseSelector).click();
    }



}
