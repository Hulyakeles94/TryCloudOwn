package com.tryCloud.step_definitions;

import com.tryCloud.pages.BasePage;
import com.tryCloud.pages.LoginPage;
import com.tryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class US3 {

    BasePage basePage=new BasePage();
    LoginPage loginPage=new LoginPage();

    @When("the users  log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        loginPage.login();
    }
    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedText) {
        List<String> actualText = new ArrayList<>();

        basePage.subModules.forEach(p->actualText.add(p.getAttribute("aria-label")));

        actualText.remove(actualText.size()-1);

        Assert.assertEquals(expectedText,actualText);

    }

}
