package UserStories;

import Elements.DialogContent;
import Elements.TabMenu;
import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserStories extends BaseDriver {

    @Test(groups = {"Registration", "Smoke"})
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

    @Test(groups = {"LoginTest", "Smoke"})
    public void SuccessfulLogin() {
        DialogContent dc = new DialogContent();
        myClick(dc.login);
        mySendKeys(dc.email, "sdetearstechno@gmail.com", Keys.ENTER);
        mySendKeys(dc.password, "TOtechno1", Keys.ENTER);
        myClick(dc.loginButton);

        // Verifying if the logout link is displayed after successful login
        Assert.assertTrue(dc.logOut.isDisplayed(), "Log Out link is not displayed.");
    }

    @Test(groups = {"LoginTest", "Smoke"}, dataProvider = "invalidEmailPassword")
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

    @Test(groups = {"UITesting, TAB", "Menu"})
    public void VerifyMenuItemsAndSubmenu() {
        DialogContent dc = new DialogContent();
        TabMenu tm = new TabMenu();
        SuccessfulLogin();
        myClick(dc.computers);
        //Verifying if the "Computers menu is displayed
        Assert.assertTrue(dc.computersText.isDisplayed(), "Computers menu is not displayed.");
        // Verifying if the "Computers" menu is clickable
        Assert.assertTrue(dc.computers.isDisplayed(), "Menu is not clickable.");
        myClick(dc.computers);
        // Checking if the "Computer" menu is not empty
        Assert.assertTrue(!tm.computerMenu.isEmpty(), "Computers menu is empty.");
        // Hovering over the "Computers" link
        hoverOver(dc.computers);
        // Clicking on the "Desktops" link using JavaScript
        JSClick(dc.desktops);
        // Verifying if the "Desktops" text is displayed
        Assert.assertTrue(dc.desktopsText.isDisplayed(), "Desktops menu is not displayed.");
        hoverOver(dc.computers);
        JSClick(dc.notebooks);
        // Verifying if the "Notebooks" text is displayed
        Assert.assertTrue(dc.notebooksText.isDisplayed(), "Notebooks menu is not displayed.");
        hoverOver(dc.computers);
        JSClick(dc.software);
        // Verifying if the "Software" text is displayed
        Assert.assertTrue(dc.softwareText.isDisplayed(), "Notebooks menu is not displayed.");
    }

    @Test(groups = {"UITesting", "Search", "TAB", "Menu", "Regression"})
    public void VerifyTabMenuAndSearchFunctionality() {
        DialogContent dc = new DialogContent();
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
        hoverOver(dc.computers);
        // Gathering the elements of the computers menu and validating each one
        List<List<String>> submenuListcomp = new ArrayList<>(Arrays.asList());
        for (WebElement elementcomp : tabMenuElements) {
            // Finding the sub-menu elements under the "Computers" tab
            List<WebElement> subMenuElementscomp = elementcomp.findElements(By.xpath("//*[contains(@class,'sublist')]"));
            List<String> subMenuNamescomp = new ArrayList<>();
            for (WebElement subElementcomp : subMenuElementscomp) {
                subMenuNamescomp.add(subElementcomp.getText());
                // Verifying that each sub-menu element is not empty by checking its size
                Assert.assertNotEquals(0, subElementcomp.getSize(), "Computers menu element size is zero");

            }
            // Adding the list of sub-menu items under the "Computers" tab to the main sub-menu list
            submenuListcomp.add(subMenuNamescomp);
        }
        hoverOver(dc.electronics);
        // Gathering the elements of the electronics menu and validating each one
        List<List<String>> submenuListelec = new ArrayList<>(Arrays.asList());
        for (WebElement elementelec : tabMenuElements) {
            List<WebElement> subMenuElementselec = elementelec.findElements(By.xpath("//*[contains(@class,'sublist')]"));
            List<String> subMenuNameselec = new ArrayList<>();
            for (WebElement subElementelec : subMenuElementselec) {
                subMenuNameselec.add(subElementelec.getText());
                // Verifying that each sub-menu element is not empty by checking its size
                Assert.assertNotEquals(0, subElementelec.getSize(), "Electronics menu element size is zero");
            }
            // Adding the list of sub-menu items under the "electronics" tab to the main sub-menu list
            submenuListelec.add(subMenuNameselec);
        }
        hoverOver(dc.apparel);
        // Gathering the elements of the apparel menu and validating each one
        List<List<String>> submenuListapp = new ArrayList<>(Arrays.asList());
        for (WebElement elementapp : tabMenuElements) {
            List<WebElement> subMenuElementsapp = elementapp.findElements(By.xpath("//*[contains(@class,'sublist')]"));
            List<String> subMenuNamesapp = new ArrayList<>();
            for (WebElement subElementapp : subMenuElementsapp) {
                subMenuNamesapp.add(subElementapp.getText());
                Assert.assertNotEquals(0, subElementapp.getSize(), "Apparel menu element size is zero");
            }
            // Adding the list of sub-menu items under the "apparel" tab to the main sub-menu list
            submenuListapp.add(subMenuNamesapp);
        }
        //Searching random product
        mySendKeys(dc.searchBox, "notebooks", Keys.ENTER);
        myClick(dc.searchButton);
        Tools.Bekle(5);
        scrollToElement(dc.randomProduct);
        // Verifying that a random product is displayed after performing the search
        Assert.assertTrue(dc.randomProduct.isDisplayed(), "Random product is not found.");


    }

    @Test(groups = {"UITesting", "TAB", "Menu", "Order"})
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


    @Test
    public void US507() {
        DialogContent dc = new DialogContent();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        SuccessfulLogin();
        hoverOver(dc.computers);
        JSClick(dc.desktops);
        JSClick(dc.buildYourOwn);
        js.executeScript("window.scrollTo(0,750)");
        Tools.Bekle(3);
        JSClick(dc.addToCart);

        Select ramSelect = new Select(dc.ramRandom);
        List<WebElement> ram = ramSelect.getOptions();
        int randomIndex = Tools.randomGenerator(ram.size());
        ramSelect.selectByIndex(randomIndex);
        int hddRandom = Tools.randomGenerator(dc.hddRandom.size());
        JSClick(dc.hddRandom.get(hddRandom));
        int osRandom = Tools.randomGenerator(dc.osVista.size());
        JSClick(dc.osVista.get(osRandom));
        int softwareRandom = Tools.randomGenerator(dc.softwareOption.size());
        JSClick(dc.softwareOption.get(softwareRandom));
        scrollToElement(dc.addToCart);
        Tools.Bekle(3);
        JSClick(dc.addToCart);
        myClick(dc.shoppingCart);
        Assert.assertTrue(dc.compCost.isDisplayed(), "Computer Cost is not displayed.");
    }

    @Test
    public void US508() {
        DialogContent dc = new DialogContent();
        SuccessfulLogin();
        mySendKeys(dc.searchBox, "Adobe Photoshop CS4", Keys.ENTER);
        myClick(dc.searchButton);
        Assert.assertTrue(dc.adobePruduct.isDisplayed(), "Adobe Photoshop Cs4 pruduct not found.");

    }

}
