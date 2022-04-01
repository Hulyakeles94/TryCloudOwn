package com.tryCloud.step_definitions;

import com.tryCloud.pages.FilesPage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US7 {
    FilesPage filesPage=new FilesPage();

    @When("user click \"new folder”")
    public void user_click_new_folder() {
//        filesPage.GoToMenuItemOption("New folder").click();
        BrowserUtils.waitForClickablility(filesPage.newFolderBtn,10);
        filesPage.newFolderBtn.click();
    }

    @When("user write a folder name")
    public void user_write_a_folder_name() {
        filesPage.newFolderInputBox.sendKeys("HulyaFileAdded");
    }

    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        BrowserUtils.waitForClickablility(filesPage.newFolderSubmitBtn,5);
        filesPage.newFolderSubmitBtn.click();
    }

    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        BrowserUtils.waitForVisibility(filesPage.newFolderLocation,5);
        Assert.assertTrue(filesPage.newFolderLocation.isDisplayed());
    }

    @When("user choose a folder from the page")
    public void user_choose_a_folder_from_the_page() {
        BrowserUtils.waitForClickablility(filesPage.newFolderLocation,10);
        filesPage.newFolderLocation.click();
    }
    @When("the user uploads a file with the upload file option")
    public void the_user_uploads_a_file_with_the_upload_file_option() {
        String pathofObject = System.getProperty("user.dir");
        String path=pathofObject+"/src/test/resources/files/HULYAFILE.jpg";
        filesPage.uploadFileBtn.sendKeys(path);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitForClickablility(filesPage.addIcon,5);
        filesPage.addIcon.click();
    }
    @Then("Verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        BrowserUtils.waitForVisibility(filesPage.newFolderInsideNewFileLocation,10);
        Assert.assertTrue(filesPage.newFolderInsideNewFileLocation.isDisplayed());

        Driver.getDriver().navigate().back();
        BrowserUtils.waitForPageToLoad(5);
        filesPage.newFolder3Dots.click();
        BrowserUtils.hover(filesPage.deleteFolderBtn);
        filesPage.deleteFolderBtn.click();
    }

}
