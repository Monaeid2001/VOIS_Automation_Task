package TaskOneTests.ScenarioOne;

import driver.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.taskOnePages.scenarioOne.HomePage;
import pages.taskOnePages.scenarioOne.SearchResultsPage;
import utils.JsonReader;
import utils.PropertyReader;
@Epic("Amazon First Scenario")
@Feature("Searching for a product")
@Story("Searching for a product and verifying the search results")
@Severity(SeverityLevel.CRITICAL)
@Owner("Monmon")
public class SearchTest extends BaseTest {
    SearchResultsPage searchResultsPage;

    @Test
    public void searchForItem(){
        searchResultsPage =
                homePage
                .searchForItem(testData.getJsonData("searchedItem"));

        Assert.assertEquals(searchResultsPage.getSearchResultsText(), "Results", "Search results text does not match expected value.");
    }
    @BeforeClass
    public void precondition() {
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

