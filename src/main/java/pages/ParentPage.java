package pages;

import io.qameta.allure.Step;
import libs.ActionsWithAllerts;
import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    String expectedUrl;
    final String baseUrl = "https://homemoney.ua";
    ActionsWithElements actionsWithElements;
    ActionsWithAllerts actionsWithAllerts;

    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        this.expectedUrl = baseUrl + expectedUrl;
        PageFactory.initElements(webDriver,this); //initialize of all elements in findby
        actionsWithElements = new ActionsWithElements(webDriver);
        actionsWithAllerts = new ActionsWithAllerts(webDriver);
    }

    @Step
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    @Step
    public void checkCurrentUrl() {
        try {
            Assert.assertEquals("Url is not expected", expectedUrl, getCurrentUrl());
        } catch (Exception e) {
            logger.error("Cannot work with Url");
            Assert.fail("Cannot work with Url");
        }
    }

    @Step
    public void openPage (String expectedUrl) {
        try {
            webDriver.get(baseUrl+expectedUrl);
            checkCurrentUrl();
            logger.info("Page " + baseUrl+ expectedUrl+" was opened");
        } catch (Exception e) {
            logger.error("Cannot open page "+ baseUrl+expectedUrl);
            Assert.fail("Cannot open page "+ baseUrl+expectedUrl);

        }

    }
}
