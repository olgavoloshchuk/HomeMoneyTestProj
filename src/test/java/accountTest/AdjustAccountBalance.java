package accountTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AdjustAccountBalance extends ParentTest {
    final String adjustedAccountName = "Cash";
    final String adjustedAmount = "500";
    final String initialAmount = "0";
    final String adjustCategory = "No category";

    @Test
    public void adjustAccountBalance(){
        loginPage.userValidLogin("olga.voloshchuk@gmail.com", "Mytestpass");
//        mainPage.adjustAccountBalance(adjustedAccountName, adjustCategory, adjustedAmount);
//        checkAC("Balance was not adjusted",mainPage.checkAccountBalance(adjustedAccountName).equals(adjustedAmount), true);
//        mainPage.adjustAccountBalance(adjustedAccountName, adjustCategory, initialAmount);
//        checkAC("Balance was not returned to initial", mainPage.checkAccountBalance(adjustedAccountName).equals(initialAmount), true);

    }
}
