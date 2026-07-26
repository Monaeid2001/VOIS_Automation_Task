package TaskTwoTests;

import TaskTwoPages.HomePage;
import TaskTwoPages.LoginPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.JsonReader;

public class LoginTest {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    JsonReader testData;
    @Test
    public void validLoginTest() {
        homePage = new HomePage(driver);
        homePage =
             homePage.chooseEnglish()
                     .clickLoginRegisterBtn()
                     .login(testData.getJsonData("email"), testData.getJsonData("password"));
        Assert.assertTrue(homePage.isAccountDisplayed(), "User is not logged in.");

    }
    @Test
    public void inValidLoginTest(){
        homePage = new HomePage(driver);
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
    @BeforeMethod
    public void setUp() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new EdgeDriver(options);
        driver.navigate().to("https://go-bus.com/");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }
    @AfterMethod
    public void tearDown() {
          driver.quit();
    }
}
