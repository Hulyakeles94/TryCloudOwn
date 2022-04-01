package com.tryCloud.pages;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

// http://qa2.trycloud.net/index.php/apps/files/?dir=/&fileid=200
public class FilesPage {

    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "label[for='select_all_files']")
    public WebElement firstCheckBox;

    @FindBy(xpath = "//tbody//tr//td//input[@type='checkbox']/../..")
    public List<WebElement> allCheckBoxes;

    @FindBy(xpath = "//a[@data-action='menu']//span/..")
    public WebElement first3dots;

    @FindBy(xpath = "//a[@data-action='Favorite']")
    public WebElement addToFavorites;

    @FindBy(id = "app-navigation-toggle")
    public WebElement appNavigation;

    @FindBy(xpath = "//li[@data-id='favorites']")
    public WebElement FavoritesModule;

    @FindBy(xpath = "//tr[1]//span[@class='innernametext']")
    public WebElement choosenFavOption;

    @FindBy(xpath = "(//tr[1]//span[@class='innernametext'])[2]")
    public WebElement chosenFavOptionInList;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement addIcon;

    @FindBy(xpath = "//input[@id='file_upload_start']")
    public WebElement uploadFileBtn;

    @FindBy(xpath = "//span[.='Delete file']/..")
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


    @FindBy(xpath = "//span[.=' Restore']/..")
    public List<WebElement> restoreBtn;

    @FindBy(xpath = "(//li[@class='app-sidebar-tabs__tab'])[2]")
    public WebElement CommentModule;

    @FindBy(xpath = "//div[@data-placeholder='New comment …']")
    public WebElement commentInputBox;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement commentSubmitBtn;

    @FindBy(xpath = "//div[@class='submitLoading icon-loading-small hidden']")
    public WebElement submitLoadingIcon;

    public WebElement uploadedFileLocator(String uploadedFileName){
        String locatorForUploadedFile="(//span[.='"+uploadedFileName+"'])[2]";
        return Driver.getDriver().findElement(By.xpath(locatorForUploadedFile));
    }

    @FindBy(xpath = "//ul[@class='with-icon']/li")
    public List<WebElement> leftCornerModules;

    @FindBy(xpath = "//input[@class='checkbox']")
    public List<WebElement> settingCheckBoxesVerification;

    @FindBy(xpath = "//input[@class='checkbox']/..")
    public List<WebElement> settingCheckBoxesSelection;

    @FindBy(xpath = "//li[@id='quota']//p")
    public WebElement usageBtn;

    public void GoToLeftCornerModule(String moduleName){
        BrowserUtils.sleep(5);
        moduleName=moduleName.toLowerCase();
        if(moduleName.contains("all files")){
            leftCornerModules.get(0).click();
        }else if (moduleName.contains("recent")){
            leftCornerModules.get(1).click();
        }else if (moduleName.contains("favorites")){
            leftCornerModules.get(2).click();
        }else if (moduleName.contains("shares")){
            leftCornerModules.get(3).click();
        }else if (moduleName.contains("Tags")){
            leftCornerModules.get(4).click();
        }else if (moduleName.contains("Shared to Circles")){
            leftCornerModules.get(5).click();
        }else if (moduleName.contains("Deleted files")){
            leftCornerModules.get(6).click();
        }else if (moduleName.contains("used")){
            leftCornerModules.get(7).click();
        }else if(moduleName.contains("settings")) {
            Driver.getDriver().findElement(By.xpath("//div[@id='app-settings-header']//button")).click();
        }
        BrowserUtils.waitForPageToLoad(10);
    }

    public void actionIconSubOptionsNavigate(String optionName){
        String optionLocator="//span[.='"+optionName+"']/..";
        BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath(optionLocator)),5);
        BrowserUtils.highlight(Driver.getDriver().findElement(By.xpath(optionLocator)));
        Driver.getDriver().findElement(By.xpath(optionLocator)).click();
    }

    public void GoToActionIconsModule(String module){
        module=module.toLowerCase();
        if(module.equals("add to favorites")){
            module="favorite";
        }else if(module.equals("Move or copy")){
            module="movecopy";
        }else if(module.equals("Delete folder") || module.equals("Delete file")){
            module="delete";
        }
        String locator="//div[@class='fileActionsMenu popovermenu bubble open menu']//li[@class=' action-"+module+"-container']";
        WebElement eachModule = Driver.getDriver().findElement(By.xpath(locator));
        BrowserUtils.waitForClickablility(eachModule,5);
        BrowserUtils.highlight(eachModule);
        BrowserUtils.clickWithTimeOut(eachModule,5);
    }

    public WebElement GoToMenuItemOption(String option){
        BrowserUtils.waitForPageToLoad(5);
        String locator = "//ul//span[.='"+option+"']/..";
        WebElement optionLocator = Driver.getDriver().findElement(By.xpath(locator));
        BrowserUtils.highlight(optionLocator);
        return optionLocator;

    }

    }