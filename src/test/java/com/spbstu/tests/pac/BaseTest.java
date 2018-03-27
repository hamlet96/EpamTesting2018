package com.spbstu.tests.pac;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by dmitry on 28.02.2018.
 */
public class BaseTest {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite");
    }
}
