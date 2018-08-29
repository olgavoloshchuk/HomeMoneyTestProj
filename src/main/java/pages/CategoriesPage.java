package pages;

import io.qameta.allure.Step;
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

    @FindBy(id = "categoryManager-main-body-func-subcatChk")
    private WebElement makeSubcategoryCheckbox;

    @FindBy(xpath = ".//a[@class='chzn-single']")
    private WebElement categoryDD;

    public CategoriesPage(WebDriver webDriver) {
        super(webDriver, "/app/categorymanager.aspx");
    }

    @Step
    public void addCategory(String categoryExpName) {
        actionsWithElements.enterTextToElement(categoryNameInput, categoryExpName);
        actionsWithElements.clickOnElement(categorySaveButton);
    }

    @Step
    public boolean isCategoryExist(String categoryExpName) {
        return actionsWithElements.isElementInListOnlyOne(
                ".//a[text()='" + categoryExpName + "']"
        );
    }

    @Step
    public void deleteCategory(String categoryExpName) {
        actionsWithElements.clickOnElement(".//a[text()='" + categoryExpName + "']");
        actionsWithElements.clickOnElement(categoryRemoveButton);
        actionsWithAllerts.allertAccept();
    }

    @Step
    public void addSubCategory(String categoryExpName, String subCategoryExpName) {
        actionsWithElements.enterTextToElement(categoryNameInput, subCategoryExpName);
        actionsWithElements.setCheckBoxState(makeSubcategoryCheckbox, "check");
        Utils.waitABit(5);
        actionsWithElements.clickOnElement(categoryDD);
        actionsWithElements.clickOnElement(".//ul[@class='chzn-results']//li[text()='" + categoryExpName + "']");
        actionsWithElements.clickOnElement(categorySaveButton);
    }

    @Step
    public boolean isSubCategoryExist(String categoryExpName, String subCategoryExpName) {
        return actionsWithElements.isElementDisplayed(".//a[text()='" + subCategoryExpName + "']//..//..//a[text()='" + categoryExpName + "']");
    }

    @Step
    public boolean isDeletingErrorMsgSeen(String errorMsg) {
        return actionsWithElements.isElementDisplayed(".//*[text()='" + errorMsg + "']");
    }

    @Step
    public void deleteSubCategory(String subCategoryExpName) {
        actionsWithElements.clickOnElement(".//a[text()='" + subCategoryExpName + "']");
        actionsWithElements.clickOnElement(categoryRemoveButton);
        actionsWithAllerts.allertAccept();

    }

    public void deleteSubCategoryAndCategory(String subCategoryExpName, String categoryExpName) {
        if (isSubCategoryExist(categoryExpName, subCategoryExpName))
            deleteSubCategory(subCategoryExpName);
        if (isCategoryExist(categoryExpName)) deleteCategory(categoryExpName);
    }
}
