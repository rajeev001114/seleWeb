package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.WebDriverListener;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.Log;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class BaseClass {

    public static WebDriver driver ;

    EventFiringWebDriver  wd;
    WebDriverListener eventListener;
    public  static String URL = "http://opensource-demo.orangehrmlive.com/";
    public  static String URL1 = "https://the-internet.herokuapp.com/?ref=hackernoon.com";

    @BeforeClass
    public void setupApplication()
    {
        Reporter.log("=====Browser Session Started=====", true);
        Log.info("Start from base clasee-------------");
        /*
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get(URL2);
*/



        Reporter.log("=====Application Started=====", true);
    }

    public  WebDriver getchromeDriver()
    {
        Reporter.log("=====Browser Session Started=====", true);
        Log.info("Start from base clasee-------------");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //options.addArguments("--incognito");
        //System.setProperty("webdriver.chrome.driver", "lib/ChromeStandaloneSetup64.exe");
        //options.setBrowserVersion("116");
        //WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get(URL2);
        return driver;

    }

    public EventFiringWebDriver getEventFiringWebDriver() {
        wd = new EventFiringWebDriver(getchromeDriver());
//create an object of  class WebDriverListener and pass the driver instance
        eventListener = new WebDriverListener();
        wd.register(eventListener);
        return wd;
    }

    public static WebElement findElementByName(String name) {
        Reporter.log(" Clicked th button");
        By locator =  By.name(name);

        // waiting up to 10 seconds until the "foo-button" HTML element is loaded into the DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        // retrieving "web-element" HTML element
        WebElement inputField = driver.findElement(locator);
        return inputField;

    }

    public static WebElement findElementByXPATH(String XPATH) {
        Reporter.log(" Finding in XPATH");
        By locator =  By.xpath(XPATH);
        // waiting up to 10 seconds until the "foo-button" HTML element is loaded into the DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        // retrieving "web-element" HTML element
        WebElement webEle = driver.findElement(locator);
        return webEle;
    }
    public static void clickOnElementByXPATH(String xpath) {
        System.out.println("in buttun click function");

        By locator =  By.xpath(xpath);
        // waiting up to 10 seconds until the "foo-button" HTML element is loaded into the DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        // retrieving "web-element" HTML element
        WebElement button = driver.findElement(locator);
        button.click();

    }

    public static void waitUntillVisibilityOfelement(String xpath) {
        System.out.println("in Wait function");

        By locator =  By.xpath(xpath);
        // waiting up to 10 seconds until the "foo-button" HTML element is loaded into the DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public static void waitUntillPageLoads(int time) {
        System.out.println("in Wait function");

        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);

    }

    public static void clearAndSet(WebElement element, String value) {

        if ((element == null) || (value.isBlank())){
            return;
        }
        element.clear();
        element.sendKeys(value);
        System.out.println("Entered Value:  "+ value);
    }

    public static void selectElementInDropDownByValue(WebElement element, String value) {

        if ((element == null) || (value.isBlank())){
            return;
        }
        // Create object of the Select class
        Select se = new Select(element);

        // Select the option with value "6"
        se.selectByValue(value);
    }

    public static void selectCheckBoxBytext(WebElement element) {

        if ((element == null) ){
            return;
        }
        if (!element.isSelected()) {
            element.click();
        }
    }

    public static void dragAnddrop(WebElement fromElement, WebElement toElement) {


        //Creating object of Actions class to build composite actions
        Actions builder = new Actions(driver);



        Action dragAndDrop = builder.clickAndHold(fromElement)
                .moveToElement(toElement)
                .release(toElement)
                .build();

//Performing the drag and drop action
        dragAndDrop.perform();
    }

    public static void mouseHover(WebElement element) {


        //Creating object of an Actions class
        Actions action = new Actions(driver);

        //Performing the mouse hover action on the target element.
        action.moveToElement(element).perform();
    }

    public static void scrollToSomeValue(int val) {

        waitUntillPageLoads(5);
        //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2250)", "");
        ((JavascriptExecutor) driver).executeScript("scroll(0,250);");
        ((JavascriptExecutor) driver).executeScript("scroll(0,"+val+");");

        /*
        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
        System.out.println("Scroll down perfomed");

         */


    }

    public static void keyPress(WebElement webElement) {

        waitUntillPageLoads(5);
        //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2250)", "");
        //((JavascriptExecutor) driver).executeScript("scroll(0,250);");
        Actions act = new Actions(driver);
        act.moveToElement(webElement).click()
                .sendKeys(Keys.SHIFT).sendKeys("abcf").contextClick().build().perform();
        System.out.println("Scroll down perfomed");


    }

    public static void selectRadioButtonbyValue(String value) {
        String xpath = "//input[@value='" + value + "']";
        //String xpath = "//input[contains(text(), '" + value + "')]";
        //String xpath = "//input[@value='Male']";
        findElementByXPATH(xpath).click();


    }

    @AfterClass
    public void closeApplication() {
        if (driver != null) {
            driver.quit();
            Reporter.log("=====Browser Session End=====", true);
        }
        if (wd != null) {
            wd.unregister(eventListener);
            wd.quit();
        }
    }

}

