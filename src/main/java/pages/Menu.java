package pages;

import org.openqa.selenium.By;

public class Menu extends WebPage {

    private final By LOGIN_BTN = By.className("login");

    public Menu()
    {
        super();
    }

    public LoginPage goToLoginPage()
    {
        clickElement(LOGIN_BTN);

        return new LoginPage();
    }
}
