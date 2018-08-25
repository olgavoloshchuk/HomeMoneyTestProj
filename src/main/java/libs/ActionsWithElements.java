package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait5;
    Actions actions;
    ActionsWithAllerts actionsWithAllerts;

    public ActionsWithElements(WebDriver webDriver) {

        this.webDriver = webDriver;
        webDriverWait5 = new WebDriverWait(webDriver, 5);
        actions = new Actions(webDriver);
        actionsWithAllerts = new ActionsWithAllerts(webDriver);
    }

    /**
     * Method for enter text to web element
     *
     * @param webElement
     * @param text
     */
    public void enterTextToElement(WebElement webElement, String text) {
        try {
            webDriverWait5.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was entered to element");
        } catch (Exception e) {
            printErrorAndStopTest(e);

        }
    }

    /**
     * Method for click on web element
     *
     * @param webElement
     */
    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait5.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * Method for click on web element with further accept of alert
     *
     * @param webElement
     */
    public void clickOnElementWithAccepAlert(WebElement webElement) {
        try {
            webDriverWait5.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");
            actionsWithAllerts.allertAccept();
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * Method check if web element displayed
     *
     * @param webElement
     * @return true or false
     */
    public boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Element is displayed -> " + state);
            return state;

        } catch (Exception e) {
            logger.info("Element is display - > false");
            return false;
        }
    }

    /**
     * Method check if web element is enabled
     *
     * @param webElement
     * @return true or false
     */
    public boolean isElementEnabled(WebElement webElement) {
        try {
            boolean state = webElement.isEnabled();
            logger.info("Element is enabled -> " + state);
            return state;

        } catch (Exception e) {
            logger.info("Element is enabled - > false");
            return false;
        }
    }

    /**
     * Method check if web element with given xpath locator is displayed
     *
     * @param xPathLocator
     * @return true or false
     */
    public boolean isElementDisplayed(String xPathLocator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xPathLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method check if web element with given xpath locator exists
     *
     * @param xPathLocator
     * @return true or false
     */
    //
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

    /**
     * Method check is web element with given xpath locator exists only one
     *
     * @param xPathLocator
     * @return true or false
     */
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
            } else {
                logger.error("CheckBox state can be only check or uncheck, cannot set CheckBox state");
                Assert.fail("CheckBox state can be only check or uncheck, cannot set CheckBox state");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * Method click on web element by given xpath locator
     *
     * @param xPathLocator
     */
    public void clickOnElement(String xPathLocator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xPathLocator));
            webDriverWait5.until((ExpectedConditions.elementToBeClickable(webElement)));
            clickOnElement(webElement);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * Method for move cursor to web element by given xpath locator
     *
     * @param xPathLocator
     */
    public void moveToElement(String xPathLocator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xPathLocator));
            actions.moveToElement(webElement).build().perform();
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * Method for move to element by given xpath locator and click
     *
     * @param xPathLocator
     */
    public void moveToElementAndClick(String xPathLocator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xPathLocator));
            webDriverWait5.until(ExpectedConditions.visibilityOf(webElement));
            actions.moveToElement(webElement).click().perform();
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * Method for get text from web element
     *
     * @param webElement
     * @return
     */
    public String getTextFromElement(WebElement webElement) {
        try {
            return webElement.getText();
        } catch (Exception e) {
            printErrorAndStopTest(e);
            return "";
        }
    }
}
