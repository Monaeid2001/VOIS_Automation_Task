package taskOnePages.scenarioOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    private final By SuccessMessage = By.xpath("//h1[contains(text(),'Added to cart')]");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getSuccessMessage() {
        return driver.findElement(SuccessMessage).getText();
    }
}
