package TaskTwoTests;

import TaskTwoPages.BusSearchResultsPage;
import TaskTwoPages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest {
    WebDriver driver;
    HomePage homePage;
    BusSearchResultsPage busSearchResultsPage;

    @Test
    public void testHomePage() {
        homePage = new HomePage(driver);
        busSearchResultsPage=
                homePage
                .chooseEnglish()
                .chooseDepartureCity("Alexandria")
                .chooseDepartureStation("Miamy")
                .chooseArrivalCity("Cairo")
                .chooseArrivalStation("Tahrir")
                .chooseTravelDate("August 2026", "15")
                .clickSearchBtn();
        Assert.assertTrue(busSearchResultsPage.getTravelAndArrivalStations("Miamy").contains("Miamy"), "Departure station doesn't match expected value");
        Assert.assertTrue(busSearchResultsPage.getTravelAndArrivalStations("Tahrir").contains("Tahrir"), "Arrival station doesn't match expected value");

    }
    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        driver.navigate().to("https://go-bus.com/");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }
    @AfterMethod
    public void tearDown() {
      //  driver.quit();
    }
}
