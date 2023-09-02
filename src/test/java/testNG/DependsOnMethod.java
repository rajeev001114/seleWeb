package testNG;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BaseClass;
import utility.Log;

public class DependsOnMethod extends BaseClass {

    @Test
    @Parameters({"author"})
    public void m1(@Optional("IamOptional") String author)
    {
        Log.info("Authour : " + author);
        Log.info("Test method one");

    }
    @Test(description = "test method2", dependsOnMethods = "m1", invocationCount = 3)
    public void m2()
    {
        Log.info("Test method two");
    }
    @Test

    public void m3()
    {
        Assert.fail();
        Log.info("Test method three");
    }
    @Test(dependsOnMethods = {"m3", "m1"})
    public void m4()
    {
        Log.info("Test method four");
    }
}
