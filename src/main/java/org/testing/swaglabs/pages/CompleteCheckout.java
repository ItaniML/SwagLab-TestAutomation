package org.testing.swaglabs.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.logging.Logger;

public class CompleteCheckout {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final int WAIT_SHORT = 2;

    private static final By checkoutButton = By.xpath("//button[@id='checkout']");
    private static final By shippingName = By.xpath("//input[@id='first-name']");
    private static final By shippingSurname = By.xpath("//input[@id='last-name']");
    private static final By shippingCode = By.xpath("//input[@id='postal-code']");
    private static final By continueButton = By.xpath("//input[@id='continue']");
    private static final By checkoutOverview = By.xpath("//span[@class='title']");
    private static final By paymentInformation = By.xpath("//div[normalize-space()='Payment Information:']");
    private static final By totalCost = By.xpath("//div[normalize-space()='Price Total']");
    private static final By finishButton = By.xpath("//button[@id='finish']");
    private static final By completeCheckout = By.xpath("//span[@class='title']");

    public static void checkout() {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            ActionsWebElements.click(checkoutButton);
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to click on checkout: %s", e.getMessage()));
        }
    }

    public static void shippingDetails(final String name, final String lstName, final String zipCode) {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            ActionsWebElements.sendKeys(shippingName, name);
            ActionsWebElements.sendKeys(shippingSurname, lstName);
            ActionsWebElements.sendKeys(shippingCode, zipCode);
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to enter shipping details: %s", e.getMessage()));
        }
    }

    public static void completeCheckout() {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            ActionsWebElements.click(continueButton);
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to click on continue: %s", e.getMessage()));
        }
    }

    public static void validateOverview(final String overView, final String payInfo, final String totCost) {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            Assert.assertEquals(overView, ActionsWebElements.getText(checkoutOverview));
            Assert.assertEquals(payInfo, ActionsWebElements.getText(paymentInformation));
            Assert.assertEquals(totCost, ActionsWebElements.getText(totalCost));
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to validate order confirmation: %s", e.getMessage()));
        }
    }

    public static void finishCheckout() {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            ActionsWebElements.click(finishButton);
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to click on finish button: %s", e.getMessage()));
        }
    }

    public static void validateCompleteCheck(final String checkout) {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            Assert.assertEquals(checkout, ActionsWebElements.getText(completeCheckout));
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to validate complete checkout page: %s", e.getMessage()));
        }
    }
}