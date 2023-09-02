
package testFiles;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import pages.BaseClass;

        import java.util.concurrent.TimeUnit;

public class keyPress extends BaseClass {

    @BeforeClass
    public void setup() {
        // to do data setup

    }

    @Test
    public void keyPress1() throws InterruptedException {

        clickOnElementByXPATH("//a[text()='Key Presses']");

        WebElement ele = findElementByXPATH("//input[@id='target']");
        keyPress(ele);
        //clickOnElementByXPATH("//a[text()='View profile']");
        Thread.sleep(30000);
        driver.navigate().back();

    }
}
