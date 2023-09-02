
package testFiles;

        import org.openqa.selenium.WebElement;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import pages.BaseClass;

public class CheckBox extends BaseClass {

    @BeforeClass
    public void setup() {
        // to do data setup

    }

    @Test
    public void selectCheckBox() throws InterruptedException {


        clickOnElementByXPATH("//a[text()='Checkboxes']", driver );

        waitUntillPageLoads(5);
        WebElement checkbox = findElementByXPATH("//*[@id='checkboxes']//input[2]");

        selectCheckBoxBytext(checkbox);
        Thread.sleep(30000);
        driver.navigate().back();

    }
}
