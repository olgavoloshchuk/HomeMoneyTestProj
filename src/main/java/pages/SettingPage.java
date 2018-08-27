package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingPage extends ParentPage {
    @FindBy(id = "ctl00_ctl00_Main_Main_removeAllTransactions_btnDeleteTransactions")
    private WebElement deleteAllTransactionsButton;

    @FindBy(id = "ctl00_ctl00_Main_Main_removeAllTransactions_btnRemoveAll")
    private WebElement yesDeleteButton;

    @FindBy(xpath = ".//a[@href='/app/']")
    private WebElement controlPanelMenu;

    public SettingPage(WebDriver webDriver) {
        super(webDriver, "/app/additional.aspx");
    }

    @Step
    public void deleteAllOperations() {
        actionsWithElements.clickOnElementWithAccepAlert(deleteAllTransactionsButton);
        actionsWithElements.clickOnElement(yesDeleteButton);
    }

    @Step
    public void menuControlPanelOpen() {

        actionsWithElements.clickOnElement(controlPanelMenu);
    }
}
