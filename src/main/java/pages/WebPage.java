package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebPage {

    protected WebDriver Driver;
    protected WebDriverWait Wait;

    public WebPage (WebDriver Driver)
    {
        this.Driver = Driver;
    }

    public String getActualPageTitle()
    {
        return Driver.getTitle();
    }

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
        return getWait().until(ExpectedConditions.elementToBeClickable(selector));
    }

    public WebDriverWait getWait() //int timeout = 10 - no default param in java (builder pattern seems to be best alternative)
    {
        Wait = new WebDriverWait(Driver, 10);
        return Wait;
    }
}
