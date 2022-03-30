package com.tryCloud.step_definitions;

import com.tryCloud.pages.FilesPage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class US10 {
    FilesPage filesPage=new FilesPage();
    int currentUsage;
    String path;
    @When("user clicks {string} dropdown module")
    public void user_clicks_dropdown_module(String string) {
        filesPage.GoToLeftCornerModule(string);
    }
    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {

        for (int i = 0; i < filesPage.settingCheckBoxesVerification.size(); i++) {
            if(filesPage.settingCheckBoxesVerification.get(i).isSelected()){
                filesPage.settingCheckBoxesSelection.get(i).click();
                Assert.assertTrue(!filesPage.settingCheckBoxesVerification.get(i).isSelected());
            }else if(!filesPage.settingCheckBoxesVerification.get(i).isSelected()){
                filesPage.settingCheckBoxesSelection.get(i).click();
                Assert.assertTrue(filesPage.settingCheckBoxesVerification.get(i).isSelected());
            }
        }
    }

    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
        currentUsage=Integer.parseInt(filesPage.usageBtn.getText().
                substring(0,filesPage.usageBtn.getText().indexOf(" ")));
    }
    @When("user  uploads file with the upload file option")
    public void user_uploads_file_with_the_upload_file_option() {
        BrowserUtils.waitForClickablility(filesPage.addIcon,5);
        filesPage.addIcon.click();
        path = "C:\\Users\\zbura\\OneDrive\\Desktop\\HOME.jpg";

        BrowserUtils.highlight(filesPage.uploadFileBtn);
        filesPage.uploadFileBtn.sendKeys(path);
        BrowserUtils.waitForVisibility(filesPage.uploadedFileLocation,15);

    }
    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
        BrowserUtils.waitForPageToLoad(5);
    }
    @Then("the user should be able to see storage usage is increased")
    public void the_user_should_be_able_to_see_storage_usage_is_increased() {
        int newlyUsage=Integer.parseInt(filesPage.usageBtn.getText().
                substring(0,filesPage.usageBtn.getText().indexOf(" ")));
        filesPage.chosenUploadedFile3dots.click();
        BrowserUtils.hover(filesPage.deleteFolderBtn);
        filesPage.deleteFolderBtn.click();
        Assert.assertTrue((newlyUsage-currentUsage)>0);


    }


}
