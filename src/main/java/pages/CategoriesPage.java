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

    @FindBy(id="categoryManager-main-body-func-subcatChk")
    private WebElement makeSubcategoryCheckbox;

    @FindBy(xpath=".//a[@class='chzn-single']")
    private WebElement categoryDD;

    public CategoriesPage(WebDriver webDriver) {
        super(webDriver, "/app/categorymanager.aspx");
    }

    public void addCategory(String categoryExpName) {
        actionsWithElements.enterTextToElement(categoryNameInput, categoryExpName);
        actionsWithElements.clickOnElement(categorySaveButton);
    }


    public boolean isCategoryExist(String categoryExpName) {
        return actionsWithElements.isElementInListOnlyOne(
                ".//a[text()='"+categoryExpName+"']"
        );
    }

    public void deleteCategory(String categoryExpName) {
        actionsWithElements.clickOnElement(".//a[text()='"+categoryExpName+"']");
     //   actionsWithAllerts.allertAccept();
        actionsWithElements.clickOnElement(categoryRemoveButton);
        actionsWithAllerts.allertAccept();
    }

    public void addSubCategory(String categoryExpName, String subCategoryExpName) {
        actionsWithElements.enterTextToElement(categoryNameInput, subCategoryExpName);
        actionsWithElements.setCheckBoxState(makeSubcategoryCheckbox, "check");
        Utils.waitABit(5);
        actionsWithElements.clickOnElement(categoryDD);
        actionsWithElements.clickOnElement(".//ul[@class='chzn-results']//li[text()='"+categoryExpName+"']");
      //  actionsWithElements.selectValueInDD(categoryDD, categoryExpName);
        actionsWithElements.clickOnElement(categorySaveButton);
    }

    public boolean isSubCategoryExist(String categoryExpName, String subCategoryExpName) {
        return actionsWithElements.isElementDisplayed(".//a[text()='" +subCategoryExpName+"']//..//..//a[text()='"+categoryExpName+"']");
    }

    public boolean isDeletingErrorMsgSeen(String errorMsg) {
        return actionsWithElements.isElementDisplayed(".//*[text()='"+errorMsg+"']");
    }

    public void deleteSubCategory(String subCategoryExpName) {
        actionsWithElements.clickOnElement(".//a[text()='"+subCategoryExpName+"']");
        actionsWithElements.clickOnElement(categoryRemoveButton);
        actionsWithAllerts.allertAccept();

    }
}
