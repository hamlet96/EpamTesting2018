package com.spbstu.tests.groups;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by dmitry on 28.02.2018.
 */
public class HumanTest extends BaseTest {
    @BeforeClass(groups = "human")
    public void beforeHumanClass() {
        System.out.println("beforeHumanClass");
    }

    @Test(groups = "human")
    public void eatTest() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("eatTest");
    }

    @Test(groups = {"human"})
    public void bornTest() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("bornTest");
    }

    @AfterClass(groups = "human")
    public void afterHumanClass() {
        System.out.println("afterHumanClass");
    }
}
