package TaskOneTests.ScenarioTwo;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import taskOnePages.scenarioTwo.HomePage;
import taskOnePages.scenarioTwo.ProductDetailsPage;
import utils.JsonReader;

public class ProductDetailsTest extends BaseTest {
    ProductDetailsPage productDetailsPage;
    @Test
    public void AddProductToCart() {
        productDetailsPage =
                homePage.ClickOnDismissButton()
                        .clickOnTodaysDeals()
                        .setMinDiscount(Integer.parseInt(testData.getJsonData("discount")))
                        .clickOnDepartment()
                        .clickOnProductDetailsButton()
                        .clickOnAddToCartButton();
        Assert.assertEquals(productDetailsPage.getCartNavCounterText(),"1","cart counter doesn't match expected value");

    }
    @BeforeClass
    public void precondition() {
        testData = new JsonReader("amazon-data");
    }

}

