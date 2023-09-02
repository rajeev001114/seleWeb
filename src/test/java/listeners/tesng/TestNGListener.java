package listeners.tesng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utility.Log;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static pages.BaseClass.driver;

public class TestNGListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Log.info("on start of TestNGListener");
            Date d = new Date();
            String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
            //File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //FileHandler.copy(screenshot, new File("/home/users/bhanu.pratap/Documents/testScreenshot/" + FileName));

            //Take the screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            //Copy the file to a location and use try catch block to handle exception
            File destFile = new File("C:\\projectScreenshots\\" + FileName);

            FileUtils.copyFile(screenshot, new File("C:\\projectScreenshots\\" + FileName));
            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");

            Log.info("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onFinish(ITestContext context) {}


    @Override
    public void onTestStart(ITestResult result) {   }

    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }

}