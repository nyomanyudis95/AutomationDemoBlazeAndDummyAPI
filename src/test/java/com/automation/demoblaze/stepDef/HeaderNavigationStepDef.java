package com.automation.demoblaze.stepDef;

import com.automation.demoblaze.dataSchema.ProductSchema;
import com.automation.demoblaze.utils.BaseTest;
import com.automation.demoblaze.utils.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Cookie;

public class HeaderNavigationStepDef extends BaseTest {
    ProductSchema selectedProduct;
    @Given("user already in HomScreen")
    public void userAlreadyInHomScreen() {
        driver.get(Configuration.urlBase);
    }

    @When("user click button navigation Sign Up")
    public void userClickButtonNavigationSignUp() {
        headerNavigationComponent.clickBtnSignUp();
    }

    @Then("Sign Up Modal will be show")
    public void signUpModalWillBeShow() {
       headerNavigationComponent.assertSignUpModalIsDisplayed();
    }

    @When("user click button navigation Sign In")
    public void userClickButtonNavigationSignIn() {
        headerNavigationComponent.clickBtnSignIn();
    }

    @Then("Sign In Modal will be show")
    public void signInModalWillBeShow() {
        headerNavigationComponent.assertSignInModalIsDisplayed();
    }

    @When("user click button navigation Cart")
    public void userClickButtonNavigationCart() {
        headerNavigationComponent.clickBtnCart();
    }

    @Then("move to Cart Page")
    public void moveToCartPage() {
        String url = driver.getCurrentUrl();
        Assertions.assertEquals(Configuration.urlBase+Configuration.cartPage,url);
    }

    @When("user click button navigation Contact")
    public void userClickButtonNavigationContact() {
        headerNavigationComponent.clickBtnContact();
    }

    @Then("Contact Modal will be show")
    public void contactModalWillBeShow() {
        headerNavigationComponent.assertContactModalIsDisplayed();
    }

    @When("user click button navigation Home")
    public void userClickButtonNavigationHome() {
        headerNavigationComponent.clickBtnHome();
    }


    @When("user click button icon demoblaze")
    public void userClickButtonIconDemoblaze() {
        headerNavigationComponent.clickBtnIconNav();
    }

    @When("user click button navigation About Us")
    public void userClickButtonNavigationAboutUsInHomeScreen() {
        headerNavigationComponent.clickBtnAboutUs();
    }

    @Then("About Us Modal will be show")
    public void aboutUsModalWillBeShow() {
        headerNavigationComponent.assertAboutUsModalIsDisplayed();
    }

    @Then("wait reload HomePage")
    public void waitReloadHomePage() {
        homePage.waitReloadHomePage();
    }

    @And("check user is in Home Screen")
    public void checkUserIsInHomeScreen() {
//        wait.until(ExpectedConditions.urlToBe(Configuration.urlBase+Configuration.homePage));
        String url = driver.getCurrentUrl();
        Assertions.assertEquals(Configuration.urlBase+Configuration.homePage,url);
    }

    @Given("user already in {string}")
    public void userAlreadyIn(String page) {
        switch (page){
            case "HomePage":
                driver.get(Configuration.urlBase);
                break;
            case "CartPage":
                driver.get(Configuration.urlBase+Configuration.cartPage);
                break;
            case "ProductPage":{
                driver.get(Configuration.urlBase);
                this.selectedProduct = homePage.getFirstItemInformation();
                homePage.clickFirstItemImage();
                break;
            }
            default:
                break;
        }
    }
}
