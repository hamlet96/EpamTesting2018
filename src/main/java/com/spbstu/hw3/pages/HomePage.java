package com.spbstu.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by dmitry on 14.03.2018.
 * Edited by Hamlet
 */
public class HomePage {
    @FindBy(css = ".profile-photo")
    WebElement profilePhoto;

    @FindBy(css = "#Login")
    WebElement loginField;

    @FindBy(css = "#Password")
    WebElement passwordField;

    @FindBy(css = "form .btn-login")
    WebElement submit;

    @FindBy(className = "logout")
    WebElement logout;

    @FindBy(className = "main-title")
    List<WebElement> maintTitle;

    @FindBy(className = "main-txt")
    List<WebElement> mainText;

    @FindBy(className = "icons-benefit")
    List<WebElement> images;

    @FindBy(css = "div.profile-photo > span")
    WebElement username;

    @FindBy(className = "benefit-txt")
    List<WebElement> texts;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    public String getTitle(){return driver.getTitle();}

    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.click();
    }

    public boolean isAuthorized(){
        return logout.isEnabled();
    }

    public String getUsername(){
        return username.getAttribute("innerText");
    }
    public boolean checkDisplayedImages(){
        for (WebElement e : images){
            if(!e.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public int countOfDisplayedImages(){
        return images.size();
    }

    public int countOfTexts(){
        return texts.size();
    }

    public boolean checkDisplayedTexts(List<String> texts){
        int counter = 0;
        for (WebElement e : images){
            if(!e.isDisplayed()) {
                return false;
            }
            if(e.getText().equals(texts.get(counter))) {
                return false;
            }
            counter++;
            }
        return true;
    }
    public boolean checkMainTitle(){
        return maintTitle.get(0).isDisplayed();
    }
    public boolean checkMainText(){
        return mainText.get(0).isDisplayed();
    }
}