import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import factory.DriverFactory;
import pages.HomePage;
import pages.Menu;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {

    //protected String TEST_DIR;

    //**Changes made in here are not persisting when I run the tests in the Jenkins pipeline. Cannot resolve "TEST_DIR" inside takeScreenshot().
    //Just going to save files in working directory and archive them using Jenkinsfile for this now
    @BeforeSuite
    public void createTestDirectory() throws MalformedURLException
    {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd-HH-mm-ss");
//        LocalDateTime now = LocalDateTime.now();
////
//        TEST_DIR = String.format("C:\\Dev\\TestResults\\%s", dtf.format(now));//
//
//        File file = new File(TEST_DIR);
//        file.mkdirs();

    }

//    @BeforeMethod
//    public void setUpDriver() throws MalformedURLException
//    {
//        if(SELENIUM_GRID.equals("true"))
//        {
//            //this.Driver = getRemoteDriver();
//        }
//        else
//        {
//
//            //this.Driver = getLocalDriver();
//        }
//    }

    @AfterMethod
    public void cleanUp(ITestResult testResult) throws IOException
    {
//        if(!testResult.isSuccess())
//        {
//            this.takeScreenshot(testResult);
//        }
//


        DriverFactory.getInstance().removeDriver();

    }



    private WebDriver getLocalDriver() {

//        switch (BROWSER_TYPE) {
//            case "chrome":
            var driver = new ChromeDriver();
//                break;
//
//            case "edge":
//                driver = new EdgeDriver();
//                break;
//        }

        return driver;
    }

    //need separate local and remote versions of this function
    public void takeScreenshot(ITestResult testResult) throws IOException
    {
        TakesScreenshot TS = ((TakesScreenshot)DriverFactory.getInstance().getDriver());
        File srcFile = TS.getScreenshotAs(OutputType.FILE);

        File destFile = new File(String.format("TestResults\\Screenshots\\%1$s.png", testResult.getName()));

        FileUtils.copyFile(srcFile, destFile);
    }

    public Menu loadSite()
    {
        var HomePage = new HomePage(); //Driver
        HomePage.loadSite();

        return new Menu(); //DriverFactory.getInstance().getDriver()
    }
}
