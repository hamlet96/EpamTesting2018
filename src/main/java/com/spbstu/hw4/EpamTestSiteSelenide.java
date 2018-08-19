package com.spbstu.hw4;

import com.spbstu.hw4.pages.HomePageSelenide;
import com.spbstu.hw4.pages.DifferentElementsSelenide;

public class EpamTestSiteSelenide {
    static public HomePageSelenide homePageSelenide;
    static public DifferentElementsSelenide differentElementsSelenide;

    public static void init() {
        homePageSelenide = new HomePageSelenide();
        differentElementsSelenide = new DifferentElementsSelenide();

    }
    public static void close() {
        homePageSelenide.close();
        differentElementsSelenide.close();
    }
}
