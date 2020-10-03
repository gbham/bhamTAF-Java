package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    }

    public void enterText(By selector, String input)
    {
        WebElement element = waitUntilElementIsReady(selector);
        element.sendKeys(input);
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
}
