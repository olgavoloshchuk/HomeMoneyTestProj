package accountTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddExpence extends ParentTest {
    final String expenceAccount = "Cash";
    final String expenceCategory = "No category";
    final String expenceAmount = "500";

    @Test
    public void addExpence(){
        loginPage.userValidLogin("olga.voloshchuk@gmail.com", "Mytestpass");
        mainPage.selectExpenceAccountFromList(expenceAccount);
        mainPage.selectExpenceCategoryFromList(expenceCategory);
        mainPage.enterExpenceAmount(expenceAmount);
        mainPage.clickOnAddExpenceButton();
checkAC("Expence was not added", mainPage.isExpenceAdded(expenceAccount, expenceCategory, expenceAmount), true);
    }
}
