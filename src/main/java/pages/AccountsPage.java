package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPage extends ParentPage {

    @FindBy(xpath = ".//a[@href='/app/Accounts.aspx']")
    private WebElement accountsPageMenu;

    @FindBy(id = "ctl00_ctl00_Main_Main_acList_btnAddAccount")
    private WebElement addAccountButton;

    @FindBy(id = "ctl00_ctl00_Main_Main_acList_hmNewAccount_txtAccountName")
    private WebElement accountNameEnterForm;

    @FindBy(id = "ctl00_ctl00_Main_Main_acList_hmNewAccount_rCurrencyDetails_ctl00_cbActiveCurrency")
    private WebElement currencyUAHCheckbox;

    @FindBy(id = "ctl00_ctl00_Main_Main_acList_hmNewAccount_btnSave")
    private WebElement addButton;

    @FindBy(id = "ctl00_ctl00_Top_LV2_LoginStatus2")
    private WebElement signOutRef;

    public AccountsPage(WebDriver webDriver) {
        super(webDriver, "/app/accounts.aspx");
    }

    @Step
    public void goToAccountsPage() {
        actionsWithElements.clickOnElement(accountsPageMenu);
    }

    @Step
    public void pressAccountAddButton() {
        actionsWithElements.clickOnElement(addAccountButton);
    }

    @Step
    public void enterAccountName(String accountName) {
        actionsWithElements.enterTextToElement(accountNameEnterForm, accountName);
    }

    @Step
    public void setCurrencyUAH() {
        actionsWithElements.setCheckBoxState(currencyUAHCheckbox, "check");
    }

    @Step
    public void pressAddButton() {
        actionsWithElements.clickOnElement(addButton);

    }

    @Step
    public void addAccount(String accountName) {
        pressAccountAddButton();
        enterAccountName(accountName);
        setCurrencyUAH();
        pressAddButton();
    }

    @Step
    public boolean isAccountExists(String accountName) {
        return actionsWithElements.isElementDisplayed(".//*[@class = 'accountitem']//*[@class='name']//a[text()='" + accountName + "']");
    }

    @Step
    public void deleteAccount(String accountName) {
        actionsWithElements.clickOnElement(".//*[@class = 'accountitem']//*[@class='name']//a[text()='" + accountName + "']//..//..//*[@class='controls']//a[text()='Delete']");
        actionsWithAllerts.allertAccept();
        actionsWithElements.clickOnElement(".//input[@class='updatebutton' and @type = 'submit' and @value = 'Delete']");
    }

    @Step
    public void signOut() {
        actionsWithElements.clickOnElement(signOutRef);
    }
}
