package com.tryCloud.step_definitions;

import com.tryCloud.pages.FilesPage;
import com.tryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US5 {
    FilesPage filesPage=new FilesPage();
    String chosenFileText;
    @When("the user clicks action-icon  from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        BrowserUtils.waitForClickablility(filesPage.first3dots,5);
        filesPage.first3dots.click();
    }

    @And("user choose the Add to favorites option")
    public void userChooseTheAddToFavoritesOption() {
        if(filesPage.addToFavorites.getText().equals("Add to favorites")){
        BrowserUtils.waitForClickablility(filesPage.addToFavorites,5);
            filesPage.addToFavorites.click();
            BrowserUtils.waitFor(5);
        }else{
            filesPage.addToFavorites.click();
            BrowserUtils.waitForClickablility(filesPage.first3dots,5);
            filesPage.first3dots.click();
            filesPage.addToFavorites.click();
        }
        chosenFileText=filesPage.choosenFavOption.getText();
    }

    @When("user click the Favorites sub-module")
    public void user_click_the_sub_module() {
            filesPage.FavoritesModule.click();
            BrowserUtils.waitFor(5);
    }
    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        String chosenFileInListTest=filesPage.chosenFavOptionInList.getText();
        Assert.assertEquals(chosenFileText,chosenFileInListTest);
    }


}
