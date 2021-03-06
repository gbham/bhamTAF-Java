package handler;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory
{
    protected String BROWSER_TYPE = Dotenv.load().get("BROWSER_TYPE");
    protected String SELENIUM_GRID = Dotenv.load().get("SELENIUM_GRID");
    protected String SELENIUM_HUB_URL = Dotenv.load().get("SELENIUM_HUB_URL");

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance()
    {
        return instance;
    }

    ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() ->
    {
        if(SELENIUM_GRID.equals("true"))
        {
            try
            {
                LoggerFactory.getInstance().getLogger().info("Creating Remote Driver ...");
                return getRemoteDriver();
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else
        {
            LoggerFactory.getInstance().getLogger().info("Creating Local Driver ...");
            return getLocalDriver();
        }

        return null;
    });

    //This does all the initialisation required for driver. If driver doesnt exist then it runs ThreadLocal.withInitial() just above
    public WebDriver getDriver()
    {
        return driver.get();
    }

    public void removeDriver()
    {
        driver.get().quit(); //Cant run multiple instances of the same browser on the same node. We need driver.quit() to clean up (which removes all windows), since driver.close() doesnt clean memory.
        driver.remove();
    }

    private WebDriver getLocalDriver() {

//        switch (BROWSER_TYPE) {
//            case "chrome":
            return new ChromeDriver();
//                break;
//
//            case "edge":
//                driver = new EdgeDriver();
//                break;
//        }

        //return null;
    }

    private WebDriver getRemoteDriver() throws MalformedURLException
    {
//        switch(BROWSER_TYPE)
//        {
            //case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("testFileNameTemplate", String.format("%1s_%2s", BROWSER_TYPE, TestMethodCapture.getTestMethod().getMethodName()));
                //chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
                return new RemoteWebDriver(new URL(SELENIUM_HUB_URL), chromeOptions);
                //break;

//            case "edge":
//                EdgeOptions edgeOptions = new EdgeOptions();
//                edgeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
//                edgeOptions.setCapability(CapabilityType.BROWSER_NAME, BrowserType.EDGE);
//                driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), edgeOptions);
//                break;
        //}
//
        //return null;
    }
}
