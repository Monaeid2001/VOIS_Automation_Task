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

public class HomeTest extends BaseTest {
    TodaysDeals todaysDeals;
    @Test
    public void checkDealToday() {
         todaysDeals = homePage
                 .ClickOnDismissButton()
                 .clickOnTodaysDeals();
        Assert.assertTrue(driver.getTitle().contains("Today's Deals"));
    }
}
