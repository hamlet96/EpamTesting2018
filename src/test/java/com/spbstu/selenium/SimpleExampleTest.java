package com.spbstu.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by dmitry on 07.03.2018.
 */
public class SimpleExampleTest extends BaseSeleniumTest {

    public static final String GOOGLE = "Google";
    public static final String SPBSTU = "spbstu";
    private ChromeDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod
    public void beforeMethod() {
        softAssert = new SoftAssert();
        System.setProperty("webdriver.chrome.driver", config.pathToDriver());
    }

/*    @Test
    public void googleSearchSimpleTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", config.pathToDriver());
        driver = new ChromeDriver();
        driver.navigate().to("http://www.google.com");
        TimeUnit.SECONDS.sleep(1);

        driver.manage().window().maximize();

        Assert.assertEquals(driver.getTitle(), GOOGLE,
                String.format("Actual: %s but expected: %s", driver.getTitle(), GOOGLE));

        WebElement element = driver.findElement(By.cssSelector("[name='q']"));
        element.sendKeys(SPBSTU + Keys.ENTER);

//        boolean condition = driver.findElements(By.cssSelector("#ires .rc .s"))
//                .stream().map(WebElement::getText).allMatch(s -> s.contains(SPBSTU));
//        Assert.assertTrue(condition);

        List<String> results = driver.findElements(By.cssSelector("#ires .rc .s")).stream().map(e -> e.getText()).collect(Collectors.toList());
        Assert.assertTrue(results.size() > 0, "Has no results");
        results.forEach(r ->
                softAssert.assertTrue(r.contains(SPBSTU), String.format("%s %s", r, SPBSTU))
        );

    }
*/
    @Test
    public void hw1Test(){
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        //Step 1:Navigate to test site
        driver.navigate().to("https://jdi-framework.github.io/tests/");
        //Step 2:Assert browser title
        Assert.assertTrue(driver.getTitle().equals("Index Page"));
        Assert.assertEquals(driver.getTitle(), GOOGLE,
                String.format("Actual: %s but expected: %s", driver.getTitle(), GOOGLE));
    }

    @AfterMethod
    public void afterMethod() {
        softAssert.assertAll();
        driver.close();
    }
}
