package pages;

import libs.ActionsWithElements;
import libs.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage {

    @FindBy(id = "ctl00_ctl00_Top_LV2_LoginStatus2")
    private WebElement signOutRef;

    @FindBy(xpath = ".//ul//li//a[@href='/app/']")
    private WebElement controlPanel;

    @FindBy(id = "template_button_big")
    private WebElement addAccountButton;

    @FindBy(name = "accountName")
    private WebElement accountNameEnterForm;

    @FindBy(xpath = ".//*[@class='create-account-ctrl-currency' and @data-name = '₴']//input[@class='create-account-ctrl-currency-chk' and @type='checkbox']")
    private WebElement currencyCheckBox;

    @FindBy(xpath = ".//*[@id='FormEdit_account_chzn']//a[@class='chzn-single']")
    private WebElement expenceFromAcDD;

    @FindBy(xpath = ".//*[@id='OperationAdd_categoryExp_chzn']//a//b")
    private WebElement expenceCategoryDD;

    @FindBy(id = "OperationAdd_total")
    private WebElement expenceAmountEnterForm;

    @FindBy(id = "OperationAdd_btnAdd")
    private WebElement addExpenceButton;

    @FindBy(xpath = ".//a[contains(text(), 'Additional')]")
    private WebElement additionalMenu;

    @FindBy(xpath = ".//li//a[@href='/app/CategoryManager.aspx']")
    private WebElement categoriesSubMEnu;

    @FindBy(xpath = ".//*[@class='operation_view_last_item']")
    private WebElement allOpers;

    @FindBy(xpath = ".//li//a[@href='/app/Additional.aspx']")
    private WebElement settingsSubMEnu;

    @FindBy(id = "BalanceInDefaultCurrency")
    private WebElement networthBalance;

    @FindBy(xpath = ".//*[@class='account']")
    private WebElement defaultAccount;

    @FindBy(xpath = ".//a[@href='target']")
    private WebElement addGoalButton;


    public MainPage(WebDriver webDriver) {
        super(webDriver, "/app/");
    }

    public boolean isSignOutRefPresent() {
        return actionsWithElements.isElementDisplayed(signOutRef);
    }

    public boolean isControlPanelOpened() {
        return actionsWithElements.isElementDisplayed(controlPanel);
    }

    public void signOut() {
        actionsWithElements.clickOnElement(signOutRef);
    }

    public void selectExpenceAccountFromList(String accountName) {
        actionsWithElements.clickOnElement(expenceFromAcDD);
        actionsWithElements.clickOnElement(".//li[text()='" + accountName + "']");
    }

    public void selectExpenceCategoryFromList(String expenceCategoryNum) {
        actionsWithElements.clickOnElement(expenceCategoryDD);
        actionsWithElements.clickOnElement(".//*[@id='OperationAdd_categoryExp_chzn_o_"+expenceCategoryNum+"']");
    }

    public void enterExpenceAmount(String expenceAmount) {
        actionsWithElements.enterTextToElement(expenceAmountEnterForm, expenceAmount);
    }

    public void clickOnAddExpenceButton() {
        actionsWithElements.clickOnElement(addExpenceButton);
    }

    public void menuAdditionalCatgoriesOpen() {
        actionsWithElements.clickOnElement(additionalMenu);
        actionsWithElements.clickOnElement(categoriesSubMEnu);
    }

    public void menuAdditionalSettingsOpen() {
        actionsWithElements.clickOnElement(additionalMenu);
        actionsWithElements.clickOnElement(settingsSubMEnu);
    }

    public boolean isOperInList(){
        return actionsWithElements.isElementInList(".//*[@class='operation_view_last_item']");
    }


   public String checkAccountBalance(String adjustedAccountName) {
        return "500";
    }

    public boolean isExpenceAdded(String expenceAmount) {
        return actionsWithElements.isElementInListOnlyOne(".//*[@title='"+expenceAmount+".00 ₴ ']");
    }

    public String checkNetWorhBalance() {
       return actionsWithElements.getTextFromElement(networthBalance);
    }

    public void clickAddGoalButton() {
        actionsWithElements.clickOnElement(addGoalButton);
    }
}
