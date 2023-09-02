package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;
import utility.Log;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class WebDriverListener implements WebDriverEventListener {


    @Override
    public void beforeAlertAccept(WebDriver driver) {
        Log.info("After Navigate to");
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        Log.info("After Navigate to");
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        Log.info("After Navigate to");
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        Log.info("you come to join listners");
        try {
        Date d = new Date();
        String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
        //File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileHandler.copy(screenshot, new File("/home/users/bhanu.pratap/Documents/testScreenshot/" + FileName));

        //Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Copy the file to a location and use try catch block to handle exception

            //Copy the file to a location and use try catch block to handle exception
            File destFile = new File("C:/projectScreenshots/" + FileName);
            String path = destFile.getAbsolutePath();
            path = path.replace('\\', '/');
            path = "file:///" + path;
            Log.info(path);
            Log.info("first");
            FileUtils.copyFile(screenshot, destFile);
            Reporter.log("This is from webdriver", true);
            System.setProperty("org.uncommons.reportng.escape-output", "false");
            Log.info(destFile.toString());
            //Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
            Reporter.log("<a href='"+ path + "'> <img src='"+ path + "' height='100' width='100'/> </a>");


            Reporter.log(
                    "<a title= \"title\" href=\"" + path + "\">" +
                            "<img width=\"418\" height=\"240\" alt=\"alternativeName\" title=\"title\" src=\""+path+"\"></a>");
            Log.info("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        Log.info("After Navigate to");

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        Log.info("After Navigate to");

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        Log.info("After Navigate to");

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        Log.info("After Navigate to");

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        Log.info("After Navigate to");

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        Log.info("After Navigate to");

    }
}
