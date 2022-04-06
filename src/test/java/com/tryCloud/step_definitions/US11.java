package com.tryCloud.step_definitions;

import com.tryCloud.pages.TalkPage;
import com.tryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US11 {
    TalkPage talkPage = new TalkPage();
    @When("user search user {string} from the search box")
    public void user_search_user_from_the_search_box(String user) {
        talkPage.GoToUserFromSearchedBox(user);
    }
    @When("user write {string} message")
    public void user_write_message(String string) {
        BrowserUtils.highlight(talkPage.writeMessageOrMentionSomeoneInput);
        BrowserUtils.waitForClickablility(talkPage.writeMessageOrMentionSomeoneInput,5);
        talkPage.writeMessageOrMentionSomeoneInput.click();
        talkPage.writeMessageOrMentionSomeoneInput.sendKeys(string);
        BrowserUtils.waitForClickablility(talkPage.submitBtn,5);
    }
    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() {
        talkPage.submitBtn.click();
    }

    @Then("the user should be able to see the {string} message is displayed on the conversation log")
    public void the_user_should_be_able_to_see_the_message_is_displayed_on_the_conversation_log(String expectedMessage) {
        String actualMessage = talkPage.sentMessagesList.get(talkPage.sentMessagesList.size() - 1).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
