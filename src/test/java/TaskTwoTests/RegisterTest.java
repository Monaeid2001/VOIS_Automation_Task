package TaskTwoTests;

import TaskTwoPages.HomePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.JsonReader;

public class RegisterTest {
    WebDriver driver;
    HomePage homePage;
    JsonReader testData;
    @Test
    public void registerTest(){
        homePage = new HomePage(driver);
                       homePage.chooseEnglish()
                        .clickLoginRegisterBtn()
                        .clickRegisterBtn()
                        .register(testData.getJsonData("name")
                                , testData.getJsonData("phone")
                                , testData.getJsonData("email")
                                , testData.getJsonData("password")
                                , testData.getJsonData("confirmPassword"));
        Assert.assertTrue(homePage.isAccountDisplayed(), "User is not registered.");

    }
    @BeforeClass
    public void precondition() {
        testData = new JsonReader("register-data");
    }

    @BeforeMethod
    public void setUp() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        driver = new EdgeDriver(options);
        driver.navigate().to("https://go-bus.com/");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }
    @AfterMethod
    public void tearDown() {
          driver.quit();
    }
}
