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
        if (categoriesPage.isCategoryExist(categoryExpName)) categoriesPage.deleteCategory(categoryExpName);
        categoriesPage.addCategory(categoryExpName);
        checkAC("Category was not added", categoriesPage.isCategoryExist(categoryExpName), true);
        categoriesPage.addSubCategory(categoryExpName, subCategoryExpName);
        checkAC("sub category was not added", categoriesPage.isSubCategoryExist(categoryExpName, subCategoryExpName), true);
        categoriesPage.deleteCategory(categoryExpName);
        checkAC("Error message deleting is not seen", categoriesPage.isDeletingErrorMsgSeen(errorDeletingCategoryMsg), true);
        checkAC("Category with sub was deleted, but not expected", categoriesPage.isCategoryExist(categoryExpName), false);
        categoriesPage.deleteSubCategory(subCategoryExpName);
        checkAC("sub category was not deleted", categoriesPage.isSubCategoryExist(categoryExpName, subCategoryExpName), false);
        categoriesPage.deleteCategory(categoryExpName);
        categoriesPage.openPage("/app/categorymanager.aspx");
        checkAC("category was not deleted", categoriesPage.isCategoryExist(categoryExpName), false);

    }
}
