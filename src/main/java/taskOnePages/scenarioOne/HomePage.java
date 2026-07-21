package taskOnePages.scenarioOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {

    private WebDriver driver;
    private By searchField = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public SearchResultsPage searchForItem(String item) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        try {
//            wait.until(driver1 -> driver1.findElement(searchField )).sendKeys(item);
//            wait.until(driver1 -> driver1.findElement(searchButton)).click();
//        } catch (Exception e) {
//            System.out.println("couldn't find product element" + e);
//        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(item);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return new SearchResultsPage(driver);
    }
//    @Test
//    public void searchForCarAccessory() {
//        // Implement the logic to search for a car accessory
//        driver = new EdgeDriver();
//        driver.get("https://www.amazon.eg/"); // Replace with the actual URL
//        driver.manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement searchBox = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        By.id("twotabsearchtextbox")));
//
//        searchBox.sendKeys("car accessories");
//        driver.findElement(By.id("nav-search-submit-button")).click();
//        driver.quit();
    }


