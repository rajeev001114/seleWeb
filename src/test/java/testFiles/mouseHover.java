
package testFiles;

        import org.openqa.selenium.WebElement;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import pages.BaseClass;

public class mouseHover extends BaseClass {

    @BeforeClass
    public void setup() {
        // to do data setup

    }

    @Test
    public void mouseHover() throws InterruptedException {

        clickOnElementByXPATH("//a[text()='Hovers']",driver );

        WebElement ele = findElementByXPATH("//h5[text()='name: user1']/parent::*/parent::*//img[1]");
        mouseHover(ele);
        clickOnElementByXPATH("//a[text()='View profile']",driver );
        Thread.sleep(30000);
        driver.navigate().back();

    }
}