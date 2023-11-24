package com.automation.demoblaze.stepDef;

import com.automation.demoblaze.dataSchema.OrderSchema;
import com.automation.demoblaze.utils.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderProductStepDef extends BaseTest {
    OrderSchema order = new OrderSchema();
    @When("user click button purchase in Order Modal")
    public void userClickButtonPurchaseInOrderModal() {
        orderModalPage.clickBtnPurchase();
    }

    @When("user input name with {string}")
    public void userInputNameWith(String name) {
        orderModalPage.setInputName(name);
        order.setName(name);
    }

    @And("user input country with {string}")
    public void userInputCountryWith(String country) {
        orderModalPage.setInputCountry(country);
        order.setCountry(country);
    }

    @And("user input city with {string}")
    public void userInputCityWith(String city) {
        orderModalPage.setInputCity(city);
        order.setCity(city);
    }

    @And("user input credit card with {string}")
    public void userInputCreditCardWith(String card) {
        orderModalPage.setInputCard(card);
        order.setCreditCard(card);
    }

    @And("user input month with {string}")
    public void userInputMonthWith(String month) {
        orderModalPage.setInputMonth(month);
        order.setMonth(month);
    }

    @And("user input year with {string}")
    public void userInputYearWith(String year) {
        orderModalPage.setInputYear(year);
        order.setYear(year);
    }

    @Then("check success purchase modal is show")
    public void checkSuccessPurchaseModalIsShow() {
        orderModalPage.checkSuccessPurchaseModalIsDisplayed();
    }

    @And("check information in success purchase modal")
    public void checkInformationInSuccessPurchaseModal() {
        orderModalPage.checkInformationSuccessPurchaseModal(order);
    }

    @And("click button OK in success purchase modal")
    public void clickButtonOKInSuccessPurchaseModal() throws InterruptedException {
        Thread.sleep(1000);
        orderModalPage.clickBtnOK();
//        Thread.sleep(1000);
    }
}
