package com.spbstu.selenium;

import com.spbstu.utils.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;

/**
 * Created by dmitry on 07.03.2018.
 */
public class BaseSeleniumTest {
    TestConfig config;

    @BeforeSuite
    public void beforeSuite() {
        config = ConfigFactory.create(TestConfig.class);
    }
}
