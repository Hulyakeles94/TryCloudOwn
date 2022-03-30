package com.tryCloud.pages;

import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    @FindBy(css = "svg[viewBox~='24']")
    public WebElement searchIcon;

    @FindBy(xpath = "//input[@type=\'search\']")
    public WebElement searchInput;

    //this list of web elements contains 1 extra at the end
    @FindBy(xpath = "//ul[@id='appmenu']//a")
    public List<WebElement> subModules;

    @FindBy(xpath = "//ul[@aria-label='Files']//h3")
    public WebElement expectedSearchResult;

    @FindBy(xpath = "//input[@aria-label='Reset search']")
    public WebElement resetsearchBtn;

    @FindBy(xpath = "(//div[@class='empty-content']//h2[@class='empty-content__title'])[1]")
    public WebElement NoResultMessageForSearch;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void navigateToModule(String module){
        module=module.toLowerCase();
        String locator;
        if(module.equals("talk")){
            locator = "//ul[@id='appmenu']//li[@data-id='spreed']";
            Driver.getDriver().findElement(By.xpath(locator)).click();
            BrowserUtils.waitForPageToLoad(5);
        }else{
            locator = "//ul[@id='appmenu']//li[@data-id='"+module+"']";
            Driver.getDriver().findElement(By.xpath(locator)).click();
            BrowserUtils.waitForPageToLoad(5);
        }
    }
}