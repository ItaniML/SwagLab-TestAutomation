package org.testing.swaglabs.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testing.swaglabs.pages.ActionsWebElements;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DriverInitializer {
    private static WebDriver driver;

    public static WebDriver initializeDriver() {
        if (driver == null) {
            Path driverPath = Paths.get("src", "test", "resources", "drivers", "chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", driverPath.toAbsolutePath().toString());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.contains("linux")) {
                options.addArguments("--headless");
            }

            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitDriver() {
        ActionsWebElements.iWait(3);
        driver.quit();
    }
}