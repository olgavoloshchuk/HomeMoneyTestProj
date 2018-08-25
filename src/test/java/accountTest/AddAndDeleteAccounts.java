package accountTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddAndDeleteAccounts extends ParentTest {
    final String accountName1 = "Test account 1";
    final String accountName2 = "Test account 2";

    @Test
    public void addAndDeleteAccounts() {
        loginPage.userValidLogin("olga.voloshchuk@gmail.com", "Mytestpass");
        accountsPage.openPage("/app/accounts.aspx");
        accountsPage.addAccount(accountName1);
        checkAC("Account was not added", accountsPage.isAccountExists(accountName1), true);
        accountsPage.addAccount(accountName2);
        checkAC("Account was not added", accountsPage.isAccountExists(accountName2), true);
        accountsPage.openPage("/app/accounts.aspx");
        accountsPage.deleteAccount(accountName1);
        checkAC("Account was not deleted", accountsPage.isAccountExists(accountName1), false);
        accountsPage.deleteAccount(accountName2);
        checkAC("Account was not deleted", accountsPage.isAccountExists(accountName2), false);
        accountsPage.signOut();
    }


}
