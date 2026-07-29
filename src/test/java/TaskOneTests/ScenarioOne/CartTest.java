package TaskOneTests.ScenarioOne;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import taskOnePages.scenarioOne.CartPage;
import utils.JsonReader;

public class CartTest extends BaseTest {
    CartPage cartPage;
    @Test
    public void addItemToCart() {
        cartPage = homePage.searchForItem(testData.getJsonData("searchedItem"))
                .clickOnFirstProduct()
                .clickAddToCart();
        Assert.assertEquals(cartPage.getSuccessMessage(), testData.getJsonData("messages.success"), "Success message does not match expected value.");

    }
    @BeforeClass
    public void precondition() {
        testData = new JsonReader("amazon-data");
    }
}
