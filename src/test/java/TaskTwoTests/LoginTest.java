package TaskTwoTests;

import TaskTwoPages.HomePage;
import TaskTwoPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.JsonReader;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @Test
    public void validLoginTest() {
        homePage =
             homePage.chooseEnglish()
                     .clickLoginRegisterBtn()
                     .login(testData.getJsonData("email"), testData.getJsonData("password"));
        Assert.assertTrue(homePage.isAccountDisplayed(), "User is not logged in.");

    }
    @Test
    public void inValidLoginTest(){
     //   homePage = new HomePage(driver);
        loginPage =
                homePage.chooseEnglish()
                        .clickLoginRegisterBtn()
                        .loginWithInvalidCredentials(testData.getJsonData("email"), testData.getJsonData("invalidPassword"));
        Assert.assertEquals(loginPage.getLoginErrorMessage(),testData.getJsonData("messages.error"),"Error message is not displayed as expected");
    }



@BeforeClass
    public void precondition() {
        testData = new JsonReader("login-data");
    }

}
