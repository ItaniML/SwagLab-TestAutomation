package org.testing.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testing.swaglabs.base.DriverInitializer;

import java.util.concurrent.TimeUnit;

public class ActionsWebElements {
    private static final WebDriver driver = DriverInitializer.initializeDriver();

    public static void click(final By element) {
        driver.findElement(element).click();
    }

    public static void sendKeys(final By element, final String value) {
        driver.findElement(element).sendKeys(value);
    }

    public static Object getText(final By element) {
        return driver.findElement(element).getText().trim();
    }

    public static void isDisplayed(final By element) {
        driver.findElement(element).isDisplayed();
    }

    public static void iWait(final int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (final Exception e) {
            throw new RuntimeException();
        }
    }
}