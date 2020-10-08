package Base;

import handler.DriverFactory;
import handler.LoggerFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;
import pages.Menu;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class BaseTest {

    @BeforeSuite (alwaysRun = true)
    public void beforeSuite() throws IOException
    {
        File dir1 = new File("TestResults\\Screenshots");
        File dir2 = new File("TestResults\\VideoRecordings");
        File dir3 = new File("TestResults\\Logs");

        dir1.mkdirs();
        dir2.mkdirs();
        dir3.mkdirs();

        LoggerFactory.InitialiseLogger();
    }

    @BeforeMethod (alwaysRun = true)
    public void beforeMethod(ITestResult testResult) throws Exception
    {
    }

    @AfterMethod (alwaysRun = true)
    public void afterMethod(ITestResult testResult) throws Exception
    {
        if(!testResult.isSuccess())
        {
            LOG().warning("[TEST FAILED] - " + testResult.getThrowable().toString());
            for(int i=0; i<testResult.getThrowable().getStackTrace().length; i++)
            {
                LOG().warning(testResult.getThrowable().getStackTrace()[i].toString());
            }

            takeScreenshot(testResult);
        }
        else
        {
            LOG().info("[TEST PASSED]");
        }

        LoggerFactory.getInstance().removeLogger();
        DriverFactory.getInstance().removeDriver();
    }

    //need separate local and remote versions of this function (logs/screenshots are archived when remote, need to handle the local ones that will get overwritten)
    public void takeScreenshot(ITestResult testResult) throws IOException
    {
        TakesScreenshot TS = ((TakesScreenshot) DriverFactory.getInstance().getDriver());
        File srcFile = TS.getScreenshotAs(OutputType.FILE);

        File destFile = new File(String.format("TestResults\\Screenshots\\%1$s.png", testResult.getName()));

        FileUtils.copyFile(srcFile, destFile);

        LOG().info("Screenshot Captured");
    }

    public Menu loadSite()
    {
        var HomePage = new HomePage();
        HomePage.loadSite();

        return new Menu();
    }

    public Logger LOG()
    {
        return LoggerFactory.getInstance().getLogger();
    }
}
