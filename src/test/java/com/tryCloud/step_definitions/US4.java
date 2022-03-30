package com.tryCloud.step_definitions;

import com.tryCloud.pages.BasePage;
import com.tryCloud.pages.FilesPage;
import com.tryCloud.pages.LoginPage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US4 {

    LoginPage loginPage=new LoginPage();
    BasePage basePage=new BasePage();
    FilesPage filesPage = new FilesPage();

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        loginPage.login();
    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        basePage.navigateToModule(string);
    }
    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }

    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        BrowserUtils.waitForClickablility(filesPage.firstCheckBox,5);
        filesPage.firstCheckBox.click();

    }
    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        filesPage.allCheckBoxes.forEach(p->Assert.assertTrue(p.getAttribute("class").contains("selected")));
    }

}
