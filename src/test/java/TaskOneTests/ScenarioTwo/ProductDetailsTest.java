package TaskOneTests.ScenarioTwo;

import driver.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.taskOnePages.scenarioTwo.HomePage;
import pages.taskOnePages.scenarioTwo.TodaysDealsPage;
import utils.JsonReader;
import utils.PropertyReader;
@Epic("Amazon Second Scenario")
@Feature("Product Details")
@Story("Selecting Today's Deals and verifying department and discount")
@Severity(SeverityLevel.CRITICAL)
@Owner("Monmon")
public class ProductDetailsTest extends BaseTest {
    TodaysDealsPage todaysDealsPage;
    @Test public void chooseTodaysDeals() {
        todaysDealsPage = homePage
                .dismissContinueShoppingPageIfPresent()
                .ClickOnDismissButton()
                .clickOnTodaysDeals();
        Assert.assertTrue(driver.getTitle().contains("Today's Deals"));
    }
    @Test(dependsOnMethods = "chooseTodaysDeals")
    public void getDepartmentWithDiscount() {
        todaysDealsPage.setMinDiscount(10)
                        .clickOnDepartment();
        Assert.assertTrue(todaysDealsPage.getDiscounttPillText().contains("10%"), "Discount pill text does not match expected value.");
        Assert.assertTrue(todaysDealsPage.getDepartmentPillText().contains("Grocery"), "Department text does not match expected value.");

    }
    @BeforeClass
    public void setUp() {
        testData = new JsonReader("amazon-data");
        driver = DriverManager.createDriver(PropertyReader.getProperty("browser"));
        driver.navigate().to(PropertyReader.getProperty("baseUrl2"));
        driver.manage().window().setSize(new Dimension(1024, 768));
        homePage = new HomePage(driver);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
