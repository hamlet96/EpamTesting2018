package com.spbstu.tests.groups;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by dmitry on 28.02.2018.
 */
public class BaseTest {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("afterSuite");
    }
}
