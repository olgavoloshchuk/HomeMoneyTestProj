package targetTest;

import libs.Utils;
import org.junit.Test;
import parentTest.ParentTest;

import static libs.Utils.getDateAndTimeFormated;

public class AddNewTarget extends ParentTest {
    final String targetName = "Target";
    final String targetSum = "1000000";


    @Test
    public void addNewTarget(){
        String dateTime = getDateAndTimeFormated();
        String unicTargetNAme = targetName+dateTime;
        loginPage.userValidLogin("olga.voloshchuk@gmail.com", "Mytestpass");
        mainPage.clickAddGoalButton();
        targetPage.checkCurrentUrl();
        if (targetPage.isAddGoalButtonExists()) {
            targetPage.clickAddGoalButton();
        };
        targetPage.enterTargetName(unicTargetNAme);
        targetPage.enterTargetSum(targetSum);
        targetPage.uncheckReflectOnControlPanel();
        targetPage.pressSaveButton();
        checkAC("Goal was not added", targetPage.isGoalExists(unicTargetNAme), true);
        Utils.waitABit(3);
      //  targetPage.moveCursorToTarget(unicTargetNAme);
      //  Utils.waitABit(3);
        targetPage.clickDeleteTargetButton(unicTargetNAme);
        checkAC("Goal was not deleted", targetPage.isGoalExists(unicTargetNAme), false);
    }

}
