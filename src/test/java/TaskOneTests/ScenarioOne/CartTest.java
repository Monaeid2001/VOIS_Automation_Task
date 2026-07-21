package TaskOneTests.ScenarioOne;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import taskOnePages.scenarioOne.CartPage;
import taskOnePages.scenarioOne.HomePage;
import taskOnePages.scenarioOne.ProductPage;

public class CartTest {
    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;
    @Test
    public void addItemToCart() {
        homePage = new HomePage(driver);
        cartPage = homePage.searchForItem(" car accessories")
                .clickOnFirstProduct()
                .clickAddToCart();
        Assert.assertEquals(cartPage.getSuccessMessage(), "Added to cart", "Success message does not match expected value.");

    }
    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        driver.navigate().to("https://www.amazon.com");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }
    @AfterMethod
    public void tearDown() {
     //   driver.quit();
    }
}
