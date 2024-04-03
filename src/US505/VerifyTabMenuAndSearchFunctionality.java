package US505;

import Elements.DialogContent;
import Elements.TabMenu;
import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyTabMenuAndSearchFunctionality extends BaseDriver {
    @Test(groups = {"UITesting", "Search", "TAB", "Menu", "Regression"},priority = 5)
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
}
