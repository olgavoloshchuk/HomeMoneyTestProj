package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait5;
    WebDriverWait webDriverWait10;
    WebDriverWait webDriverWait20;
    Actions actions;
    ActionsWithAllerts actionsWithAllerts;

    public ActionsWithElements(WebDriver webDriver) {

        this.webDriver = webDriver;
        webDriverWait5 = new WebDriverWait(webDriver, 5);
        webDriverWait10 = new WebDriverWait(webDriver, 10);
        webDriverWait20 = new WebDriverWait(webDriver, 20);
        Actions actions = new Actions(webDriver);
        actionsWithAllerts = new ActionsWithAllerts(webDriver);
    }

    public void enterTextToElement(WebElement webElement, String text) {
        try {

            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was entered to element");
        } catch (Exception e) {
            printErrorAndStopTest(e);

        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElementWithAccepAlert(WebElement webElement) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");
            actionsWithAllerts.allertAccept();
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

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

    public boolean isElementDisplayed(String xPathLocator) {
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

    public void clickOnEveryElementInListWithAcceptAlert(String xPathLocator) {
        try {
            List<WebElement> webElementList = webDriver.findElements(By.xpath(xPathLocator));
            for (WebElement element:webElementList) {
                clickOnElementWithAccepAlert(element);
Utils.waitABit(3);
            }
        } catch (Exception e)
        {
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element");
        Assert.fail("Cannot work with element");
    }

    public void selectValueInDD(WebElement dropDownList, String value) {
        try {
            Select select = new Select(dropDownList);
            select.selectByValue(value);
            logger.info(value + " was selected in DD");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }

    public void clickElementInDD(WebElement dropDownList, WebElement dropDownElement) {
        clickOnElement(dropDownList);
        clickOnElement(dropDownElement);
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

    public void clickOnElement(String xPathLocator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xPathLocator));
            clickOnElement(webElement);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void moveToElement(WebElement webElement) {
        try {
            webDriverWait5.until(ExpectedConditions.elementToBeClickable(webElement));
            actions.moveToElement(webElement).build().perform();
            Utils.waitABit(3);
            actions.moveToElement(webElement).click().perform();
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void moveToElement(String xPathLocator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xPathLocator));
            moveToElement(webElement);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    public String getTextFromElement(WebElement webElement) {
        try {
            return webElement.getText();
        } catch (Exception e) {
            printErrorAndStopTest(e);
            return "";
        }
    }
}
