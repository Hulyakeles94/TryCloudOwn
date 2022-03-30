package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsPage {
    public ContactsPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//div[@class='vue-recycle-scroller__item-wrapper']//div[@class=\"vue-recycle-scroller__item-view\"]")
    public List<WebElement> contactsList;
}
