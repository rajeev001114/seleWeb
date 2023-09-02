package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pages.BaseClass;
import utility.Log;
import org.testng.annotations.Test;


public class DataProviderNew extends BaseClass {

    @DataProvider(name = "test-data")
    public Object[][] dataProvFunc(){
        return new Object[][]{
                {"Lambda Test"},{"Automation"}
        };
    }

    @BeforeMethod
    public void setUp() {

        driver = getEventFiringWebDriver();
        String url = "https://www.google.com";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test(dataProvider ="test-data")
    public void search(String keyWord){
        WebElement txtBox = driver.findElement(By.name("q"));
        txtBox.sendKeys(keyWord);
        Log.info("Keyword entered is : " +keyWord);
        txtBox.sendKeys(Keys.ENTER);
    }

    @AfterMethod
    public void burnDown(){

        driver.close();
    }
}
