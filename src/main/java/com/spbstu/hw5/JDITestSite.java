package com.spbstu.hw5;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.spbstu.hw5.entities.User;
import com.spbstu.hw5.pages.HomePageJDI;
import com.spbstu.hw5.pages.LoginForm;
import com.spbstu.hw5.pages.MetalsAndColorsPageJDI;
import static com.epam.jdi.uitests.core.settings.JDISettings.driverFactory;

@JSite("https://jdi-framework.github.io/tests/")
public class JDITestSite extends WebSite {
    @Getter
    static public HomePageJDI homePageJDI;
    @Getter
    static public MetalsAndColorsPageJDI metalsAndColorsPageJDI;
    @Getter
    static public LoginForm loginForm;

    @FindBy(tagName = "html")
    @Getter
    private static WebElement page;

    @FindBy(css = ".profile-photo")
    @Getter
    private static Label profilePhoto;

    @FindBy(css = ".logout")
    @Getter
    private static Button logout;

    @FindBy(css = ".uui-navigation | [href=\"page2.htm\"]")
    @Getter
    private static Button metalsAndColorsPageButton;

    public static void openMetalsAndColorsPage() {
        metalsAndColorsPageButton.click();
    }

    // JDI Execute JS
    public static <T> T executeJavaScript(String jsCode, Object... arguments) {
        return (T) ((JavascriptExecutor) driverFactory.getDriver()).executeScript(jsCode, arguments);
    }

    // Jenkins Cheat
    public static void zoom(double ratio) {
        executeJavaScript(
                "document.body.style.transform = 'scale(' + arguments[0] + ')';"
                        + "document.body.style.transformOrigin = '0 0';",
                ratio
        );
    }

    public static void login(String login, String password) {
        User user = new User(login, password);
        profilePhoto.click();
        loginForm.loginAs(user);
        Assert.assertTrue(logout.isDisplayed(), "Login failed");
    }

}