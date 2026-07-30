package pages.taskOnePages.scenarioOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;



public class HomePage {

    private final WebDriver driver;
    private final WaitUtils wait;
    private final By searchField = By.id("twotabsearchtextbox");
    private final By searchButton = By.id("nav-search-submit-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }
    public SearchResultsPage searchForItem(String item) {
        wait.waitForElementVisiblity(searchField).sendKeys(item);
        wait.waitForElementToBeClickable(searchButton).click();
        return new SearchResultsPage(driver);
    }
    }


