package TaskTwoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;



public class BusSearchResultsPage {
    WebDriver driver;
    private final WaitUtils wait;
    private final By chooseTripBtn = By.xpath("(//button[contains(text(),'Choose Trip')])[1]");
    private final By RemoveTripBtn = By.xpath("//button[contains(text(),'Remove Trip')]");
    private final By BookingTripBtn = By.xpath("//button[contains(text(),'Book')]");

    private By travelAndArrivalStations(String station) {

        return By.xpath("//p[contains(text(),'"+station+"')]");
    }
    public BusSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }
    public String getTravelAndArrivalStations(String station) {
         return wait.waitForElementVisiblity(travelAndArrivalStations(station)).getText();
    }
    public BusSearchResultsPage clickChooseTripBtn() {
        wait.waitForElementToBeClickable(chooseTripBtn).click();
        return this;
    }

    public SeatsSelection clickBookingTripBtn() {
        wait.waitForElementToBeClickable(BookingTripBtn).click();
        return new SeatsSelection(driver);
    }
    public BusSearchResultsPage isTripSelected() {
        wait.waitForElementVisiblity(RemoveTripBtn).isDisplayed();
        return this;
    }


}
