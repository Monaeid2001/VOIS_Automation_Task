package taskOnePages.scenarioTwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

public class ProductDetailsPage {
    WebDriver driver;
    private final WaitUtils wait;
    private final By addToCartButton =  By.cssSelector("button[data-testid='add-to-cart-variational-modal-button']");
    private final By CartNavCounter = By.id("nav-cart-count");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public ProductDetailsPage clickOnAddToCartButton() {
        wait.waitForElementToBeClickable(addToCartButton).click();
        return this;
    }
    public String getCartNavCounterText() {
        return wait.waitForElementVisiblity(CartNavCounter).getText();
    }
    }

