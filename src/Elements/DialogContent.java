package Elements;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends BaseDriver {
    public DialogContent() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//a[@class='ico-register']")
    public WebElement register;
    @FindBy(id = "gender-male")
    public WebElement male;
    @FindBy(id = "FirstName")
    public WebElement firstName;
    @FindBy(id = "LastName")
    public WebElement lastName;
    @FindBy(name = "DateOfBirthDay")
    public WebElement day;
    @FindBy(name = "DateOfBirthMonth")
    public WebElement month;
    @FindBy(name = "DateOfBirthYear")
    public WebElement year;
    @FindBy(id = "Email")
    public WebElement email;
    @FindBy(id = "Company")
    public WebElement company;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;
    @FindBy(id = "register-button")
    public WebElement registerButton;
    @FindBy(xpath = "//div[text()='Your registration completed']")
    public WebElement msgLabel;
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement login;
    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement loginButton;
    @FindBy(xpath = "//a[text()='My account']")
    public WebElement myAccount;
    @FindBy(xpath = "//div[text()='Login was unsuccessful. Please correct the errors and try again.']")
    public WebElement msgUnsuccessful;
    @FindBy(xpath = "//*[text()='Log out']")
    public WebElement logOut;

    @FindBy(xpath = "//*[text()='Computers ']")
    public WebElement computers;
    @FindBy(xpath = "(//a[@href='/desktops'])[1]")
    public WebElement desktops;
    @FindBy(xpath = "//h1[text()='Desktops']")
    public WebElement desktopsText;
    @FindBy(xpath = "(//a[@href='/notebooks'])[1]")
    public WebElement notebooks;
    @FindBy(xpath = "//h1[text()='Notebooks']")
    public WebElement notebooksText;
    @FindBy(xpath = "(//a[@href='/software'])[1]")
    public WebElement software;
    @FindBy(xpath = "//h1[text()='Software']")
    public WebElement softwareText;
    @FindBy(xpath = "//*[text()='Electronics ']")
    public WebElement electronics;
    @FindBy(xpath = "//*[text()='Apparel ']")
    public WebElement apparel;
    @FindBy(xpath = "//h1[text()='Computers']")
    public WebElement computersText;
    @FindBy(xpath = "//input[@placeholder='Search store']")
    public WebElement searchBox;
    @FindBy(xpath = "(//button[text()='Search'])[1]")
    public WebElement searchButton;
    @FindBy(xpath = "//div[@class='product-item']")
    public WebElement randomProduct;
    @FindBy(xpath = "(//a[text()='Gift Cards '])[1]")
    public WebElement giftCards;
    @FindBy(xpath = "//div[@class='item-box']")
    public List<WebElement> randomGifts;
    @FindBy(xpath = "//button[contains(@class,'cart-button')]")
    public List<WebElement> randomAddButton;
    @FindBy(xpath = "(//button[text()='Add to cart'])[1]")
    public WebElement addToCart;
    @FindBy(xpath = "//*[text()='Enter valid recipient name']")
    public WebElement enterValid;
    @FindBy(xpath = "//input[@class='recipient-name']")
    public WebElement recipientName;
    @FindBy(xpath = "//input[@class='recipient-email']")
    public WebElement recipientEmail;
    @FindBy(xpath = "//input[@class='sender-name']")
    public WebElement senderName;
    @FindBy(xpath = "//input[@class='sender-email']")
    public WebElement senderEmail;
    @FindBy(xpath = "//*[@class='message']")
    public WebElement yourMessage;
    @FindBy(xpath = "//button[text()='Add to cart']")
    public WebElement giftAddToCart;
    @FindBy(xpath = "//*[text()='The product has been added to your ']")
    public WebElement pruductAdded;
    @FindBy(xpath = "//span[text()='Shopping cart']")
    public WebElement shoppingCart;
    @FindBy(xpath = "//span[@class='close']")
    public WebElement close;
    @FindBy(xpath = "//span[text()='VG_CR_025']")
    public WebElement isDisablePruduct;
    @FindBy(xpath = "//h1[contains(@text,'')]")
    public WebElement disPlayed;
    @FindBy(css = "[class='product-item'][data-productid='1']")
    public WebElement buildYourOwn;
    @FindBy(id = "product_attribute_2")
    public WebElement ramRandom;
    @FindBy(xpath="//input[@name='product_attribute_3']")
    public List<WebElement> hddRandom;
    @FindBy(xpath = "//input[@name='product_attribute_4']")
    public List<WebElement> osVista;
    @FindBy(xpath = "//input[@name='product_attribute_5']")
    public List<WebElement> softwareOption;
    @FindBy(xpath = "//span[text()='COMP_CUST']")
    public WebElement compCost;
    @FindBy(xpath = "//a[text()='Adobe Photoshop CS4']")
    public WebElement adobePruduct;






}
