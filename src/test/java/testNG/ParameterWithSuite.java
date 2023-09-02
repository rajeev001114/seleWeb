package testNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.BaseClass;
import utility.Log;

import java.util.ArrayList;

public class ParameterWithSuite extends BaseClass {


    public  static String URL2 = "https://nxtgenaiacademy.com/alertandpopup/";
    public  static String URL3 = "https://www.google.com/";


    @BeforeClass
    public void setup() {
        // to do data setup
        driver = getEventFiringWebDriver();
        driver.get(URL3);

    }


    @Test
    @Parameters({"author","searchKey"})
    public void popUp(@Optional("Now fine") String author, String searchKey) throws InterruptedException {
        Log.startTestCase("popUp");
        Log.info("Authour : " + author);
        String xpath = "//button[@aria-label='Stay signed out']";
        //<button aria-label="Stay signed out" class="M6CB1c rr4y5c" jsname="ZUkOIc" jslog="71121; track:click;" data-dismiss="n">Stay signed out</button>
        //waitUntillPageLoads(15);
        //findElementByXPATH(xpath).click();
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("no. of frame is :" + size);
        WebElement searchText = driver.findElement(By.name("q"));
        //Searching text in google text box
        searchText.sendKeys(searchKey);
        Log.info("Search key value : " + searchKey);
        Thread.sleep(15000);
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
