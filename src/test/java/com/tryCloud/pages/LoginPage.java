package com.tryCloud.pages;

import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// http://qa2.trycloud.net/index.php/login
public class LoginPage {

    @FindBy(id = "user")
    public WebElement userInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "submit-form")
    public WebElement loginBtn;

    @FindBy(css = ".warning")
    public WebElement warningMessage;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        userInput.sendKeys(ConfigurationReader.getProperty("username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginBtn.click();
    }
}