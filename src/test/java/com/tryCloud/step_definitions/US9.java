package com.tryCloud.step_definitions;

import com.tryCloud.pages.FilesPage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class US9 {

    FilesPage filesPage=new FilesPage();

    @And("user click Comment module")
    public void userClickCommentModule() {
        filesPage.CommentModule.click();
    }

    @When("user write a {string} comment inside the input box")
    public void user_write_a_comment_inside_the_input_box(String string) {
        BrowserUtils.waitForClickablility(filesPage.commentInputBox,5);
        BrowserUtils.highlight(filesPage.commentInputBox);
        filesPage.commentInputBox.click();
        filesPage.commentInputBox.sendKeys(string);
    }
    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {
        BrowserUtils.waitForClickablility(filesPage.commentSubmitBtn,5);
        filesPage.commentSubmitBtn.click();
    }
    @Then("Verify the {string} comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section(String expectedMessage) {
        String messageLocator="//ul[@class='comments']//div[.='"+expectedMessage+"']";
        WebElement actualMessageLocator = Driver.getDriver().findElement(By.xpath(messageLocator));

        Assert.assertEquals(expectedMessage,actualMessageLocator.getText());
    }


}
