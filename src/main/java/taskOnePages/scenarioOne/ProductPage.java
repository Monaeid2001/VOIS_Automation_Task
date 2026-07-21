package taskOnePages.scenarioOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    private final By productTitle = By.id("productTitle");
    private final By addToCartButton = By.id("add-to-cart-button");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }
    public boolean isProductTitleDisplayed() {
        return driver.findElement(productTitle).isDisplayed();
    }
    public CartPage clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        return new CartPage(driver);
    }
}
