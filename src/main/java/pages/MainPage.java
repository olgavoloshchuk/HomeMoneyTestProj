package pages;

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

    @FindBy(xpath = ".//*[@id='FormEdit_account_chzn']//a[@class='chzn-single']//b")
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

    public void selectExpenceFromAccountFromList(String accountName) {
        actionsWithElements.clickOnElement(webDriver.findElement(By.xpath(".//a[@class='chzn-single']//*[contains(text(), 'Cash')]")));
        actionsWithElements.clickOnElement(webDriver.findElement(By.xpath(".//li[text()='" + accountName + "']")));
//        actionsWithElements.clickElementInDD
//                (expenceFromAcDD, webDriver.findElement(By.xpath(".//li[text()='" + accountName + "']")));
    }

    public void selectExpenceCategoryFromList(String expenceCategoryName) {
        actionsWithElements.clickElementInDD(
                expenceCategoryDD, webDriver.findElement(By.xpath(".//li[text()='" + expenceCategoryName + "']"))
        );
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

/*    public void clickAddAccountButton() {
        actionsWithElements.clickOnElement(addAccountButton);
    }

    public void enterAccountName(String accountName) {
        actionsWithElements.enterTextToElement(accountNameEnterForm, accountName);
    }

    public void setNewAccountCurrency() {
        actionsWithElements.setCheckBoxState(currencyCheckBox, "checked");
    }*/
}
