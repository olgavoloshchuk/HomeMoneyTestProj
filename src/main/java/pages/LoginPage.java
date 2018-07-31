package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login.aspx");
    };

    public void enterLogin(String login){
        try {
            WebElement webElement = webDriver.findElement(By.id("ctl00_Main_login"));
            webElement.clear();
            webElement.sendKeys(login);
            logger.info(login + " was input into input login");

        } catch (Exception e){
            logger.error("Cannot enter login");
            Assert.fail("Cannot enter login");
        }

    }

    public void enterPass(String pass){
        try {
            WebElement webElement = webDriver.findElement(By.id("ctl00_Main_password"));
            webElement.clear();
            webElement.sendKeys(pass);
            logger.info(pass + " was input into input password");

        } catch (Exception e){
            logger.error("Cannot enter password");
            Assert.fail("Cannot enter password");
        }

    }

    public void clickOnSignInButton() {
        try {
            WebElement webElement = webDriver.findElement(By.id("ctl00_Main_LoginButton"));
            webElement.click();
            logger.info("Sign In button was clicked");
        } catch (Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }

    public boolean isLoginError(){
        try {
            return webDriver.findElement(By.id("ctl00_Main_error")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isSignInButtonPresent(){
        try {
            return webDriver.findElement(By.id("ctl00_Main_LoginButton")).isEnabled();
        } catch (Exception e){
            return false;
        }
    }

}
