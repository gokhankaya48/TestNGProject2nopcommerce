package US506;

import Elements.DialogContent;
import Elements.TabMenu;
import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class giftShoppingTest extends BaseDriver {
    @Test(groups = {"UITesting", "TAB", "Menu", "Order"},priority = 6)
    public void giftShoppingTest() {
        DialogContent dc = new DialogContent();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        TabMenu tm = new TabMenu();
        SuccessfulLogin();
        // Gathering the elements of the tab menu and validating each one
        List<String> tabMenuList = new ArrayList<>();
        List<WebElement> tabMenuElements = tm.tabMenu;
        for (WebElement element : tabMenuElements) {
            tabMenuList.add(element.getText());
            // Verifying that each menu element is not empty by checking its size
            Assert.assertNotEquals(0, element.getSize(), "Tab menu is empty.");
        }
        myClick(dc.giftCards);
        js.executeScript("window.scrollTo(0,750)", dc.addToCart);
        myClick(dc.addToCart);
        Tools.Bekle(5);
        js.executeScript("window.scrollTo(0,750)", dc.giftAddToCart);
        Tools.Bekle(5);
        myClick(dc.giftAddToCart);
        // Verifying if the validation message for recipient name is displayed
        Assert.assertTrue(dc.enterValid.getText().contains("Enter valid recipient name"), "Recipient name validation message is not displayed.");

        mySendKeys(dc.recipientName, "Sdet", Keys.ENTER);
        mySendKeys(dc.recipientEmail, "techno@gmail.com", Keys.ENTER);
        mySendKeys(dc.senderName, "Sdettears", Keys.ENTER);
        mySendKeys(dc.senderEmail, "sdetearstechno@gmail.com", Keys.ENTER);
        mySendKeys(dc.yourMessage, "Güle güle kullan", Keys.ENTER);
        js.executeScript("window.scrollTo(0,750)", dc.addToCart);
        JSClick(dc.addToCart);
        // Verifying if the product added confirmation message is displayed
        Assert.assertTrue(dc.pruductAdded.getText().contains("The product has been added to your"), "Product added confirmation message is not displayed.");
        myClick(dc.close);
        JSClick(dc.shoppingCart);
        Tools.Bekle(5);
        Assert.assertTrue(dc.isDisablePruduct.getText().contains("VG_CR_025"), "Gift card is not displayed.");

    }
}
