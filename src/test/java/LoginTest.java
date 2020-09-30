import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest{


    @Test
    public void AddEvent() throws InterruptedException
    {
        var Menu = loadSite();

        Thread.sleep(3000);

        final By TITLE_FIELD = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > input:nth-child(1)");
        final By DETAILS_FIELD = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > textarea");
        final By SUBMIT_BTN = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > button");



        var title = Driver.findElement(TITLE_FIELD);
        var details = Driver.findElement(DETAILS_FIELD);
        var submitBtn = Driver.findElement(SUBMIT_BTN);


        title.sendKeys("TestTitle");
        details.sendKeys("details");

        submitBtn.click();



    }

//    @Test
//    public void Login_Successful()
//    {
//        var Menu = loadSite();
//
//        var LoginPage = Menu.goToLoginPage();
//
//        var MyAccountPage = LoginPage.enterUsername("johnsmith@hotmail.com")
//                                                   .enterPassword("12345")
//                                                   .clickSignIn();
//
//        var ExpectedPageTitle = MyAccountPage.getExpectedPageTitle();
//
//        var ActualPageTitle = MyAccountPage.getActualPageTitle();
//
//        Assert.assertEquals(ExpectedPageTitle, ActualPageTitle);
//    }
//
//     @Test
//     public void Login_Failure_InvalidEmail()
//     {
//         var Menu = loadSite();
//
//         var LoginPage = Menu.goToLoginPage();
//
//         LoginPage.enterUsername("invalidEmail")
//                  .enterPassword("12345")
//                  .clickSignIn();
//
//         var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("InvalidEmail");
//
//         var ActualErrorMsg = LoginPage.GetActualErrorMsg();
//
//         Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
//     }
//
//     @Test
//     public void Login_Failure_InvalidPassword()
//     {
//         var Menu = loadSite();
//
//         var LoginPage = Menu.goToLoginPage();
//
//         LoginPage.enterUsername("johnsmith@hotmail.com")
//                  .enterPassword("1")
//                  .clickSignIn();
//
//         var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("InvalidPassword");
//
//         var ActualErrorMsg = LoginPage.GetActualErrorMsg();
//
//         Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
//     }
//
//     @Test
//     public void Login_Failure_IncorrectCredentials()
//     {
//         var Menu = loadSite();
//
//         var LoginPage = Menu.goToLoginPage();
//
//         LoginPage.enterUsername("emailNotFound@hotmail.com")
//                  .enterPassword("123456789")
//                  .clickSignIn();
//
//         var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("IncorrectCredentials");
//
//         var ActualErrorMsg = LoginPage.GetActualErrorMsg();
//
//         Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
//     }
}
