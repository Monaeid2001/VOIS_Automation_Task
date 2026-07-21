package taskOnePages.scenarioTwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
    WebDriver driver;
    private final By addToCartButton =  By.cssSelector("button[data-testid='add-to-cart-variational-modal-button']");
    private final By CartNavCounter = By.id("nav-cart-count");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductDetailsPage clickOnAddToCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        return this;
    }
    public String getCartNavCounterText() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CartNavCounter)).getText();
    }
    }

