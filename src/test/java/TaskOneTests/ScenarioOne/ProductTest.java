package TaskOneTests.ScenarioOne;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import taskOnePages.scenarioOne.HomePage;
import taskOnePages.scenarioOne.ProductPage;
import taskOnePages.scenarioOne.SearchResultsPage;

public class ProductTest {
    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    @Test
    public void searchForItem(){
        homePage = new HomePage(driver);
        productPage =
                homePage
                        .searchForItem(" car accessories")
                                .clickOnFirstProduct();
        Assert.assertTrue(productPage.isProductTitleDisplayed(), "Product page is not displayed as expected.");

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
