package pages;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends WebPage{

    private final String PAGE_TITLE = "My account - My Store";

    public MyAccountPage (WebDriver Driver)
    {
        super(Driver);
    }

    public String getExpectedPageTitle()
    {
        return PAGE_TITLE;
    }

}
