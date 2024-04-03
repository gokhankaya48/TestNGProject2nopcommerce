package US501;

import Elements.DialogContent;
import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistration extends BaseDriver {
    @Test(groups = {"Registration", "Smoke"},priority = 1)
    public void userRegistration() {
        DialogContent dc = new DialogContent();
        myClick(dc.register);
        myClick(dc.male);

        // Entering the first name and last name in the registration form
        mySendKeys(dc.firstName, "Team One", Keys.ENTER);
        mySendKeys(dc.lastName, "technoSdetears", Keys.ENTER);

        // Selecting the day, month, and year of birth in the registration form
        Select dayMenu = new Select(dc.day);
        dayMenu.selectByIndex(5);
        Select monthMenu = new Select(dc.month);
        monthMenu.selectByIndex(5);
        Select yearMenu = new Select(dc.year);
        yearMenu.selectByValue("2005");

        // Entering the email address and company information in the registration form
        mySendKeys(dc.email, "sdetearstechno@gmail.com", Keys.ENTER);
        mySendKeys(dc.company, "Sdetears", Keys.ENTER);

        // Entering the password and confirming the password in the registration form
        mySendKeys(dc.password, "TOtechno1", Keys.ENTER);
        mySendKeys(dc.confirmPassword, "TOtechno1", Keys.ENTER);
        myClick(dc.registerButton);

        // Verifying the completion message after successful registration
        Assert.assertTrue(dc.msgLabel.getText().toLowerCase().contains("completed"));
    }

}
