package com.spbstu.hw5;

import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.*;
import com.spbstu.utils.AllureListener;
import com.spbstu.hw5.entities.Data;
import com.spbstu.utils.ResourceLoader;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Title;

import static com.epam.jdi.uitests.core.settings.JDISettings.driverFactory;
import static com.epam.jdi.uitests.web.selenium.elements.composite.WebSite.init;
import static com.spbstu.hw4.enums.HOME_PAGE_DATA.*;
import static com.spbstu.hw5.JDITestSite.login;
import static com.spbstu.hw5.JDITestSite.openMetalsAndColorsPage;
import com.spbstu.utils.TestConfig;

@Features("JDI test site")
@Listeners(AllureListener.class)
public class JDITest extends TestNGBase  {
    private double ratio = 0.9;
    @DataProvider(name = "dataProvider")
    public Object[][] createData() {
        return ResourceLoader.getAllData();
    }

    @BeforeSuite
    public void beforeSuite() {
        driverFactory.setDriverPath(ConfigFactory.create(TestConfig.class).driverFolder());
        init(JDITestSite.class);
        driverFactory.getDriver("CHROME");
    }

    @BeforeTest(description = "Verify that user can login on JDI site")
    public void beforeTest() {
        //Navigate to Homepage
        JDITestSite.getHomePageJDI().open();
        JDITestSite.zoom(ratio);
        JDITestSite.getHomePageJDI().checkOpened();
        //Perform login
        login(LOGIN.toString(), PASSWORD.toString());

        //Navigate to Metals And Colors Page
        openMetalsAndColorsPage();
        JDITestSite.getMetalsAndColorsPageJDI().checkOpened();
    }

    @Test(dataProvider = "dataProvider")
    @Title("Check selection on page")
    public void websiteTest(@Parameter("Data") Data data) {
        JDITestSite.getMetalsAndColorsPageJDI().fillMetalsAndColorsForm(data);
        JDITestSite.getMetalsAndColorsPageJDI().checkMetalsAndColorsForm(data);
    }
}