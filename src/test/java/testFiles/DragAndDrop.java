

package testFiles;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import pages.BaseClass;

        import java.util.concurrent.TimeUnit;

public class DragAndDrop extends BaseClass {

    @BeforeClass
    public void setup() {
        // to do data setup

    }

    @Test
    public void dragAndDrop() throws InterruptedException {

        clickOnElementByXPATH("//a[text()='Drag and Drop']");
        //WebElement on which drag and drop operation needs to be performed
        WebElement fromElement = findElementByXPATH("//div[@id='column-a']");
        //WebElement to which the above object is dropped
        WebElement toElement = findElementByXPATH("//div[@id='column-b']");
        dragAnddrop(fromElement, toElement);
        Thread.sleep(30000);
        driver.navigate().back();

    }
}
