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

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() throws IOException
    {
        File dir1 = new File("TestResults\\Screenshots");
        File dir2 = new File("TestResults\\Logs");

        dir1.mkdirs();
        dir2.mkdirs();

        LoggerFactory.InitialiseLogger();
    }

    @BeforeMethod
    public void beforeMethod()
    {
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException
    {
        if(!testResult.isSuccess())
        {
            this.takeScreenshot(testResult);
        }

        LoggerFactory.getInstance().removeLogger();
        DriverFactory.getInstance().removeDriver();
    }

    //need separate local and remote versions of this function (logs/screenshots are archived when remote)
    public void takeScreenshot(ITestResult testResult) throws IOException
    {
        TakesScreenshot TS = ((TakesScreenshot)DriverFactory.getInstance().getDriver());
        File srcFile = TS.getScreenshotAs(OutputType.FILE);

        File destFile = new File(String.format("TestResults\\Screenshots\\%1$s.png", testResult.getName()));

        FileUtils.copyFile(srcFile, destFile);
    }

    public Menu loadSite()
    {
        var HomePage = new HomePage();
        HomePage.loadSite();

        return new Menu();
    }
}
