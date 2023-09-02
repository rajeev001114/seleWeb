
package testFiles;

        import listeners.WebDriverListener;
        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.events.EventFiringWebDriver;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Ignore;
        import org.testng.annotations.Test;
        import pages.BaseClass;
        import utility.Log;

        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.Set;
        import java.util.concurrent.TimeUnit;

public class alertsAndPopup extends BaseClass {
    public  static String URL2 = "https://nxtgenaiacademy.com/alertandpopup/";
    public  static String URL3 = "https://www.google.com/";

    @BeforeClass
    public void setup() {
        // to do data setup


        driver = getEventFiringWebDriver();

        driver.get(URL3);

    }



    @Test
    public void simpleAlert() throws InterruptedException {
        String xpath = "//button[@name='alertbox']";
        findElementByXPATH(xpath).click();
        waitUntillPageLoads(10);
        // Switching to Alert
        Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        Thread.sleep(5000);

        // Accepting alert
        alert.accept();
        Thread.sleep(30000);
        driver.navigate().back();
    }

    @Test
    public void popUp() throws InterruptedException {
        Log.startTestCase("popUp");
        String xpath = "//button[@aria-label='Stay signed out']";
        //<button aria-label="Stay signed out" class="M6CB1c rr4y5c" jsname="ZUkOIc" jslog="71121; track:click;" data-dismiss="n">Stay signed out</button>
        waitUntillPageLoads(15);
        //findElementByXPATH(xpath).click();
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("no. of frame is :" + size);

        //driver.switchTo().frame(0);
        driver.switchTo().frame("callout");
        waitUntillPageLoads(15);
        WebElement element = findElementByXPATH(xpath);
        element.click();
        driver.switchTo().defaultContent();

        /*

<iframe role="presentation" frameborder="0" scrolling="no"
name="callout" src="https://ogs.google.com/widget/callout?prid=19037050&amp;pgid=19037049&amp;puid=3c3dcea9c33016af&amp;cce=1&amp;dc=1&amp;origin=https%3A%2F%2Fwww.google.com&amp;cn=callout&amp;pid=1&amp;spid=538&amp;hl=en"
style="height: 100%; width: 100%; color-scheme: light;"></iframe>

*/

        ArrayList<WebElement> al = new ArrayList<>(driver.findElements(By.tagName("a")));
        System.out.println("List :" + al.size());
        for (WebElement wb : al) {
            System.out.println("Element :" + wb.getText());
            System.out.println("Element :" + wb.getAttribute("href"));
        }
        waitUntillPageLoads(10);
        findElementByXPATH("//*[@class='gb_i']").click();
        driver.switchTo().frame("app");
        waitUntillVisibilityOfelement("//a[@href='https://www.youtube.com']");
        waitUntillPageLoads(5);
        findElementByXPATH("//a[@href='https://www.youtube.com']").click();
        driver.switchTo().defaultContent();
        //Thread.sleep(30000);
        //driver.navigate().back();
        driver.close();
        Log.endTestCase("popUp");
    }
}



