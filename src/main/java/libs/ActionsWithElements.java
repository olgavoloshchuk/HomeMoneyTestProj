package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait5;
    WebDriverWait webDriverWait10;
    WebDriverWait webDriverWait20;

    public ActionsWithElements(WebDriver webDriver) {

        this.webDriver = webDriver;
        webDriverWait5 = new WebDriverWait(webDriver, 5);
        webDriverWait10 = new WebDriverWait(webDriver, 10);
        webDriverWait20 = new WebDriverWait(webDriver, 20);
    }

    public void enterTextToElement (WebElement webElement, String text) {
        try {

            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was entered to element");
        } catch (Exception e) {
            printErrorAndStopTest(e);

        }
    }

    public void clickOnElement (WebElement webElement) {
        try {
            webDriverWait5.until(ExpectedConditions.elementToBeClickable(webElement));
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

    public boolean isElementDisplayed (String xPathLocator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xPathLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //check if element exists
    public boolean isElementInList(String xPathLocator) {
        try {
            List<WebElement> webElementList = webDriver.findElements(By.xpath(xPathLocator));
            if (webElementList.size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    //check if element exists and only one
    public boolean isElementInListOnlyOne(String xPathLocator) {
        try {
            List<WebElement> webElementList = webDriver.findElements(By.xpath(xPathLocator));
            if (webElementList.size() == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element");
        Assert.fail("Cannot work with element");
    }

    /**
     * Method set CheckBox State
     *
     * @param checkBox
     * @param checkBoxState - "check" or "uncheck"
     */
    public void setCheckBoxState(WebElement checkBox, String checkBoxState) {
        try {
            if (checkBoxState == "check") {
                if (checkBox.isSelected() != true) {
                    clickOnElement(checkBox);
                }
            } else if (checkBoxState == "uncheck") {
                if (checkBox.isSelected() == true) {
                    clickOnElement(checkBox);
                }
            }
            else
            {
                logger.error("CheckBox state can be only check or uncheck, cannot set CheckBox state");
                Assert.fail("CheckBox state can be only check or uncheck, cannot set CheckBox state");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
}
