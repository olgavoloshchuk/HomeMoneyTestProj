package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextToElement (WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was entered to element");
        } catch (Exception e) {
            printErrorAndStopTest(e);

        }
    }

    public void clickOnElement (WebElement webElement) {
        try {
            webElement.click();
            logger.info("Element was clicked");

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed (WebElement webElement){
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Element is displayed -> " + state);
            return  state;

        } catch (Exception e) {
            logger.info("Element is display - > false");
            return false;
        }
    }

    public boolean isElementEnabled (WebElement webElement) {
        try {
            boolean state = webElement.isEnabled();
            logger.info("Element is enabled -> " + state);
            return  state;

        } catch (Exception e) {
            logger.info("Element is enabled - > false");
            return false;
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element");
        Assert.fail("Cannot work with element");
    }
}
