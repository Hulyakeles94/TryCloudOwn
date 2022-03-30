package com.tryCloud.pages;

import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// http://qa2.trycloud.net/index.php/apps/spreed/
public class TalkPage {

    public TalkPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[type='text']")
    public WebElement searchinputBox;

    @FindBy(xpath = "//ul[@class='conversations']//li")
    public WebElement searchedUserFromSearchBox;

    @FindBy(xpath = "//div[@placeholder='Write message, @ to mention someone …']")
    public WebElement writeMessageOrMentionSomeoneInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[starts-with(@id,\"message\") and @class='message']//div[@class='rich-text--wrapper']")
    public List<WebElement> sentMessagesList;

    public void GoToUserFromSearchedBox(String user){
        String searchedUserLocator = "//ul[@class='conversations']//a[@aria-label='Conversation, "+user+"']";
        BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath(searchedUserLocator)),5);
        Driver.getDriver().findElement(By.xpath(searchedUserLocator)).click();
        BrowserUtils.waitForPageToLoad(5);
    }


}