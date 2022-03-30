package com.tryCloud.pages;

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

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void navigateToModule(String module){
        module=module.toLowerCase();
        String locator = "//ul[@id='appmenu']//li[@data-id='"+module+"']";
        Driver.getDriver().findElement(By.xpath(locator)).click();

    }
}