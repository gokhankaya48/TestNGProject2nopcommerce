package Elements;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TabMenu extends BaseDriver {
    public TabMenu() {
        PageFactory.initElements(BaseDriver.driver, this);
    }
    @FindBy(xpath = "//*[text()='Computers ']")
    public List<WebElement> computerMenu;
    @FindBy(xpath = "//*[contains(@class,'sublist')]")
    public List<WebElement> allitems;
    @FindBy(xpath = "//div[@class='header-menu']")
    public List<WebElement> tabMenu;



}
