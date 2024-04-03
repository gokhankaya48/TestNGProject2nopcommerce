package US504;

import Elements.DialogContent;
import Elements.TabMenu;
import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyMenuItemsAndSubmenu extends BaseDriver {
    @Test(groups = {"UITesting, TAB", "Menu"},priority = 4)
    public void VerifyMenuItemsAndSubmenu() {
        DialogContent dc = new DialogContent();
        SuccessfulLogin();
        TabMenu tm = new TabMenu();
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

}
