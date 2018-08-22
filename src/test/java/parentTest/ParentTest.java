package parentTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected ParentPage parentPage;
    protected AccountsPage accountsPage;
    protected CategoriesPage categoriesPage;
    protected SettingPage settingPage;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        accountsPage = new AccountsPage(webDriver);
        categoriesPage = new CategoriesPage(webDriver);
        settingPage = new SettingPage(webDriver);
        parentPage = new ParentPage(webDriver, "/");
        Actions actions = new Actions(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    protected void checkAC(String message, boolean actual, boolean expected){
        if (actual != expected) {
            logger.error("AC failed: " +message);
        }
        Assert.assertEquals(message,expected,actual);
    }

}
