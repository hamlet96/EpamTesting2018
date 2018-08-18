package com.spbstu.hw4;

import com.spbstu.hw3.EpamTestSite;
import com.spbstu.hw4.enums.HOME_PAGE_DATA;
import com.spbstu.selenide.BaseSelenideTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.spbstu.hw4.enums.HOME_PAGE_DATA.*;

/**
 * Created by dmitry on 21.03.2018.
 * Edited by Hamlet on 18.08.2018.
 */
public class SelenideTest extends BaseSelenideTest {
    @BeforeClass
    public void beforeClass() {
        EpamTestSiteSelenide.init();
    }
    @Test
    public void selenideTest() {
        //Navigate to test site
        EpamTestSiteSelenide.homePageSelenide.open();

        //Perform login
        EpamTestSiteSelenide.homePageSelenide.login(LOGIN.toString(), PASSWORD.toString());

        //Check username
        EpamTestSiteSelenide.homePageSelenide.checkUsername(USER_NAME.toString());

        //Check displayed images
        EpamTestSiteSelenide.homePageSelenide.checkDisplayedImages(IMAGES_COUNT.getInt());

        //Check texts
        EpamTestSiteSelenide.homePageSelenide.checkTexts(TEXTS.strAr);

        //Check services
        EpamTestSiteSelenide.homePageSelenide.checkServices(SERVICES.strAr);
    }


    @AfterClass
    public void afterClass() {
        EpamTestSiteSelenide.close();
    }
}