package com.spbstu.tests.pac;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by dmitry on 28.02.2018.
 */
public class RobotTest extends BaseTest {

    @BeforeClass
    public void beforeRobotClass() {
        System.out.println("beforeRobotClass");
    }

    @Test
    public void reset2Default() {
        System.out.println("reset2Default");
    }

    @AfterClass
    public void afterRobotClass() {
        System.out.println("afterRobotClass");
    }
}
