package TaskTwoTests;

import TaskTwoPages.HomePage;
import TaskTwoPages.PaymentMethodPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.JsonReader;

public class SeatSelectionTest {
    WebDriver driver;
    HomePage homePage;
    PaymentMethodPage paymentMethodPage;
    JsonReader testData;
    @Test
    public void seatSelectionTest(){
        homePage = new HomePage(driver);
        paymentMethodPage =
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
                        .clickBookingTripBtn()
                        .clickConfirmSeatBtn();
        Assert.assertEquals(paymentMethodPage.getPaymentMethodTitle(),"Choose an electronic payment method","Payment method title does not match expected value.");
        Assert.assertTrue(paymentMethodPage.getCurrentUrl().contains("BookingStepTwo"));
    }
    @BeforeClass
    public void precondition() {
        testData = new JsonReader("booking-data");
    }
    @BeforeMethod
    public void setUp() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        driver = new EdgeDriver(options);
        driver.navigate().to("https://go-bus.com/");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }
    @AfterMethod
    public void tearDown() {
          driver.quit();
    }


}
