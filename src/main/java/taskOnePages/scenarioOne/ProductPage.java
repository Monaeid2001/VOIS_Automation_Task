package taskOnePages.scenarioOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;


public class ProductPage {
    WebDriver driver;
    private final WaitUtils wait;
    private final By productTitle = By.id("productTitle");
    private final By addToCartButton = By.id("add-to-cart-button");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }
    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }
    public boolean isProductTitleDisplayed() {
        return driver.findElement(productTitle).isDisplayed();
    }
    public CartPage clickAddToCart() {
        wait.waitForElementToBeClickable(addToCartButton).click();
        return new CartPage(driver);
    }
}
