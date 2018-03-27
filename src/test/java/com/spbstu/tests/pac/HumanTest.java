package com.spbstu.tests.pac;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by dmitry on 28.02.2018.
 */
public class HumanTest extends BaseTest {
    @BeforeClass
    public void beforeHumanClass() {
        System.out.println("beforeHumanClass");
    }

    @Test
    public void eatTest() {
        System.out.println("eatTest");
    }

    @AfterClass
    public void afterHumanClass() {
        System.out.println("afterHumanClass");
    }
}
