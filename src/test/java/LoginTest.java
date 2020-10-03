import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest{



//    @Test
//    public void one() throws InterruptedException
//    {
//        var Menu = loadSite();
//        //var testDriver = new ChromeDriver();
//        //testDriver.get("https://www.google.co.uk/");
//        Thread.sleep(4000);
//
//        Assert.assertEquals("https://www.google.co.uk/", DriverFactory.getInstance().getDriver().getCurrentUrl());
//
//        //testDriver.close();
//    }
//
//    @Test
//    public void two() throws InterruptedException
//    {
//        var Menu = loadSite();
//        //var testDriver = new ChromeDriver();
//        //testDriver.get("https://www.google.co.uk/");
//        Thread.sleep(4000);
//
//        Assert.assertEquals("https://www.google.co.uk/", DriverFactory.getInstance().getDriver().getCurrentUrl());
//
//        //testDriver.close();
//    }
//
//    @Test
//    public void three() throws InterruptedException
//    {
//        var Menu = loadSite();
//        //var testDriver = new ChromeDriver();
//        //testDriver.get("https://www.google.co.uk/");
//        Thread.sleep(4000);
//
//        Assert.assertEquals("https://www.google.co.uk/", DriverFactory.getInstance().getDriver().getCurrentUrl());
//
//        //testDriver.close();
//    }
//
//    @Test
//    public void four() throws InterruptedException
//    {
//        var Menu = loadSite();
//        //var testDriver = new ChromeDriver();
//        //testDriver.get("https://www.google.co.uk/");
//        Thread.sleep(4000);
//
//        Assert.assertEquals("https://www.google.co.uk/", DriverFactory.getInstance().getDriver().getCurrentUrl());
//
//        //testDriver.close();
//    }

//    @Test
//    public void five() throws InterruptedException
//    {
//        var Menu = loadSite();
//        //var testDriver = new ChromeDriver();
//        //testDriver.get("https://www.google.co.uk/");
//        Thread.sleep(4000);
//
//        Assert.assertEquals("https://www.google.co.uk/", this.Driver.getCurrentUrl());
//
//        //testDriver.close();
//    }
//
//    @Test
//    public void five() throws InterruptedException
//    {
//        var Menu = loadSite();
//        Thread.sleep(3000);
//    }

//
//
//
//    @Test
//    public void AddEvent1() throws InterruptedException
//    {
//
//        final By TITLE_FIELD = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > input:nth-child(1)");
//        final By DETAILS_FIELD = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > textarea");
//        final By SUBMIT_BTN = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > button");
//
//        var Menu = loadSite();
//
//        Thread.sleep(3000);
//
//        var title = Driver.findElement(TITLE_FIELD);
//        var details = Driver.findElement(DETAILS_FIELD);
//        var submitBtn = Driver.findElement(SUBMIT_BTN);
//
//        title.sendKeys("TestTitle");
//        details.sendKeys("details");
//
//        submitBtn.click();
//
//       Thread.sleep(3000);
//
//    }
//
//
//    @Test
//    public void AddEvent2() throws InterruptedException
//    {
//
//        final By TITLE_FIELD = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > input:nth-child(1)");
//        final By DETAILS_FIELD = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > textarea");
//        final By SUBMIT_BTN = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > button");
//
//        var Menu = loadSite();
//
//        Thread.sleep(3000);
//
//        var title = Driver.findElement(TITLE_FIELD);
//        var details = Driver.findElement(DETAILS_FIELD);
//        var submitBtn = Driver.findElement(SUBMIT_BTN);
//
//        title.sendKeys("TestTitle");
//        details.sendKeys("details");
//
//        submitBtn.click();
//
//        Thread.sleep(3000);
//
//    }
//
//    @Test
//    public void AddEvent3() throws InterruptedException
//    {
//
//        final By TITLE_FIELD = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > input:nth-child(1)");
//        final By DETAILS_FIELD = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > textarea");
//        final By SUBMIT_BTN = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > button");
//
//        var Menu = loadSite();
//
//        Thread.sleep(3000);
//
//        var title = Driver.findElement(TITLE_FIELD);
//        var details = Driver.findElement(DETAILS_FIELD);
//        var submitBtn = Driver.findElement(SUBMIT_BTN);
//
//        title.sendKeys("TestTitle");
//        details.sendKeys("details");
//
//        submitBtn.click();
//
//        Thread.sleep(3000);
//
//    }
//
//    @Test
//    public void AddEvent4() throws InterruptedException
//    {
//
//        final By TITLE_FIELD = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > input:nth-child(1)");
//        final By DETAILS_FIELD = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > textarea");
//        final By SUBMIT_BTN = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > button");
//
//        var Menu = loadSite();
//
//        Thread.sleep(3000);
//
//        var title = Driver.findElement(TITLE_FIELD);
//        var details = Driver.findElement(DETAILS_FIELD);
//        var submitBtn = Driver.findElement(SUBMIT_BTN);
//
//        title.sendKeys("TestTitle");
//        details.sendKeys("details");
//
//        submitBtn.click();
//
//        Thread.sleep(3000);
//
//    }

//    @Test
//    public void AddEvent5() throws InterruptedException
//    {
//
//        final By TITLE_FIELD = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > input:nth-child(1)");
//        final By DETAILS_FIELD = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > textarea");
//        final By SUBMIT_BTN = By.cssSelector("#events > div.col-sm-7 > div > div.panel-body > div > button");
//
//        var Menu = loadSite();
//
//        Thread.sleep(3000);
//
//        var title = Driver.findElement(TITLE_FIELD);
//        var details = Driver.findElement(DETAILS_FIELD);
//        var submitBtn = Driver.findElement(SUBMIT_BTN);
//
//        title.sendKeys("TestTitle");
//        details.sendKeys("details");
//
//        submitBtn.click();
//
//        Thread.sleep(3000);
//
//    }
    

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

     @Test
     public void Login_Failure_InvalidEmail()
     {
         var Menu = loadSite();

         var LoginPage = Menu.goToLoginPage();

         LoginPage.enterUsername("invalidEmail")
                  .enterPassword("12345")
                  .clickSignIn();

         var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("InvalidEmail");

         var ActualErrorMsg = LoginPage.GetActualErrorMsg();

         Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
     }

     @Test
     public void Login_Failure_InvalidPassword()
     {
         var Menu = loadSite();

         var LoginPage = Menu.goToLoginPage();

         LoginPage.enterUsername("johnsmith@hotmail.com")
                  .enterPassword("1")
                  .clickSignIn();

         var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("InvalidPassword");

         var ActualErrorMsg = LoginPage.GetActualErrorMsg();

         Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
     }

     @Test
     public void Login_Failure_IncorrectCre2dentials()
     {
         var Menu = loadSite();

         var LoginPage = Menu.goToLoginPage();

         LoginPage.enterUsername("emailNotFound@hotmail.com")
                  .enterPassword("123456789")
                  .clickSignIn();

         var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("IncorrectCredentials");

         var ActualErrorMsg = LoginPage.GetActualErrorMsg();

         Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
     }

    @Test
    public void Login_Failure_IncorrectCred3entials()
    {
        var Menu = loadSite();

        var LoginPage = Menu.goToLoginPage();

        LoginPage.enterUsername("emailNotFound@hotmail.com")
                .enterPassword("123456789")
                .clickSignIn();

        var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("IncorrectCredentials");

        var ActualErrorMsg = LoginPage.GetActualErrorMsg();

        Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
    }

    @Test
    public void Login_Failure_IncorrectCrede4ntials()
    {
        var Menu = loadSite();

        var LoginPage = Menu.goToLoginPage();

        LoginPage.enterUsername("emailNotFound@hotmail.com")
                .enterPassword("123456789")
                .clickSignIn();

        var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("IncorrectCredentials");

        var ActualErrorMsg = LoginPage.GetActualErrorMsg();

        Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
    }

    @Test
    public void Login_Failure_IncorrectCreden5tials()
    {
        var Menu = loadSite();

        var LoginPage = Menu.goToLoginPage();

        LoginPage.enterUsername("emailNotFound@hotmail.com")
                .enterPassword("123456789")
                .clickSignIn();

        var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("IncorrectCredentials");

        var ActualErrorMsg = LoginPage.GetActualErrorMsg();

        Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
    }

    @Test
    public void Login_Failure_IncorrectCreden6tials()
    {
        var Menu = loadSite();

        var LoginPage = Menu.goToLoginPage();

        LoginPage.enterUsername("emailNotFound@hotmail.com")
                .enterPassword("123456789")
                .clickSignIn();

        var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("IncorrectCredentials");

        var ActualErrorMsg = LoginPage.GetActualErrorMsg();

        Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
    }

    @Test
    public void Login_Failure_IncorrectCreden7tials()
    {
        var Menu = loadSite();

        var LoginPage = Menu.goToLoginPage();

        LoginPage.enterUsername("emailNotFound@hotmail.com")
                .enterPassword("123456789")
                .clickSignIn();

        var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("IncorrectCredentials");

        var ActualErrorMsg = LoginPage.GetActualErrorMsg();

        Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
    }

    @Test
    public void Login_Failure_IncorrectCrede7ntials()
    {
        var Menu = loadSite();

        var LoginPage = Menu.goToLoginPage();

        LoginPage.enterUsername("emailNotFound@hotmail.com")
                .enterPassword("123456789")
                .clickSignIn();

        var ExpectedErrorMsg = LoginPage.ErrorMsgs.get("IncorrectCredentials");

        var ActualErrorMsg = LoginPage.GetActualErrorMsg();

        Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg);
    }
}
