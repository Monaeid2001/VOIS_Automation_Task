package TaskTwoTests;

import TaskTwoPages.HomePage;
import TaskTwoPages.PaymentMethodPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeatSelectionTest {
    WebDriver driver;
    HomePage homePage;
    PaymentMethodPage paymentMethodPage;
    @Test
    public void seatSelectionTest(){
        homePage = new HomePage(driver);
        paymentMethodPage =
                homePage.chooseEnglish()
                        .clickLoginRegisterBtn()
                        .login("mona.eid.yiehia@gmail.com","Mm@123456")
                        .chooseDepartureCity("Alexandria")
                        .chooseDepartureStation("Miamy")
                        .chooseArrivalCity("Cairo")
                        .chooseArrivalStation("Tahrir")
                        .chooseTravelDate("August 2026", "15")
                        .clickSearchBtn()
                        .clickChooseTripBtn()
                        .clickBookingTripBtn()
                        .clickConfirmSeatBtn();
        Assert.assertEquals(paymentMethodPage.getPaymentMethodTitle(),"Choose an electronic payment method","Payment method title does not match expected value.");
        Assert.assertTrue(paymentMethodPage.getCurrentUrl().contains("BookingStepTwo"));
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
