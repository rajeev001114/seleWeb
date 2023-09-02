package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseClass;
import utility.Log;

public class DependsOnGroup extends BaseClass {
    int x = 20;
    @Test(groups = "GroupA")
    public void m1()
    {
        Assert.fail();
        Log.info("m1-GroupA");
    }
    @Test(groups = "GroupA")
    public void m2()
    {
        Log.info("m1-GroupA");
    }
    @Test(groups = "GroupB")
    public void m3()
    {
        Log.info("m3-GroupB");
    }
    @Test(dependsOnGroups = "GroupA") // This test method depends on GroupA.
    public void m4()
    {
        Log.info("m4 is dependent on GroupA");

    }
}
