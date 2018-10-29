package com.spbstu.hw3;

import com.spbstu.hw3.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dmitry on 14.03.2018.
 */
public class EpamTestSite {
    //public static ContactFormPage contactFormPage;
    public static HomePage homePage;

    public static void init(WebDriver driver) {
        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.manage().window().maximize();
    //    contactFormPage = PageFactory.initElements(driver, ContactFormPage.class);
    }
}