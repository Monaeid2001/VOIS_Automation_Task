package TaskTwoTests;

import TaskTwoPages.HomePage;
import TaskTwoPages.LoginPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    HomePage homePage;
    @Test
    public void testLogin() {
        homePage = new HomePage(driver);
        homePage =
             homePage.chooseEnglish()
                     .clickLoginRegisterBtn()
                     .login("mona.eid.yiehia@gmail.com","Mm@123456");
        Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in successfully.");

    }


    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        driver.navigate().to("https://go-bus.com/");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }
    @AfterMethod
    public void tearDown() {
        //  driver.quit();
    }
}
