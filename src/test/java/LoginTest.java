import org.junit.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void Login_Successful()
    {
        var Menu = loadSite();

        var LoginPage = Menu.goToLoginPage();

        var MyAccountPage = LoginPage.enterUsername("johnsmith@hotmail.com")
                                                   .enterPassword("12345")
                                                   .clickSignIn();

        var ExpectedPageTitle = MyAccountPage.getExpectedPageTitle();

        var ActualPageTitle = MyAccountPage.getActualPageTitle();

        Assert.assertEquals(ExpectedPageTitle, ActualPageTitle);
    }

//     @Test
//     public void Login_Failure_InvalidEmail()
//     {
//         var Menu = loadSite();

//         var LoginPage = Menu.goToLoginPage();

//         LoginPage.enterUsername("invalidEmail")
//                  .enterPassword("12345")
//                  .clickSignIn();

//         var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("InvalidEmail");

//         var ActualErrorMsg = LoginPage.GetActualErrorMsg();

//         Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
//     }

//     @Test
//     public void Login_Failure_InvalidPassword()
//     {
//         var Menu = loadSite();

//         var LoginPage = Menu.goToLoginPage();

//         LoginPage.enterUsername("johnsmith@hotmail.com")
//                  .enterPassword("1")
//                  .clickSignIn();

//         var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("InvalidPassword");

//         var ActualErrorMsg = LoginPage.GetActualErrorMsg();

//         Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
//     }

//     @Test
//     public void Login_Failure_IncorrectCredentials()
//     {
//         var Menu = loadSite();

//         var LoginPage = Menu.goToLoginPage();

//         LoginPage.enterUsername("emailNotFound@hotmail.com")
//                  .enterPassword("123456789")
//                  .clickSignIn();

//         var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("IncorrectCredentials");

//         var ActualErrorMsg = LoginPage.GetActualErrorMsg();

//         Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
//     }
}
