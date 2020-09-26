import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.Menu;
import org.openqa.selenium.WebDriver;
import io.github.cdimascio.dotenv.Dotenv;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver Driver;

    protected String BROWSER_TYPE = Dotenv.load().get("BROWSER_TYPE");
    protected String SELENIUM_GRID = Dotenv.load().get("SELENIUM_GRID");
    protected String SELENIUM_HUB_URL = Dotenv.load().get("SELENIUM_HUB_URL");

    @BeforeMethod
    public void SetUpDriver() throws MalformedURLException
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
    public void cleanUp() { Driver.quit(); }

    private WebDriver getRemoteDriver() throws MalformedURLException
    {
        switch(BROWSER_TYPE)
        {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
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

    public Menu loadSite()
    {
        var HomePage = new HomePage(Driver);
        HomePage.loadSite();

        return new Menu(Driver);
    }
}
