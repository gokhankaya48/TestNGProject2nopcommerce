package US502;

import Elements.DialogContent;
import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulLogin extends BaseDriver {
    @Test(groups = {"LoginTest", "Smoke"},priority = 2)
    public void SuccessfulLogin() {
        DialogContent dc = new DialogContent();
        myClick(dc.login);
        mySendKeys(dc.email, "sdetearstechno@gmail.com", Keys.ENTER);
        mySendKeys(dc.password, "TOtechno1", Keys.ENTER);
        myClick(dc.loginButton);

        // Verifying if the logout link is displayed after successful login
        Assert.assertTrue(dc.logOut.isDisplayed(), "Log Out link is not displayed.");
    }
}
