package org.testing.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testing.swaglabs.base.DriverInitializer;
import org.junit.Assert;

import java.util.logging.Logger;

public class ShoppingCart {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final WebDriver driver = DriverInitializer.initializeDriver();
    private static final int WAIT_SHORT = 2;

    private static String selectedItem;
    private static final By cart = By.xpath("//button[@id='add-to-cart']");
    private static final By cartIcon = By.xpath("(//a[@class='shopping_cart_link'])[1]");
    private static final By cartItem = By.xpath("//div[@class='inventory_item_name']");
    private static final By removeItem = By.xpath("//button[contains(text(), 'Remove')]");

    public static void selectItem(final String item) {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            driver.findElement(By.xpath("//div[normalize-space()='" + item + "']")).click();
            selectedItem = item;
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to select an item: %s", e.getMessage()));
        }
    }

    public static void addToCart() {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            ActionsWebElements.click(cart);
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to click on add to cart: %s", e.getMessage()));
        }
    }

    public static void clickCartIcon() {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            ActionsWebElements.click(cartIcon);
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to click on cart icon: %s", e.getMessage()));
        }
    }

    public static void validateCart() {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            Assert.assertEquals(selectedItem, ActionsWebElements.getText(cartItem));
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to validate item on cart: %s", e.getMessage()));
        }
    }

    public static void removeItem() {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            ActionsWebElements.click(removeItem);
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to click remove: %s", e.getMessage()));
        }
    }

    public static void validateCartRemove() {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            final WebElement element = driver.findElement(cartItem);
            element.isDisplayed();
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to validate item removal: %s", e.getMessage()));
        }
    }
}