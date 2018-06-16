package com.spbstu.hw1;

import com.spbstu.selenium.BaseSeleniumTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hamlet on 28.03.2018.
 */
public class AppTest extends BaseSeleniumTest {

    public static final String testTitle = "Index Page";
    public static final String testLogin = "epam";
    public static final String testPass = "1234";
    public static final String testName = "Piter Chailovskii";
    public static final int testImagesCount = 4;
    public static final int testTextsCount = 4;
    public static final List<String> testTexts = Arrays.asList("To include good practices\nand ideas from successful\nEPAM projec", "To be flexible and\ncustomizable", "To be multiplatform", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    private ChromeDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", config.pathToDriver());
    }

    @Test
    public void hw1Test(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        //Step 1:Navigate to test site
        driver.navigate().to("https://jdi-framework.github.io/tests/");

        //Step 2:Assert browser title
        Assert.assertEquals(driver.getTitle(), testTitle,
                String.format("Actual: %s but expected: %s", driver.getTitle(), testTitle));

        //Step 3:Perform login
        driver.findElementByClassName("profile-photo").click();
        driver.findElementById("Login").sendKeys(testLogin);
        driver.findElementById("Password").sendKeys(testPass);
        driver.findElementByClassName("form-horizontal").submit();
        Assert.assertTrue(driver.findElementByClassName("logout").isEnabled(),"Login failed");

        //Step 4:Assert username
        Assert.assertEquals(driver.findElementByCssSelector("div.profile-photo > span").getAttribute("innerText"),testName,"Name is not displayed");

        //Step 5:Assert browser title
        Assert.assertEquals(driver.getTitle(), testTitle,
                String.format("Actual: %s but expected: %s", driver.getTitle(), testTitle));

        //Step 6:Check displayed images
        List<WebElement> images = driver.findElementsByClassName("icons-benefit");
        Assert.assertEquals(images.size(), testImagesCount,"Error: Count of images is not matching");
        images.forEach(e -> Assert.assertTrue(e.isDisplayed(),"There is an image, which isn't displayed."));

        //Step 7:Check displayed texts
        List<WebElement> texts = driver.findElementsByClassName("benefit-txt");
        Assert.assertEquals(texts.size(), testTextsCount,"Error: Count of images is not matching");

        texts.forEach(e -> {
                    Assert.assertTrue(e.isDisplayed(), "There is a text, which isn't displayed.");
                    Assert.assertEquals(e.getText(),testTexts.get(texts.indexOf(e)), String.format("Actual: %s but expected: %s", e.getText(), testTexts.get(texts.indexOf(e))));
                }
        );

        //Step 8:Check displayed header texts
        Assert.assertTrue(driver.findElementsByClassName("main-title").get(0).isDisplayed(),"Main title is'n displayed");
        Assert.assertTrue(driver.findElementsByClassName("main-txt").get(0).isDisplayed(),"Main text is'n displayed");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
