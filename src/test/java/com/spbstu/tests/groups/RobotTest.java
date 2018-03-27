package com.spbstu.tests.groups;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by dmitry on 28.02.2018.
 */

public class RobotTest extends BaseTest {
    @BeforeClass(groups = "robot")
    public void beforeRobotClass() {
        System.out.println("beforeRobotClass");
    }

    @Test(groups = "robot")
    public void reset2Default() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("reset2Default");
    }

    @Test(groups = "robot")
    public void selfDestruction() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("selfDestruction");
    }

    @AfterClass(groups = "robot")
    public void afterRobotClass() {
        System.out.println("afterRobotClass");
    }
}
