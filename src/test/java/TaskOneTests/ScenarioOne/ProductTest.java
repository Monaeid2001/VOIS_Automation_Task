package TaskOneTests.ScenarioOne;

import driver.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.taskOnePages.scenarioOne.HomePage;
import pages.taskOnePages.scenarioOne.ProductPage;
import pages.taskOnePages.scenarioOne.SearchResultsPage;
import utils.JsonReader;
import utils.PropertyReader;
@Epic("Amazon First Scenario")
@Feature("Clicking on a product")
@Story("Clicking on a product after searching for it")
@Severity(SeverityLevel.CRITICAL)
@Owner("Monmon")
public class ProductTest extends BaseTest {
    ProductPage productPage;
    SearchResultsPage searchResultsPage;
    @Test
    public void searchForItemTest() {
        searchResultsPage =
                homePage
                        .searchForItem(testData.getJsonData("searchedItem"));
        Assert.assertEquals(searchResultsPage.getSearchResultsText(), "Results", "Search results text does not match expected value.");
    }
    @Test(dependsOnMethods = "searchForItemTest")
    public void clickOnProductTest(){
        productPage =
                searchResultsPage
                                .clickOnProduct();
        Assert.assertTrue(productPage.isProductTitleDisplayed(), "Product page is not displayed as expected.");

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
