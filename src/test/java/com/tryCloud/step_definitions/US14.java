package com.tryCloud.step_definitions;

import com.tryCloud.pages.BasePage;
import com.tryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US14 {

    BasePage basePage=new BasePage();

    @When("the user clicks the magnifier icon on the right top")
    public void the_user_clicks_the_magnifier_icon_on_the_right_top() {
        BrowserUtils.waitForClickablility(basePage.searchIcon,5);
        basePage.searchIcon.click();
    }
    @And("users search any {string} existing file folder user name")
    public void usersSearchAnyExistingFileFolderUserName(String arg0) {
        basePage.searchInput.sendKeys(arg0);
        BrowserUtils.waitForVisibility(basePage.resetsearchBtn,5);
    }

    @Then("verify the {string} displays the expected result option")
    public void verify_the_app_displays_the_expected_result_option(String expected) {
        try {
            String actualResult=basePage.expectedSearchResult.getText();
            Assert.assertTrue(actualResult.contains(expected));
        }catch (Exception e){
            Assert.assertTrue(basePage.NoResultMessageForSearch.isDisplayed());
        }

    }


}
