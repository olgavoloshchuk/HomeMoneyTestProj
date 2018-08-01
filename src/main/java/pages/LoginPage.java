package pages;

import libs.ActionsWithElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    MainPage mainPage;

    @FindBy(id = "ctl00_Main_login")
    private WebElement loginInput;

    @FindBy(id = "ctl00_Main_password")
    private WebElement passwordInput;

    @FindBy(id ="ctl00_Main_LoginButton" )
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login.aspx");
    }

    ;

    public void enterLogin(String login) {
        actionsWithElements.enterTextToElement(loginInput, login);
    }

    public void enterPass(String pass) {
        actionsWithElements.enterTextToElement(passwordInput, pass);
    }

    public void clickOnSignInButton() {
        actionsWithElements.clickOnElement(submitButton);
    }

    public boolean isLoginError() {
        try {
            return webDriver.findElement(By.id("ctl00_Main_error")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSignInButtonPresent() {
        try {
            return webDriver.findElement(By.id("ctl00_Main_LoginButton")).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

}
