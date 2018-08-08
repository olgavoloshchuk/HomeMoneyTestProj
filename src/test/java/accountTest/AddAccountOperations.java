package accountTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddAccountOperations extends ParentTest {
    final String accountName1 = "Test account 1";
    final String accountName2 = "Test account2";

    @Test
    public void addAccounts() {
        loginPage.userValidLogin("olga.voloshchuk@gmail.com", "Mytestpass");
        accountsPage.addAccount(accountName1);
        accountsPage.isAccountExists(accountName1);
        accountsPage.addAccount(accountName2);
        accountsPage.isAccountExists(accountName2);
    }


}
