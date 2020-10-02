import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;
import pages.Menu;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    protected WebDriver Driver;
    protected String TEST_DIR;

    protected String BROWSER_TYPE = Dotenv.load().get("BROWSER_TYPE");
    protected String SELENIUM_GRID = Dotenv.load().get("SELENIUM_GRID");
    protected String SELENIUM_HUB_URL = Dotenv.load().get("SELENIUM_HUB_URL");

    @BeforeSuite
    public void createTestDirectory() throws MalformedURLException
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();

//        TEST_DIR = String.format("C:\\Dev\\TestResults\\%s", dtf.format(now));
        TEST_DIR = "/bin";

        //Should maybe fail the test if these dir cannot be created
        File file = new File(TEST_DIR);
        file.mkdirs();

    }

    @BeforeMethod
    public void setUpDriver() throws MalformedURLException
    {
        if(SELENIUM_GRID.equals("true"))
        {
            Driver = getRemoteDriver();
        }
        else
        {
            Driver = getDriver();
        }
    }

    @AfterMethod
    public void cleanUp(ITestResult testResult) throws IOException
    {
        this.takeScreenshot(testResult);
        Driver.quit();
    }

    private WebDriver getRemoteDriver() throws MalformedURLException
    {
        switch(BROWSER_TYPE)
        {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                //chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
                Driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), chromeOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
                edgeOptions.setCapability(CapabilityType.BROWSER_NAME, BrowserType.EDGE);
                Driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), edgeOptions);
                break;
        }
        return Driver;
    }

    private WebDriver getDriver()
    {
        switch(BROWSER_TYPE)
        {
            case "chrome":
                Driver = new ChromeDriver();
                break;

            case "edge":
                Driver = new EdgeDriver();
                break;
        }
        return Driver;
    }

    public void takeScreenshot(ITestResult testResult) throws IOException
    {
        TakesScreenshot TS = ((TakesScreenshot)Driver);
        File srcFile = TS.getScreenshotAs(OutputType.FILE);

        //File srcFileTest = new File("srcTestFile.txt");
        //File srcFileTest = new File("/dev" + File.separator + "srcTestFile.txt");
        File srcFileTest = new File("/tmp/srcTestFile.txt");
        srcFileTest.createNewFile();

//        File destFile = new File(String.format("%1$s\\Screenshots\\%2$s.png", TEST_DIR, testResult.getName()));

        File destFileTest = new File("/tmp/destTestFile.txt");
        //File destDir = new File("/tmp/");

        Files.copy(srcFileTest.toPath(), destFileTest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        //FileUtils.copyFileToDirectory(srcFile, destDir);
        //FileUtils.copyFile(srcFile, destFileTest);

    }

    public Menu loadSite()
    {
        var HomePage = new HomePage(Driver);
        HomePage.loadSite();

        return new Menu(Driver);
    }
}
