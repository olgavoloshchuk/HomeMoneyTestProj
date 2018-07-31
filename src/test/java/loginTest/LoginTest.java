package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {
    @Test
    public void validLogIn() {
        loginPage.openPage("/login.aspx");
        loginPage.enterLogin("olga.voloshchuk@gmail.com");
        loginPage.enterPass("Mytestpass");
        loginPage.clickOnSignInButton();
        checkAC("Sign-out is not present", mainPage.isSignOutRefPresent(), true);
        checkAC("Control Panel is not opened", mainPage.isControlPanelOpened(), true);
        mainPage.signOut();
        checkAC("Sign out was not success", loginPage.isSignInButtonPresent(), true);
    }

    @Test
    public void invalidLogIn() {
        loginPage.openPage("/login.aspx");
        loginPage.enterLogin("olga.voloshchuk@gmail.com");
        loginPage.enterPass("Mytestpass1");
        loginPage.clickOnSignInButton();
        checkAC("Success login was not expected", loginPage.isSignInButtonPresent(), true);
        checkAC("Success login was not expected", loginPage.isLoginError(), true);

    }
}
