package org.testing.swaglabs.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testing.swaglabs.base.DriverInitializer;
import org.testing.swaglabs.base.config.Properties;
import org.testing.swaglabs.pages.CompleteCheckout;
import org.testing.swaglabs.pages.LoginPage;
import org.testing.swaglabs.pages.ShoppingCart;

public class SwagLabStepDef {
    private final WebDriver driver = DriverInitializer.initializeDriver();

    @Given("the user is on the login page")
    public void userOnLoginPage() {
        driver.get(Properties.SWAGLAB_URL);
    }

    @And("the user enters username {string} and password {string}")
    public void theUserEntersUsernameAndPassword(final String username, final String password) {
        LoginPage.login(username, password);
    }

    @Then("the user verify Products after logging in")
    public void theUserVerifyHeadingAfterLoggingIn() {
        LoginPage.header();
    }

    @Then("an error message container should be displayed")
    public void anErrorMessageContainerShouldBeDisplayed() {
        LoginPage.errorLogin();
    }

    @And("the user selects an {string}")
    public void theUserSelectsAn(final String item) {
        ShoppingCart.selectItem(item);
    }

    @And("the user adds an item to the cart")
    public void theUserAddsAnItemToTheCart() {
        ShoppingCart.addToCart();
    }

    @And("the user clicks on cart icon")
    public void theUserClicksOnCartIcon() {
        ShoppingCart.clickCartIcon();
    }

    @Then("the item should be visible in the cart")
    public void theItemShouldBeVisibleInTheCart() {
        ShoppingCart.validateCart();
    }

    @And("the removes an item from the")
    public void theRemovesAnItemFromThe() {
        ShoppingCart.removeItem();
    }

    @Then("user verify that the item is removed")
    public void userVerifyThatTheItemIsRemoved() {
        ShoppingCart.validateCartRemove();
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        CompleteCheckout.checkout();
    }

    @And("enters shipping information {string}, {string} and {string}")
    public void entersShippingInformationAnd(final String name, final String lstName, final String zipCode) {
        CompleteCheckout.shippingDetails(name, lstName, zipCode);
    }

    @And("completes the checkout process")
    public void completesTheCheckoutProcess() {
        CompleteCheckout.completeCheckout();
    }

    @Then("the order confirmation should be displayed {string}, {string} and {string}")
    public void theOrderConfirmationShouldBeDisplayedAnd(final String overView, final String payInfo, final String totCost) {
        CompleteCheckout.validateOverview(overView, payInfo, totCost);
    }

    @And("the user clicks on finish button")
    public void theUserClicksOnFinishButton() {
        CompleteCheckout.finishCheckout();
    }

    @Then("the user validate {string} page")
    public void theUserValidatePage(final String checkout) {
        CompleteCheckout.validateCompleteCheck(checkout);
    }
}