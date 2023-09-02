package testFiles;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.testng.Reporter;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import pages.BaseClass;

public class DropDown extends BaseClass {
    WebDriver driver;
    public static String URL2 = "https://the-internet.herokuapp.com/?ref=hackernoon.com";

    @BeforeClass
    public void setup() {
        // to do data setup
        driver = getchromeDriver();
        driver.get(URL2);

    }

    @Test
    public void selectDropDown() throws InterruptedException {


        clickOnElementByXPATH("//a[text()='Dropdown']", driver);

        waitUntillPageLoads(5);
        WebElement drop = findElementByXPATH("//select[@id='dropdown']");

        //selectElementInDropDownByValue(drop,"2");
        Thread.sleep(10000);
        driver.navigate().back();

    }

    @AfterClass
    public void closeApplication() {
        if (driver != null) {
            driver.quit();
            Reporter.log("=====Browser Session End=====", true);
        }

    }
}