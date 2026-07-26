package TaskOneTests.ScenarioTwo;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import taskOnePages.scenarioTwo.HomePage;
import taskOnePages.scenarioTwo.TodaysDeals;

public class HomeTest
{
    WebDriver driver;
    HomePage homePage;
    TodaysDeals todaysDeals;
    @Test
    public void checkDealToday() {
        homePage = new HomePage(driver);
         todaysDeals = homePage
                 .ClickOnDismissButton()
                 .clickOnTodaysDeals();
        Assert.assertTrue(driver.getTitle().contains("Today's Deals"));
      //  homePage.selectMinimumDiscount(10);
    }
    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        driver.navigate().to("https://www.amazon.com");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }
    @AfterMethod
    public void tearDown() {
           driver.quit();
    }
}
