package taskOnePages.scenarioOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By productLinksLocator = By.xpath("//div[@data-component-type='s-search-result']//h2/parent::a");
    private final By searchResults = By.xpath("//h2[contains(text(),'Results')]");

    public ProductPage clickOnFirstProduct() {
        List<WebElement> productLinks = driver.findElements(productLinksLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (!productLinks.isEmpty()) {
            WebElement firstProductLink = productLinks.get(2);
           wait.until(ExpectedConditions.elementToBeClickable(firstProductLink)).click();
        } else {
            throw new RuntimeException("No product links found on the search results page.");
        }
        return new ProductPage(driver);
    }
    public String getSearchResultsText() {
        return driver.findElement(searchResults).getText();
    }


}
