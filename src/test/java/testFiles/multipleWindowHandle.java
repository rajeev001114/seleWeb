
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

public class multipleWindowHandle extends BaseClass {
    public  static String URL2 = "https://nxtgenaiacademy.com/multiplewindows/";

    @BeforeClass
    public void setup() {
        // to do data setup
        driver = getEventFiringWebDriver();
        driver.get(URL2);

    }

    @Ignore
    public void multipleWindows() throws InterruptedException {
        driver.findElement(By.xpath("//button[@name='newbrowserwindow123']")).click();
        waitUntillPageLoads(15);
        driver.findElement(By.xpath("//button[@name='newbrowserwindow123']")).click();

        String MainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                String childPageTitle = driver.getTitle();
                System.out.println("Title of Child Page is :" + childPageTitle);
                driver.close();

            }
        }

        driver.switchTo().window(MainWindow);
        Thread.sleep(30000);
        driver.navigate().back();
    }


    @Test
    public void multipleWindowsInTab() throws InterruptedException {
        driver.findElement(By.xpath("//button[@name='145newbrowsertab234']")).click();
        waitUntillPageLoads(15);
        driver.findElement(By.xpath("//button[@name='145newbrowsertab234']")).click();

        String MainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                String childPageTitle = driver.getTitle();
                System.out.println("Title of Child Page is :" + childPageTitle);
                System.out.println("Chils window is :" + ChildWindow);
                driver.close();

            }
        }

        driver.switchTo().window(MainWindow);
        Thread.sleep(30000);
        driver.navigate().back();
    }
}


