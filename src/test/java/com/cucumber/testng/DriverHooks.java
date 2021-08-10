package com.cucumber.testng;

import driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {

    @Before
    public void setupDriver() {
        DriverSingleton.getDriver();
    }

    @After
    public void quitDriver() {
        DriverSingleton.closeDriver();
    }
}
