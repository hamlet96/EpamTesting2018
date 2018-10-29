package com.spbstu.hw4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;


/**
 * Created by Hamlet on 12.08.2018.
 */
public class HomePageSelenide {
    @FindBy(css = ".profile-photo")
    SelenideElement profilePhoto;

    @FindBy(css = "#Login")
    SelenideElement loginField;

    @FindBy(css = "#Password")
    SelenideElement passwordField;

    @FindBy(css = "form .btn-login")
    SelenideElement submit;

    @FindBy(className = "logout")
    SelenideElement logout;

    @FindBy(className = "main-title")
    SelenideElement maintTitle;

    @FindBy(className = "main-txt")
    SelenideElement mainText;

    @FindBy(className = "icons-benefit")
    ElementsCollection images;

    @FindBy(css = "div.profile-photo > span")
    SelenideElement username;

    @FindBy(className = "benefit-txt")
    ElementsCollection texts;

    @FindBy(css = "li.dropdown")
    SelenideElement serviceHeader;

    @FindBy(css = "li.sub-menu")
    SelenideElement serviceLeft;
    public HomePageSelenide() {
        Selenide.page(this);
    }
    @Step("Log in home page")
    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
        Selenide.zoom(0.5); //Jenkins cheat
    }

    public void close() {
        Selenide.close();
    }

    @Step("Login")
    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.click();
        logout.shouldBe(visible);
    }
    @Step("Checking Username")
    public void checkUsername(String uname){
        username.shouldHave(text(uname));
    }
    @Step("Checking Images")
    public void checkDisplayedImages(Integer count){
        images.shouldHaveSize(count);
        for (SelenideElement e : images){
            e.shouldBe(visible);
        }
    }
    @Step("Checking Texts")
    public void checkTexts(String[] str){
        texts.shouldHaveSize(str.length);

        int counter = 0;
        for (SelenideElement e : texts) {
            e.shouldHave(text(str[counter++]));
        }
        mainText.shouldBe(visible);
        maintTitle.shouldBe(visible);
    }
    @Step("Checking Services")
    public void checkServices(String[] str){
        serviceLeft.click();
        serviceHeader.click();
        for (int i = 0; i < str.length; i++) {
            serviceLeft.shouldHave(text(str[i]));
            serviceHeader.shouldHave(text(str[i]));
        }
    }
}