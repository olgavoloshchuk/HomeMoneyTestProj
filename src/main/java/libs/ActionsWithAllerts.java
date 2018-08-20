package libs;

import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithAllerts {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait5;

    public ActionsWithAllerts(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait5 = new WebDriverWait(webDriver, 5);
    }

    public void allertAccept() {

        try {
            webDriverWait5.until(ExpectedConditions.alertIsPresent());
            webDriver.switchTo().alert().accept();
        } catch (Exception e){
            logger.info("Alert isn't present");
        }

    }

    public void allertDismiss() {

        try {
            webDriverWait5.until(ExpectedConditions.alertIsPresent());
            webDriver.switchTo().alert().dismiss();
        } catch (Exception e) {
            logger.info("Alert isn't present");
        }
    }
}
