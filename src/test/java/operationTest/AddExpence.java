package operationTest;

import libs.Utils;
import org.junit.Test;
import parentTest.ParentTest;

public class AddExpence extends ParentTest {
    final String expenceCategoryNum = "1";
    final String expenceAmount = "500";

    @Test
    public void addExpence() {
        loginPage.userValidLogin("olga.voloshchuk@gmail.com", "Mytestpass");
        mainPage.menuAdditionalSettingsOpen();
        settingPage.checkCurrentUrl();
        settingPage.deleteAllOperations();
        Utils.waitABit(3);
        settingPage.menuControlPanelOpen();
        checkAC("Operations were not deleted", mainPage.checkNetWorhBalance().equals("0.00"), true);
        mainPage.checkCurrentUrl();
        mainPage.selectExpenceCategoryFromList(expenceCategoryNum);
        mainPage.enterExpenceAmount(expenceAmount);
        mainPage.clickOnAddExpenceButton();
        checkAC("Expence was not added", mainPage.isExpenceAdded(expenceAmount), true);
        mainPage.menuAdditionalSettingsOpen();
        settingPage.checkCurrentUrl();
        settingPage.deleteAllOperations();
    }
}
