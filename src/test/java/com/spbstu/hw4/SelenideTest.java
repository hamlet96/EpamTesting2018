package com.spbstu.hw4;

import com.spbstu.hw4.enums.DIFFPAGE_ELEMENTS;
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
    public void selenideTest1() {
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

        //Click
        EpamTestSiteSelenide.differentElementsSelenide.differentElementsPageButton.click();

        //Check boxes
        EpamTestSiteSelenide.differentElementsSelenide.checkDiffBoxesExists();

        //Checkbox
        EpamTestSiteSelenide.differentElementsSelenide.selectBoxElements(DIFFPAGE_ELEMENTS.CHECK_BOXES.strAr[0]);
        EpamTestSiteSelenide.differentElementsSelenide.selectBoxElements(DIFFPAGE_ELEMENTS.CHECK_BOXES.strAr[2]);

        //Choose metal
        EpamTestSiteSelenide.differentElementsSelenide.selectRadioElements(DIFFPAGE_ELEMENTS.RADIOS.strAr[3]);

        //Color from dropdown
        EpamTestSiteSelenide.differentElementsSelenide.selectColorElement(DIFFPAGE_ELEMENTS.DROP_COLORS.strAr[3]);

        //Uncheck
        EpamTestSiteSelenide.differentElementsSelenide.selectBoxElements(DIFFPAGE_ELEMENTS.CHECK_BOXES.strAr[0]);
        EpamTestSiteSelenide.differentElementsSelenide.selectBoxElements(DIFFPAGE_ELEMENTS.CHECK_BOXES.strAr[2]);
        

        //Check logs
        EpamTestSiteSelenide.differentElementsSelenide.checkSelectedElements(DIFFPAGE_ELEMENTS.SELECT_ELEMENTS.strAr);
    }

    @AfterClass
    public void afterClass() {
        EpamTestSiteSelenide.close();
    }
}