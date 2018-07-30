package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
