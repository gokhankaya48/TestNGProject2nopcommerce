package US508;

import Elements.DialogContent;
import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchBoxFunctionality extends BaseDriver {
    @Test(groups = {"UITesting","Search","Smoke","Regression"},priority = 8)
    public void SearchBoxFunctionality() {
        DialogContent dc = new DialogContent();
        SuccessfulLogin();
        mySendKeys(dc.searchBox, "Adobe Photoshop CS4", Keys.ENTER);
        myClick(dc.searchButton);
        Assert.assertTrue(dc.adobePruduct.isDisplayed(), "Adobe Photoshop Cs4 pruduct not found.");

    }
}
