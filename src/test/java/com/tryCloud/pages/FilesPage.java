package com.tryCloud.pages;

import com.tryCloud.utilities.BrowserUtils;
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

    @FindBy(xpath = "//a[@data-templatename='New folder']")
    public WebElement newFolderBtn;

    @FindBy(id = "view13-input-folder")
    public WebElement newFolderInputBox;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement newFolderSubmitBtn;

    @FindBy(xpath = "//tr[@data-file='HulyaFileAdded']")
    public WebElement newFolderLocation;

    @FindBy(xpath = "//*[@id=\"fileList\"]//span[.='HULYAFILE']")
    public WebElement newFolderInsideNewFileLocation;

    @FindBy(xpath ="//*[@id=\"fileList\"]//span[.='HULYAFILE']/../following-sibling::span//span[@class='icon icon-more']/.." )
    public WebElement newFolderInsideNewFile3Dots;

    @FindBy(xpath = "//*[@id=\"fileList\"]//span[.='HulyaFileAdded']/../following-sibling::span//span[@class='icon icon-more']/..")
    public WebElement newFolder3Dots;

    @FindBy(xpath = "//li[@class=' action-delete-container']")
    public WebElement deleteFolderBtn;

    @FindBy(xpath = "//a[.='Deleted files']")
    public WebElement deletedFilesModule;

    @FindBy(xpath = "//tr[1]//span[@class='innernametext']")
    public WebElement chosenFolderForDelete;

    @FindBy(xpath = "//tr//span[@class='innernametext']/..")
    public List<WebElement> deletedFilesFoldersList;
    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.=' Restore']/..")
    public List<WebElement> restoreBtn;

    public WebElement uploadedFileLocator(String uploadedFileName){
        String locatorForUploadedFile="(//span[.='"+uploadedFileName+"'])[2]";
        return Driver.getDriver().findElement(By.xpath(locatorForUploadedFile));
    }

    public void actionIconSubOptionsNavigate(String optionName){
        ////div[@id='rightClickMenu']//span[.='"+optionName+"']/..
        String optionLocator="//span[.='"+optionName+"']/..";
        BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath(optionLocator)),5);
        Driver.getDriver().findElement(By.xpath(optionLocator)).click();
    }


    }