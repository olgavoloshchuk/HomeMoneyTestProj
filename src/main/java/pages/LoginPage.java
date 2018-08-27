package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    MainPage mainPage;
    final String expectedUrl = "/login.aspx";

    @FindBy(id = "ctl00_Main_login")
    private WebElement loginInput;

    @FindBy(id = "ctl00_Main_password")
    private WebElement passwordInput;

    @FindBy(id = "ctl00_Main_LoginButton")
    private WebElement submitButton;

    @FindBy(id = "ctl00_Main_error")
    private WebElement loginErorrMessage;

    public LoginPage(WebDriver webDriver) {

        super(webDriver, "/login.aspx");
        mainPage = new MainPage(webDriver);
    }

    @Step
    public void enterLogin(String login) {
        actionsWithElements.enterTextToElement(loginInput, login);
    }

    @Step
    public void enterPass(String pass) {
        actionsWithElements.enterTextToElement(passwordInput, pass);
    }

    @Step
    public void clickOnSignInButton() {
        actionsWithElements.clickOnElement(submitButton);
    }

    @Step
    public boolean isLoginError() {
        return actionsWithElements.isElementDisplayed(loginErorrMessage);
    }

    @Step
    public boolean isSignInButtonPresent() {
        return actionsWithElements.isElementDisplayed(submitButton);
    }

    /**
     * Method valid login
     *
     * @param login    (ONLY valid login)
     * @param password (ONLY valid password)
     */
    @Step
    public void userValidLogin(String login, String password) {
        openPage(expectedUrl);
        enterLogin(login);
        enterPass(password);
        actionsWithElements.clickOnElement(submitButton);
        mainPage.checkCurrentUrl();
        mainPage.isSignOutRefPresent();


    }

}
