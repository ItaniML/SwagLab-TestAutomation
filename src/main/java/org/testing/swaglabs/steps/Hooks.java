package org.testing.swaglabs.steps;

import io.cucumber.java.After;
import org.testing.swaglabs.base.DriverInitializer;

public class Hooks {
    @After
    public void tearDown() {
        DriverInitializer.quitDriver();
    }
}