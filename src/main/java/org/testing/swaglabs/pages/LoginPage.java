package org.testing.swaglabs.pages;

import org.openqa.selenium.By;
import java.util.logging.Logger;

public class LoginPage {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final int WAIT_SHORT = 2;

    private static final By usernameField = By.xpath("//input[@id='user-name']");
    private static final By passwordField = By.xpath("//input[@id='password']");
    private static final By loginButton = By.xpath("//input[@id='login-button']");
    private static final By products = By.xpath("//span[@class='title']");
    private static final By loginError = By.xpath("//div[@class='error-message-container']");

    public static void login(final String username, final String password) {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            ActionsWebElements.sendKeys(usernameField, username);
            ActionsWebElements.sendKeys(passwordField, password);
            ActionsWebElements.iWait(WAIT_SHORT);
            ActionsWebElements.click(loginButton);
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to login: %s", e.getMessage()));
        }
    }

    public static void header() {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            ActionsWebElements.isDisplayed(products);
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to validate products: %s", e.getMessage()));
        }
    }

    public static void errorLogin() {
        try {
            ActionsWebElements.iWait(WAIT_SHORT);
            ActionsWebElements.isDisplayed(loginError);
        } catch (final Exception e) {
            LOGGER.info(String.format("Unable to generate error: %s", e.getMessage()));
        }
    }
}