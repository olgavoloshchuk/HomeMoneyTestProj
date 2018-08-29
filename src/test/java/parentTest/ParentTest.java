package parentTest;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    protected TargetPage targetPage;

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
        targetPage = new TargetPage(webDriver);

    }

    @After
    public void tearDown(){
       // webDriver.quit();
    }

    @Step
    protected void checkAC(String message, boolean actual, boolean expected){
        if (actual != expected) {
            logger.error("AC failed: " +message);
        }
        Assert.assertEquals(message,expected,actual);
    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        String fileName;

        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }

        @Attachment(value = "Page screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot) {
            return screenShot;
        }

        public void screenshot() {
            if (webDriver == null) {
                logger.info("Driver for screenshot not found");
                return;
            }

            saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));

        }
        @Override
        protected void finished(Description description) {
            logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
            try {
                webDriver.quit();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    };

}
