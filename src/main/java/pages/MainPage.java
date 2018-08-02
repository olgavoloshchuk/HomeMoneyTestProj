package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage {

    @FindBy (id = "ctl00_ctl00_Top_LV2_LoginStatus2")
    private WebElement signOutRef;

    @FindBy (xpath = ".//ul//li//a[@href='/app/']")
    private WebElement controlPanel;


    public MainPage(WebDriver webDriver) {
        super(webDriver, "/app/");
    }

    public boolean isSignOutRefPresent() { return actionsWithElements.isElementDisplayed(signOutRef);    }

    public boolean isControlPanelOpened() { return  actionsWithElements.isElementDisplayed(controlPanel);    }

    public void signOut() {  actionsWithElements.clickOnElement(signOutRef);    }
}
