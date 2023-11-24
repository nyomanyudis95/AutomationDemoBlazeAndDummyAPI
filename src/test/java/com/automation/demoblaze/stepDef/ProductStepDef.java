package com.automation.demoblaze.stepDef;

import com.automation.demoblaze.dataSchema.ProductSchema;
import com.automation.demoblaze.utils.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ProductStepDef extends BaseTest {
    ProductSchema selectedProduct = new ProductSchema();
    @And("user click first item name")
    public void userClickFirstItemName() {
        this.selectedProduct = homePage.getFirstItemInformation();
        homePage.clickFirstItemName();
    }


    @And("check user is in Product Page")
    public void checkUserIsInProductPage() {
        String url = driver.getCurrentUrl();
        Assertions.assertEquals(url, selectedProduct.getLinkProductID());
    }

    @And("check product information must be same with previous selected item")
    public void productInformationMustBeSameWithPreviousSelectedItem() {
        productPage.checkSelectedProductInformation(selectedProduct);
    }

    @When("user click button add to cart")
    public void userClickButtonAddToCart() {
        productPage.clickBtnAddCart();
    }

    @And("wait reload ProductPage")
    public void waitReloadProductPage() {
        productPage.waitReloadProductPage(reloadWait);
    }

    @When("user click first item image")
    public void userClickFirstItemImage() {
        this.selectedProduct = homePage.getFirstItemInformation();
        homePage.clickFirstItemImage();
    }

    @When("user click button navigation Cart in Product Page")
    public void userClickButtonNavigationCartInCartPage() {
        productPage.clickBtnNavCart();
    }


    @Then("check item is in table products")
    public void checkItemIsInTableProducts() {
        cartPage.checkFirstItemInformation(selectedProduct);
    }

    @When("user click button delete in first item")
    public void userClickButtonDeleteInFirstItem() {
        cartPage.clickBtnDeleteFirstItem();
        cartPage.waitReloadCartPage();
    }

    @Then("check list item is empty")
    public void checkListItemIsEmpty() {
        cartPage.checkListItemIsEmpty();
    }

    @And("user click button place order in Cart Page")
    public void userClickButtonPlaceOrderInCartPage() {
        cartPage.clickBtnOrder();
    }

    @And("check order modal is show")
    public void checkOrderModalIsShow() {
        orderModalPage.checkOrderModalIsDisplayed();
    }

    @When("user click button close in Order Modal")
    public void userClickButtonCloseInOrderModal() {
        orderModalPage.clickBtnClose();
    }

    @Then("check order modal is hide")
    public void checkOrderModalIsHide() {
        orderModalPage.checkOrderModalIsHide();
    }
}
