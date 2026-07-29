package TaskTwoTests;

import TaskTwoPages.PaymentMethodPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.JsonReader;

public class SeatSelectionTest extends BaseTest {
    PaymentMethodPage paymentMethodPage;
    @Test
    public void seatSelectionTest(){
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



}
