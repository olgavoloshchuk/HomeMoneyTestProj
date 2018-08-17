package pages;

import libs.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends ParentPage {

    @FindBy(xpath = ".//input[@name='catName']")
    private WebElement categoryNameInput;

    @FindBy(xpath = ".//*[@class='categoryManager-main-body-func-save-div']//a")
    private WebElement categorySaveButton;

    @FindBy(xpath = ".//a[text()='Remove']")
    private WebElement categoryRemoveButton;

    @FindBy(xpath = ".//a[text()='Test exp 1]")
    private WebElement categoryName;

    public CategoriesPage(WebDriver webDriver) {
        super(webDriver, "/app/categorymanager.aspx");
    }

    public void addCategory(String categoryExpName) {
      //  actionsWithElements.clickOnElement(categoryNameInput);
        actionsWithElements.enterTextToElement(categoryNameInput, categoryExpName);
  //      Utils.waitABit(5);
        actionsWithElements.clickOnElement(categorySaveButton);
    }


    public boolean isCategoryExist(String categoryExpName) {
        return actionsWithElements.isElementInListOnlyOne(
                ".//a[text()='"+categoryExpName+"']"
        );
    }

    public void deleteCategory(String categoryExpName) {
        actionsWithElements.clickOnElement(".//a[text()='"+categoryExpName+"']");
        actionsWithAllerts.allertAccept();
        actionsWithElements.clickOnElement(categoryRemoveButton);
        actionsWithAllerts.allertAccept();
    }
}
