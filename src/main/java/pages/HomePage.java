package pages;

import factory.DriverFactory;
import io.github.cdimascio.dotenv.Dotenv;

public class HomePage extends WebPage {

    private final String BASE_URL = Dotenv.load().get("BASE_URL");
    private final String PAGE_TITLE = "My Store";

    public HomePage ()
    {
        super();
    }

    public String getExpectedPageTitle()
    {
        return PAGE_TITLE;
    }

    public void loadSite()
    {
        DriverFactory.getInstance().getDriver().get(BASE_URL);
    }
}
