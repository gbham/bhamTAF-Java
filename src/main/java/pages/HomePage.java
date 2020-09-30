package pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;

public class HomePage extends WebPage {

    private final String BASE_URL = http://192.168.0.13:8000; //Dotenv.load().get("BASE_URL");
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
