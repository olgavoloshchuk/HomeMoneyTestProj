package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {
    @Test
    public void validLogIn() {
        loginPage.openPage("/login.aspx");
        loginPage.isSignInButtonPresent();
        loginPage.enterLogin("olga.voloshchuk@gmail.com");
        loginPage.enterPass("Mytestpass");
        loginPage.clickOnSignInButton();
        mainPage.checkCurrentUrl();
        checkAC("Sign-out is not present", mainPage.isSignOutRefPresent(), true);
        mainPage.signOut();
        checkAC("Sign out was not success", loginPage.isSignInButtonPresent(), true);
    }

    @Test
    public void invalidLogIn() {
        loginPage.openPage("/login.aspx");
        loginPage.isSignInButtonPresent();
        loginPage.enterLogin("olga.voloshchuk@gmail.com");
        loginPage.enterPass("Mytestpass1");
        loginPage.clickOnSignInButton();
        loginPage.checkCurrentUrl();
        checkAC("Success login was not expected", loginPage.isSignInButtonPresent(), true);
        checkAC("Success login was not expected", loginPage.isLoginError(), true);

    }
}
