package TaskTwoTests;

import TaskTwoPages.BusSearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.JsonReader;

public class HomeTest extends BaseTest {
    BusSearchResultsPage busSearchResultsPage;
    @Test
    public void testHomePage() {
        busSearchResultsPage =
                homePage
                        .chooseEnglish()
                        .clickLoginRegisterBtn()
                        .login(testData.getJsonData("email"), testData.getJsonData("password"))
                        .chooseDepartureCity(testData.getJsonData("busSearch.departureCity"))
                        .chooseDepartureStation(testData.getJsonData("busSearch.departureStation"))
                        .chooseArrivalCity(testData.getJsonData("busSearch.arrivalCity"))
                        .chooseArrivalStation(testData.getJsonData("busSearch.arrivalStation"))
                        .chooseTravelDate(testData.getJsonData("busSearch.travelMonthYear"), testData.getJsonData("busSearch.travelDay"))
                        .clickSearchBtn();
        Assert.assertTrue(busSearchResultsPage.getTravelAndArrivalStations("Miamy").contains("Miamy"), "Departure station doesn't match expected value");
        Assert.assertTrue(busSearchResultsPage.getTravelAndArrivalStations("Tahrir").contains("Tahrir"), "Arrival station doesn't match expected value");

    }
    @BeforeClass
    public void precondition() {
        testData = new JsonReader("booking-data");
    }

}
