
package testFiles;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Ignore;
        import org.testng.annotations.Test;
        import pages.BaseClass;

        import java.util.Iterator;
        import java.util.Set;
        import java.util.concurrent.TimeUnit;

public class radioButton extends BaseClass {
    public  static String URL2 = "https://nxtgenaiacademy.com/demo-site/";

    @BeforeClass
    public void setup() {
        // to do data setup
        driver = getEventFiringWebDriver();
        driver.get(URL2);

    }



    @Test
    public void selectRadioButtonbyValue() throws InterruptedException {

        selectRadioButtonbyValue("Male");
        waitUntillPageLoads(10);
        selectRadioButtonbyValue("Female1");
        scrollToSomeValue(50);
        Thread.sleep(30000);
        driver.navigate().back();
    }
}


