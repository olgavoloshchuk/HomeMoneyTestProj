package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPage extends ParentPage {

    @FindBy(id = "ctl00_ctl00_Main_Main_acList_btnAddAccount")
    private WebElement addAccountButton;

    @FindBy(id = "ctl00_ctl00_Main_Main_acList_hmNewAccount_txtAccountName")
    private WebElement accountNameEnterForm;

    @FindBy(id = "ctl00_ctl00_Main_Main_acList_hmNewAccount_rCurrencyDetails_ctl00_cbActiveCurrency")
    private WebElement currencyUAHCheckbox;

    @FindBy(id = "ctl00_ctl00_Main_Main_acList_hmNewAccount_btnSave")
    private WebElement addButton;

    public AccountsPage(WebDriver webDriver) {
        super(webDriver, "/app/accounts.aspx");
    }

    public void pressAccountAddButton() {
        actionsWithElements.clickOnElement(addAccountButton);
    }

    public void enterAccountName(String accountName) {
        actionsWithElements.enterTextToElement(accountNameEnterForm, accountName);
    }

    public void setCurrencyUAH() {
        actionsWithElements.setCheckBoxState(currencyUAHCheckbox, "checked");
    }

    public void pressAddButton() {
        actionsWithElements.clickOnElement(addButton);

    }

    public void addAccount(String accountName) {
        pressAccountAddButton();
        enterAccountName(accountName);
        setCurrencyUAH();
        pressAddButton();
    }

    public void isAccountExists(String accountName) {
        actionsWithElements.isElementDisplayed(".//a[contains(text(),'" + accountName + "')]");
    }

    public void deleteAccount (String accountName) {
        WebElement webElement = webDriver.findElement(By.xpath("accountName"));
        actionsWithElements.clickOnElement(webElement);
    }
}
