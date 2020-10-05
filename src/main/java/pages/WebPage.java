package pages;

import handler.DriverFactory;
import handler.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public abstract class WebPage {

    protected WebDriverWait Wait;

    public WebElement getWebElement(By selector)
    {
        return waitUntilElementIsReady(selector);
    }

    public void clickElement(By selector)
    {
        WebElement element = waitUntilElementIsReady(selector);
        element.click();
        LOG().info(String.format("Clicked Element: [%1s]", selector));
    }

    public void enterText(By selector, String input)
    {
        WebElement element = waitUntilElementIsReady(selector);
        element.sendKeys(input);

        //Need to handle the issue with logging the user input when this function is entering passwords (find the best default param workaround for java)
        LOG().info(String.format("Entered text: [%1s] into Element: [%2s]", input, selector));
    }

    public WebElement waitUntilElementIsReady(By selector)
    {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public WebDriverWait getWait() //int timeout = 10 - no default param in java (builder pattern seems to be best alternative)
    {
        Wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 10);
        return Wait;
    }

    protected Logger LOG()
    {
        return LoggerFactory.getInstance().getLogger();
    }
}
