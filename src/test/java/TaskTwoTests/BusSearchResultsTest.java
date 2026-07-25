package TaskTwoTests;

import TaskTwoPages.BusSearchResultsPage;
import TaskTwoPages.HomePage;
import TaskTwoPages.SeatsSelection;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BusSearchResultsTest {
    WebDriver driver;
    HomePage homePage;
    SeatsSelection seatsSelection;
    BusSearchResultsPage busSearchResultsPage;

    @Test
    public void testBusSearchResults() {
        homePage = new HomePage(driver);
        seatsSelection =
                homePage.chooseEnglish()
                        .clickLoginRegisterBtn()
                        .login("mona.eid.yiehia@gmail.com", "Mm@123456")
                        .chooseDepartureCity("Alexandria")
                        .chooseDepartureStation("Miamy")
                        .chooseArrivalCity("Cairo")
                        .chooseArrivalStation("Tahrir")
                        .chooseTravelDate("August 2026", "15")
                        .clickSearchBtn()
                .clickChooseTripBtn()
                .clickBookingTripBtn();
        Assert.assertTrue(seatsSelection.getDate().contains("15 Aug 2026"), "Date doesn't match expected value");
        Assert.assertTrue(seatsSelection.getCurrentUrl().contains("bookingStepOne"), "URL doesn't contain expected value");
    }

    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        driver.navigate().to("https://go-bus.com/");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }
    @AfterMethod
    public void tearDown() {
          driver.quit();
    }
}
