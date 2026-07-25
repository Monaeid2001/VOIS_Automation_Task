package TaskTwoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BusSearchResultsPage {
    WebDriver driver;
    private final By chooseTripBtn = By.xpath("(//button[contains(text(),'Choose Trip')])[1]");
    private final By RemoveTripBtn = By.xpath("//button[contains(text(),'Remove Trip')]");
    private final By BookingTripBtn = By.xpath("//button[contains(text(),'Book')]");

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
    public BusSearchResultsPage clickChooseTripBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(chooseTripBtn)).click();
        return this;
    }

    public SeatsSelection clickBookingTripBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(BookingTripBtn)).click();
        return new SeatsSelection(driver);
    }
    public BusSearchResultsPage isTripSelected() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(RemoveTripBtn)).isDisplayed();
        return this;
    }


}
