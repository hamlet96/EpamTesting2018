package com.spbstu.hw3;

import com.spbstu.hw1.AppTest;
import com.spbstu.utils.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


/**
 * Created by dmitry on 14.03.2018.
 */
public class LoginTests {

    WebDriver driver;
    protected static TestConfig config;

    @BeforeSuite
    public void beforeSuite() {
        config = ConfigFactory.create(TestConfig.class);
        System.setProperty("webdriver.chrome.driver", config.pathToDriver());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        EpamTestSite.init(driver);
    }

    @Test
    public void wsTest() {

        //Step 1:Navigate to test site
        EpamTestSite.homePage.open();

        //Step 2:Assert browser title
        Assert.assertEquals(EpamTestSite.homePage.getTitle(), AppTest.testTitle,
                String.format("Actual: %s but expected: %s", EpamTestSite.homePage.getTitle(),  AppTest.testTitle));

        //Step 3:Perform login
        EpamTestSite.homePage.login(AppTest.testLogin, AppTest.testPass);
        Assert.assertTrue(EpamTestSite.homePage.isAuthorized(),"Login failed");

        //Step 4:Assert username
        Assert.assertEquals(EpamTestSite.homePage.getUsername(),AppTest.testName.toUpperCase(),"Name is not displayed");

        //Step 5:Assert browser title
        Assert.assertEquals(EpamTestSite.homePage.getTitle(), AppTest.testTitle,
                String.format("Actual: %s but expected: %s", EpamTestSite.homePage.getTitle(),  AppTest.testTitle));

        //Step 6:Check displayed images
        Assert.assertEquals(EpamTestSite.homePage.countOfDisplayedImages(), AppTest.testImagesCount,"Error: Count of images is not matching");
        Assert.assertTrue(EpamTestSite.homePage.checkDisplayedImages(),"There is an image, which isn't displayed.");

        //Step 7:Check displayed texts
        Assert.assertEquals(EpamTestSite.homePage.countOfTexts(), AppTest.testTextsCount,"Error: Count of images is not matching");
        Assert.assertTrue(EpamTestSite.homePage.checkDisplayedTexts(AppTest.testTexts),"There is a text, which isn't displayed.");

        //Step 8:Check displayed header texts
        Assert.assertTrue(EpamTestSite.homePage.checkMainTitle(),"Main title is'n displayed");
        Assert.assertTrue(EpamTestSite.homePage.checkMainText(),"Main text is'n displayed");
    }

    @AfterSuite
    public void afterSuite() {
       driver.close();
    }
}