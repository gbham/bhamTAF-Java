package pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;

public class HomePage extends WebPage {

    private final String BASE_URL = Dotenv.load().get("BASE_URL_TEST");
    private final String PAGE_TITLE = "My Store";

    public HomePage (WebDriver Driver)
    {
        super(Driver);
    }

    public String getExpectedPageTitle()
    {
        return PAGE_TITLE;
    }

    public void loadSite()
    {
        Driver.get(BASE_URL);
    }
}
