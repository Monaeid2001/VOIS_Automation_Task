package TaskTwoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BusSearchResultsPage {
    WebDriver driver;

    private By travelAndArrivalStations(String station) {
        return By.xpath("//p[contains(text(),'"+station+"')]");
    }
    public BusSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTravelAndArrivalStations(String station) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         return wait.until(
                 ExpectedConditions.visibilityOfElementLocated(travelAndArrivalStations(station))
         ).getText();
    }
}
