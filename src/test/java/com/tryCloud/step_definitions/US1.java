package com.tryCloud.step_definitions;

import com.tryCloud.pages.LoginPage;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US1 {
    LoginPage loginPage = new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        String actualTittle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTittle.contains("Trycloud"));
    }
    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String string, String string2) {
        loginPage.userInput.sendKeys(string);
        loginPage.passwordInput.sendKeys(string2);
    }
    @When("user click the login button")
    public void user_click_the_login_button() {
        loginPage.loginBtn.click();
    }

    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        String actualTittle= Driver.getDriver().getTitle();
        Assert.assertTrue(actualTittle.contains("Dashboard"));
    }
}
