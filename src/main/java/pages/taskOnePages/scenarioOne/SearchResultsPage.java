package pages.taskOnePages.scenarioOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;
    private final WaitUtils wait;
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }
    private final By productLinksLocator = By.xpath("//div[@data-component-type='s-search-result']//h2/parent::a");
    private final By searchResults = By.xpath("//h2[contains(text(),'Results')]");

    public ProductPage clickOnProduct() {
        List<WebElement> productLinks = driver.findElements(productLinksLocator);
        if (!productLinks.isEmpty()) {
            WebElement firstProductLink = productLinks.get(2);
            wait.waitForElementToBeClickable(firstProductLink).click();
        } else {
            throw new RuntimeException("No product links found on the search results page.");
        }
        return new ProductPage(driver);
    }
    public String getSearchResultsText() {
        return driver.findElement(searchResults).getText();
    }


}
