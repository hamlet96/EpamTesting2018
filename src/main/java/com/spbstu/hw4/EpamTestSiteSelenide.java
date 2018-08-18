package com.spbstu.hw4;

import com.spbstu.hw4.pages.HomePageSelenide;


public class EpamTestSiteSelenide {
    static public HomePageSelenide homePageSelenide;
    //static public ContactFormPageSelenide contactFormPageSelenide;
    public static void init() {
        homePageSelenide = new HomePageSelenide();
        //contactFormPageSelenide = new ContactFormPageSelenide();
    }
    public static void close() {
        homePageSelenide.close();
    }
}
