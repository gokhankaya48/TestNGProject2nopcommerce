package US507;

import Elements.DialogContent;
import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BuildYourOwnComputerFunctionality extends BaseDriver {
    @Test(groups = {"UITesting","TAB","Menu, Order"},priority = 7)
    public void BuildYourOwnComputerFunctionality() {
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
}
