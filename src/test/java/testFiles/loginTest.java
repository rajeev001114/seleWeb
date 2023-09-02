package testFiles;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BaseClass;

public class loginTest extends BaseClass {

    @BeforeClass
    public void setup() {
        ///driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void login_to_page() {
        WebElement uName = findElementByName("username");
        WebElement password = findElementByName("password");

        clearAndSet(uName, "Admin");
        clearAndSet(password, "admin123");

        clickOnElementByXPATH("//button[@type='submit']",driver );
        //waitUntillVisibilityOfelement("//button[@class='oxd-icon-button oxd-icon-button--success orangehrm-report-icon']");
        clickOnElementByXPATH("//span[text()='Admin']",driver );
        waitUntillPageLoads(5);
    }
}
