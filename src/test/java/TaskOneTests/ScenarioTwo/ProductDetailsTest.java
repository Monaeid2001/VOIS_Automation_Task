package TaskOneTests.ScenarioTwo;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import taskOnePages.scenarioTwo.HomePage;
import taskOnePages.scenarioTwo.ProductDetailsPage;

public class ProductDetailsTest {
    WebDriver driver;
    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    @Test
    public void AddProductToCart() {
        homePage = new HomePage(driver);
        productDetailsPage =
                homePage.ClickOnDismissButton()
                        .clickOnTodaysDeals()
                        .setMinDiscount(10)
                        .clickOnDepartment()
                        .clickOnProductDetailsButton()
                        .clickOnAddToCartButton();
        Assert.assertEquals(productDetailsPage.getCartNavCounterText(),"1","cart counter doesn't match expected value");

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
