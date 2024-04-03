package Utility;

import Elements.DialogContent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;
    static Logger logger = LogManager.getLogger();

    @BeforeClass(alwaysRun = true)

    public void BaslangicIslemleri() {


        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test(groups = {"LoginTest", "Smoke"},alwaysRun = true)
    public void SuccessfulLogin() {
        DialogContent dc = new DialogContent();
        myClick(dc.login);
        mySendKeys(dc.email, "sdetearstechno@gmail.com", Keys.ENTER);
        mySendKeys(dc.password, "TOtechno1", Keys.ENTER);
        myClick(dc.loginButton);

        // Verifying if the logout link is displayed after successful login
        Assert.assertTrue(dc.logOut.isDisplayed(), "Log Out link is not displayed.");
    }
    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.click();
    }
    public void mySendKeys(WebElement element, String text, Keys enter) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public static void JSClick(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) BaseDriver.driver;
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].click();", element);
    }
    public static boolean ListContainsString(List<WebElement> list, String aranacak){
        boolean bulundu=false;
        for (WebElement e: list)
        {
            if (e.getText().toLowerCase().equals(aranacak.toLowerCase()))
                bulundu=true;
        }
        return bulundu;
    }
    public void hoverOver(WebElement element){
        Actions aksiyonDriver=new Actions(BaseDriver.driver);
        wait.until(ExpectedConditions.visibilityOf(element));
        Action aksiyon=aksiyonDriver.moveToElement(element).build();
        aksiyon.perform();
    }
    @AfterClass(alwaysRun = true)
    public static void quitDriver() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("Driver closed.");
        }
    }
}
