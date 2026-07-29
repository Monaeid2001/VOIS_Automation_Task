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

public class TodaysDealsTest extends BaseTest {
    TodaysDeals todaysDeals;
    @Test
    public void getDepartmentwithDiscount() {
        todaysDeals =
                homePage
                        .ClickOnDismissButton()
                        .clickOnTodaysDeals()
                        .setMinDiscount(10)
                        .clickOnDepartment();
        Assert.assertTrue(todaysDeals.getDiscounttPillText().contains("10%"), "Discount pill text does not match expected value.");
        Assert.assertTrue(todaysDeals.getDepartmentPillText().contains("Grocery"), "Department text does not match expected value.");

    }
}
