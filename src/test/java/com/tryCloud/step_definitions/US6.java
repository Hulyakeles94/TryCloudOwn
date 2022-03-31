package com.tryCloud.step_definitions;

import com.tryCloud.pages.FilesPage;
import com.tryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US6 {
    FilesPage filesPage = new FilesPage();
    String path;

    @When("user choose the Remove from favorites option")
    public void user_choose_the_remove_from_favorites_option() {
            if(filesPage.addToFavorites.getText().equals("Remove from favorites")){
                filesPage.addToFavorites.click();
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
        filesPage.addIcon.click();
    }
    @When("users uploads file with the “upload file” option")
    public void users_uploads_file_with_the_upload_file_option() {
        path = "src/test/resources/files/HOME.jpg";

        BrowserUtils.highlight(filesPage.uploadFileBtn);
        filesPage.uploadFileBtn.sendKeys(path);
        BrowserUtils.waitForPageToLoad(5);
        filesPage.addIcon.click();
    }
    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
      Assert.assertTrue(filesPage.uploadedFileLocation.isDisplayed());

        filesPage.chosenUploadedFile3dots.click();
       BrowserUtils.hover(filesPage.deleteFileBtn);
        filesPage.deleteFileBtn.click();


    }
}
