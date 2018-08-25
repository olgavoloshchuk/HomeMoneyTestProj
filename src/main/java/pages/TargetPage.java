package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TargetPage extends ParentPage {

    @FindBy(id = "ctl00_ctl00_Main_Main_tm1_editForm_txtTitle")
    private WebElement fieldTargetName;

    @FindBy(id = "ctl00_ctl00_Main_Main_tm1_editForm_txtTotal")
    private WebElement fieldTargetSum;

    @FindBy(id = "ctl00_ctl00_Main_Main_tm1_editForm_btnSave")
    private WebElement saveTargetButton;

    @FindBy(id = "ctl00_ctl00_Main_Main_tm1_editForm_cbDisplayDashboard")
    private WebElement reflectOnControlPanel;

    @FindBy(id = "ctl00_ctl00_Main_Main_tm1_btnShowAdd")
    private WebElement addGoalButton;

    public TargetPage(WebDriver webDriver) {
        super(webDriver, "/app/target/");
    }

    public void enterTargetName(String targetName) {
        actionsWithElements.enterTextToElement(fieldTargetName, targetName);
    }

    public void enterTargetSum(String targetSum) {
        actionsWithElements.enterTextToElement(fieldTargetSum, targetSum);
    }

    public void pressSaveButton() {
        actionsWithElements.clickOnElement(saveTargetButton);
    }

    public boolean isGoalExists(String targetName) {
        return actionsWithElements.isElementDisplayed(".//h2[contains(text(), '" + targetName + "')]");
    }

    public void uncheckReflectOnControlPanel() {
        actionsWithElements.setCheckBoxState(reflectOnControlPanel, "uncheck");
    }

    public boolean isAddGoalButtonExists() {
        return actionsWithElements.isElementEnabled(addGoalButton);
    }

    public void clickAddGoalButton() {
        actionsWithElements.clickOnElement(addGoalButton);


    }

    public void moveCursorToTarget(String targetName) {
        actionsWithElements.moveToElement(".//h2[contains(text(), '" + targetName + "')]");
    }

    public void clickDeleteTargetButton(String targetName) {
        actionsWithElements.moveToElementAndClick(".//h2[contains(text(), '" + targetName + "')]//..//input[@title='Delete']");
        actionsWithAllerts.allertAccept();
    }
}
