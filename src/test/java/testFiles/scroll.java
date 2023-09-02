


package testFiles;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Ignore;
        import org.testng.annotations.Test;
        import pages.BaseClass;

public class scroll extends BaseClass {
    public  static String URL2 = "https://nxtgenaiacademy.com/demo-site/";
    public  static String URL3 = "https://www.amazon.in/";
    @BeforeClass
    public void setup() {
        driver = getEventFiringWebDriver();

        driver.get(URL2);

    }

    @Ignore
    public void mouseHover() throws InterruptedException {

        clickOnElementByXPATH("//a[text()='Infinite Scroll']",driver );
        scrollToSomeValue(250);
        Thread.sleep(30000);
        driver.navigate().back();

    }

    @Test
    public void amazonMobile() throws InterruptedException {

        //clickOnElementByXPATH("//a[text()='Infinite Scroll']");
        scrollToSomeValue(350);

        clickOnElementByXPATH("//span[@aria-labelledby='select2-vfb-13-country-container']",driver );
        //WebElement we = driver.findElement(By.xpath("//span[@aria-labelledby='select2-vfb-13-country-container']"));
        WebElement we = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
        we.sendKeys("Algeria");

        clickOnElementByXPATH("//span[@class='select2-results']//ul[1]",driver );
        // Select the option with value "6"

        //selectElementInDropDownByValue(we, "Algeria");
        Thread.sleep(10000);
        driver.navigate().back();

    }
}