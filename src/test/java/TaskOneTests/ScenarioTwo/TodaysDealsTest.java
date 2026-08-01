package TaskOneTests.ScenarioTwo;

import driver.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.taskOnePages.scenarioTwo.HomePage;
import pages.taskOnePages.scenarioTwo.TodaysDealsPage;
import utils.PropertyReader;
@Epic("Amazon Second Scenario")
@Feature("Today's Deals")
@Story("Selecting Today's Deals and verifying the page title")
@Severity(SeverityLevel.CRITICAL)
@Owner("Monmon")
public class TodaysDealsTest extends BaseTest {
    TodaysDealsPage todaysDealsPage;
    @Test
    public void checkDealToday() {
         todaysDealsPage = homePage
                 .dismissContinueShoppingPageIfPresent()
                 .ClickOnDismissButton()
                 .clickOnTodaysDeals();
        Assert.assertTrue(driver.getTitle().contains("Today's Deals"));
    }
    @BeforeMethod
    public void setUp() {
        driver = DriverManager.createDriver(PropertyReader.getProperty("browser"));
        driver.navigate().to(PropertyReader.getProperty("baseUrl2"));
        driver.manage().window().setSize(new Dimension(1024, 768));
        homePage = new HomePage(driver);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
