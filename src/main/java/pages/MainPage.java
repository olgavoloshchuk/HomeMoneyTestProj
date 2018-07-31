package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends ParentPage {
    public MainPage(WebDriver webDriver) {
        super(webDriver, "/app/");
    }

    public boolean isSignOutRefPresent (){
        try {
            return webDriver.findElement(By.id("ctl00_ctl00_Top_LV2_LoginStatus2"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
 public boolean isControlPanelOpened (){
     try {
         return webDriver.findElement(By.xpath(".//ul//li//a[@href='/app/']"))
                 .isDisplayed();
     } catch (Exception e) {
         return false;
     }
 }

public void signOut(){
        try {
            WebElement webElement = webDriver.findElement(By.id("ctl00_ctl00_Top_LV2_LoginStatus2"));
            webElement.click();
            logger.info("Sign-In was initialized");
        } catch (Exception e ){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }

}
}
