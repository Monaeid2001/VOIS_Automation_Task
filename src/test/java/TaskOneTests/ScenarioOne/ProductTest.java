package TaskOneTests.ScenarioOne;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import taskOnePages.scenarioOne.ProductPage;
import utils.JsonReader;

public class ProductTest extends BaseTest {
    ProductPage productPage;
    @Test
    public void searchForItem(){
        productPage =
                homePage
                        .searchForItem(testData.getJsonData("searchedItem"))
                                .clickOnFirstProduct();
        Assert.assertTrue(productPage.isProductTitleDisplayed(), "Product page is not displayed as expected.");

    }
    @BeforeClass
    public void precondition() {
        testData = new JsonReader("amazon-data");
    }
}
