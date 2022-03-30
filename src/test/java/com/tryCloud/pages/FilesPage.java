package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

// http://qa2.trycloud.net/index.php/apps/files/?dir=/&fileid=200
public class FilesPage {

    @FindBy(css = "label[for='select_all_files']")
    public WebElement firstCheckBox;

    @FindBy(xpath = "//tbody//tr//td//input[@type='checkbox']/../..")
    public List<WebElement> allCheckBoxes;

    @FindBy(xpath = "//tr[1]//a[@data-action='menu']//span")
    public WebElement first3dots;

    @FindBy(xpath = "//a[@data-action='Favorite']//span")
    public WebElement addToFavorites;

    @FindBy(id = "app-navigation-toggle")
    public WebElement appNavigation;

    @FindBy(xpath = "//li[@data-id='favorites']")
    public WebElement FavoritesModule;

    @FindBy(xpath = "//tr[1]//span[@class='innernametext']")
    public WebElement choosenFavOption;

    @FindBy(xpath = "(//tr[1]//span[@class='innernametext'])[2]")
    public WebElement chosenFavOptionInList;

    @FindBy(xpath = "//*[@class='button new']")
    public WebElement addIcon;

    @FindBy(xpath = "//input[@class='hiddenuploadfield']")
    public WebElement uploadFileBtn;

    @FindBy(xpath = "//span[.='Delete file']")
    public WebElement deleteFileBtn;

    @FindBy(xpath = "//div[@id='uploadprogressbar']")
    public WebElement uploadProgress;

    @FindBy(xpath = "//*[@id=\"fileList\"]//span[.='HOME']/../following-sibling::span//span[@class='icon icon-more']/..")
    public WebElement chosenUploadedFile3dots;

    @FindBy(xpath = "//*[@id=\"fileList\"]//span[.='HOME']")
    public WebElement uploadedFileLocation;

    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public WebElement uploadedFileLocator(String uploadedFileName){
        String locatorForUploadedFile="(//span[.='"+uploadedFileName+"'])[2]";
        return Driver.getDriver().findElement(By.xpath(locatorForUploadedFile));
    }


    }