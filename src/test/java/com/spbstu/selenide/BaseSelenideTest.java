package com.spbstu.selenide;

import com.codeborne.selenide.Configuration;
import com.spbstu.selenium.BaseSeleniumTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseSelenideTest extends BaseSeleniumTest {
    @BeforeSuite
    public void beforeSuiteSelenide() {
        Configuration.browser = "CHROME";
        Configuration.timeout = 4000;
    }

}
