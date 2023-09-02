package testFiles;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import pages.BaseClass;

        import java.util.concurrent.TimeUnit;

public class DropDown extends BaseClass {

    @BeforeClass
    public void setup() {
        // to do data setup

    }

    @Test
    public void selectDropDown() throws InterruptedException {


        clickOnElementByXPATH("//a[text()='Dropdown']");

        waitUntillPageLoads(5);
        WebElement drop = findElementByXPATH("//select[@id='dropdown']");

        selectElementInDropDownByValue(drop,"2");
        Thread.sleep(30000);
        driver.navigate().back();

    }
}
