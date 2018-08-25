package categoryTest;

import libs.Utils;
import org.junit.Test;
import parentTest.ParentTest;

public class AddAndDeleteCategory extends ParentTest {
    final String categoryExpName = "Test exp 1";
    final String subCategoryExpName = "Test sub-exp 1";
    final String errorDeletingCategoryMsg = "Category or subcategory contains transactions. Transfer them to other categories";

    @Test
    public void addAndDeleteExpCategory() {
        loginPage.userValidLogin("olga.voloshchuk@gmail.com", "Mytestpass");
        mainPage.menuAdditionalCatgoriesOpen();
        categoriesPage.checkCurrentUrl();
        if (categoriesPage.isSubCategoryExist(categoryExpName, subCategoryExpName))
            categoriesPage.deleteSubCategory(subCategoryExpName);
        if (categoriesPage.isCategoryExist(categoryExpName)) categoriesPage.deleteCategory(categoryExpName);
        Utils.waitABit(2);
        categoriesPage.addCategory(categoryExpName);
        checkAC("Category was not added", categoriesPage.isCategoryExist(categoryExpName), true);
        categoriesPage.addSubCategory(categoryExpName, subCategoryExpName);
        checkAC("sub category was not added", categoriesPage.isSubCategoryExist(categoryExpName, subCategoryExpName), true);
        categoriesPage.deleteCategory(categoryExpName);
        Utils.waitABit(2);
        checkAC("Error message deleting is not seen", categoriesPage.isDeletingErrorMsgSeen(errorDeletingCategoryMsg), true);
        checkAC("Category with sub was deleted, but not expected", categoriesPage.isCategoryExist(categoryExpName), true);
        categoriesPage.deleteSubCategory(subCategoryExpName);
        Utils.waitABit(2);
        checkAC("sub category was not deleted", categoriesPage.isSubCategoryExist(categoryExpName, subCategoryExpName), false);
        categoriesPage.deleteCategory(categoryExpName);
        Utils.waitABit(2);
        checkAC("category was not deleted", categoriesPage.isCategoryExist(categoryExpName), false);

    }
}
