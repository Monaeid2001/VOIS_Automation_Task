package TaskTwoTests;

import TaskTwoPages.BusSearchResultsPage;
import TaskTwoPages.HomePage;
import TaskTwoPages.SeatsSelection;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.JsonReader;

public class BusSearchResultsTest {
    WebDriver driver;
    HomePage homePage;
    SeatsSelection seatsSelection;
    JsonReader testData;

    @Test
    public void testBusSearchResults() {
        homePage = new HomePage(driver);
        seatsSelection =
                homePage.chooseEnglish()
                        .clickLoginRegisterBtn()
                        .login(testData.getJsonData("email"), testData.getJsonData("password"))
                        .chooseDepartureCity(testData.getJsonData("busSearch.departureCity"))
                        .chooseDepartureStation(testData.getJsonData("busSearch.departureStation"))
                        .chooseArrivalCity(testData.getJsonData("busSearch.arrivalCity"))
                        .chooseArrivalStation(testData.getJsonData("busSearch.arrivalStation"))
                        .chooseTravelDate(testData.getJsonData("busSearch.travelMonthYear"), testData.getJsonData("busSearch.travelDay"))
                        .clickSearchBtn()
                .clickChooseTripBtn()
                .clickBookingTripBtn();
        Assert.assertTrue(seatsSelection.getDate().contains("15 Aug 2026"), "Date doesn't match expected value");
        Assert.assertTrue(seatsSelection.getCurrentUrl().contains("bookingStepOne"), "URL doesn't contain expected value");
    }
    @BeforeClass
    public void precondition() {
        testData = new JsonReader("booking-data");
    }

    @BeforeMethod
    public void setUp() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new EdgeDriver(options);
        driver.navigate().to("https://go-bus.com/");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }
    @AfterMethod
    public void tearDown() {
          driver.quit();
    }
}
