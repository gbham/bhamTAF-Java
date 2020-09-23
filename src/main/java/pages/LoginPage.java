package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;


public class LoginPage extends WebPage {

    private final By EMAIL_FIELD = By.id("email");
    private final By PASSWORD_FIELD = By.id("passwd");
    private final By SIGN_IN_BTN = By.id("SubmitLogin");
    private final By ERROR_MSG = By.cssSelector("#center_column > div.alert.alert-danger > ol > li");

    private final String PAGE_TITLE = "Login - My Store";

    public final Map<String, String> ErrorMsgs = Map.of("InvalidEmail",         "Invalid email address.",
                                                        "InvalidPassword",      "Invalid password.",
                                                        "IncorrectCredentials", "Authentication failed.");

    public LoginPage (WebDriver Driver)
    {
        super(Driver);
    }

    public String GetExpectedPageTitle() { return PAGE_TITLE; }

    public String GetActualErrorMsg()
    {
        return getWebElement(ERROR_MSG).getText();
    }

    public LoginPage enterUsername(String username)
    {
        enterText(EMAIL_FIELD, username);
        return this;
    }

    public LoginPage enterPassword(String password)
    {
        enterText(PASSWORD_FIELD, password);
        return this;
    }

    //The ability to chain commands at test level requires separate functions for clicking certain buttons due to the required return type of the function.
    //Not ideal, but at the moment the clarity gained at test level seems worth
    public MyAccountPage clickSignIn()
    {
//        switch(button)
//        {
//            case "SignIn":
                clickElement(SIGN_IN_BTN);
                return new MyAccountPage(Driver);
//            case "CreateAccount":
//              ClickElement(CREATE_ACCOUNT_BTN);
//              break;
//
//        }
//
//        return this;
    }
}
