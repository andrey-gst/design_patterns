package com.cucumber.testng;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "@smoke",
        glue = "com.cucumber.testng",
        features = "classpath:com/cucumber/testng/features")

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
