package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menu extends WebPage {

    private final By LOGIN_BTN = By.className("login");

    public Menu (WebDriver Driver)
    {
        super(Driver);
    }

    public LoginPage goToLoginPage()
    {
        clickElement(LOGIN_BTN);

        return new LoginPage(Driver);
    }
}
