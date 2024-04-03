package US503;

import Elements.DialogContent;
import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InvalidLoginAttempt extends BaseDriver {
    @Test(groups = {"LoginTest", "Smoke"}, dataProvider = "invalidEmailPassword",priority = 3)
    public void InvalidLoginAttempt(String email, String password) {
        DialogContent dc = new DialogContent();
        myClick(dc.login);
        mySendKeys(dc.email, email, Keys.ENTER);
        mySendKeys(dc.password, password, Keys.ENTER);
        myClick(dc.loginButton);
        // Verifying if the successful message is displayed after valid login attempt
        if (email.equals("sdetearstechno@gmail.com") && password.equals("TOtechno1")) {
            Assert.assertTrue(dc.logOut.isDisplayed(), "Logout button is not displayed.");
        } else {
            // Verifying if the unsuccessful message is displayed after invalid login attempt
            Assert.assertTrue(dc.msgUnsuccessful.getText().toLowerCase().contains("unsuccessful"));
        }
    }
    @DataProvider
    Object[] invalidEmailPassword() {
        // Providing invalid email and password combinations for testing
        Object[][] invalidEmailPassword = {
                {"a@gmail.com", "sfasfa"},
                {"kaan@gmail.com", "4444444"},
                {"aycin123@gmail.com", "6664464"},
                {"fatih@gmail.com", "9994449"},
                {"b@gmail.com", "dd44ddd"},
                {"arafat@gmail.com", "aa444aaa"},
                {"sdetearstechno@gmail.com", "TOtechno1"},
        };
        return invalidEmailPassword;
    }
}
