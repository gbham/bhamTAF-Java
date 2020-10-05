package pages;

import handler.DriverFactory;

public class MyAccountPage extends WebPage{

    private final String PAGE_TITLE = "My account - My Store";

    public MyAccountPage ()
    {
        super();
    }

    public String getExpectedPageTitle()
    {
        return PAGE_TITLE;
    }

    public String getActualPageTitle()
    {
        return DriverFactory.getInstance().getDriver().getTitle();
    }
}
