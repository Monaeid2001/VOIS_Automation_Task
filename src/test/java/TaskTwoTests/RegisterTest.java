package TaskTwoTests;

import TaskTwoPages.HomePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    WebDriver driver;
    HomePage homePage;
    @Test
    public void registerTest(){
        homePage = new HomePage(driver);
                       homePage.chooseEnglish()
                        .clickLoginRegisterBtn()
                        .clickRegisterBtn()
                        .register("monmon","1155900220","monaeid5858@gmail.com","Mm@123456","Mm@123456");
        Assert.assertTrue(homePage.isAccountDisplayed(), "User is not registered.");

    }

    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        driver.navigate().to("https://go-bus.com/");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }
    @AfterMethod
    public void tearDown() {
          driver.quit();
    }
}
