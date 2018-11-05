package com.spbstu.hw5.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import lombok.Getter;
import com.spbstu.hw5.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {
    @FindBy(css = "#Login")
    private TextField loginField;

    @FindBy(css = "#Password")
    private TextField passwordField;

    @FindBy(css = "form .btn-login")
    @Getter
    private Button submit;

    public String getLogin() {
        return loginField.toString();
    }

    public String getPassword() {
        return passwordField.toString();
    }
    public void loginAs(User user ){
        loginField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submit.click();
    }
}
