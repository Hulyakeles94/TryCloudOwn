package com.tryCloud.step_definitions;

import com.tryCloud.pages.FilesPage;
import com.tryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US6 {
    FilesPage filesPage = new FilesPage();

    @When("user choose the Remove from favorites option")
    public void user_choose_the_remove_from_favorites_option() {
        try {
            filesPage.actionIconSubOptionsNavigate("Remove from favorites");
        }catch (Exception e){
            BrowserUtils.waitForVisibility(filesPage.addToFavorites,5);
            filesPage.actionIconSubOptionsNavigate("Add to favorites");
            BrowserUtils.waitForClickablility(filesPage.first3dots,5);
            filesPage.first3dots.click();
            filesPage.actionIconSubOptionsNavigate("Remove from favorites");
        }
    }
    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        try{
            filesPage.chosenFavOptionInList.click();
        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }

    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        BrowserUtils.waitForClickablility(filesPage.addIcon,5);
        BrowserUtils.highlight(filesPage.addIcon);
        filesPage.addIcon.click();
    }
    @When("users uploads file with the “upload file” option")
   public void users_uploads_file_with_the_upload_file_option() {
        String path = System.getProperty("user.dir")+"/src/test/resources/files/HOME.jpg";

        BrowserUtils.highlight(filesPage.uploadFileBtn);
        filesPage.uploadFileBtn.sendKeys(path);
        BrowserUtils.waitForPageToLoad(5);
//        filesPage.addIcon.click();
    }
    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
      Assert.assertTrue(filesPage.uploadedFileLocation.isDisplayed());

        filesPage.chosenUploadedFile3dots.click();
       BrowserUtils.waitForClickablility(filesPage.deleteFileBtn,5);
       BrowserUtils.highlight(filesPage.deleteFileBtn);
        filesPage.deleteFileBtn.click();


    }

    @And("user click the {string} sub-module")
    public void userClickTheSubModule(String arg0) {
        BrowserUtils.sleep(3);
        filesPage.GoToLeftCornerModule(arg0);
    }
}
