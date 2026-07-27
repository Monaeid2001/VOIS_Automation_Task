package TaskTwoTests;

import TaskTwoPages.CreditCardPaymentPage;
import TaskTwoPages.HomePage;
import TaskTwoPages.WalletPaymentPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.JsonReader;

public class PaymentMethodTest extends BaseTest {
    CreditCardPaymentPage creditCardPaymentPage;
    WalletPaymentPage walletPaymentPage;

    @Test
    public void creditCardPaymentMethodTest() {
        creditCardPaymentPage =
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
                        .clickConfirmSeatBtn()
                        .chooseCreditCardPaymentOption()
                        .enterCreditCardDetails(testData.getJsonData("card.number"), testData.getJsonData("card.name"), testData.getJsonData("card.expiryMonth"), testData.getJsonData("card.expiryYear"),testData.getJsonData("card.cvv"))
                        .acceptTermsAndConditions();
        Assert.assertEquals(creditCardPaymentPage.getCreditCardPaymentHeader(), "Credit Cards", "Credit card payment header does not match expected value.");

    }
    @Test
    public void walletPaymentMethodTest() {
        walletPaymentPage =
        homePage.chooseEnglish()
                .clickLoginRegisterBtn()
                .login(testData.getJsonData("email"), testData.getJsonData("password"))
                .chooseDepartureCity(testData.getJsonData("busSearch.departureCity"))
                .chooseDepartureStation(testData.getJsonData("busSearch.departureStation"))
                .chooseArrivalCity(testData.getJsonData("busSearch.arrivalCity"))
                .chooseArrivalStation(testData.getJsonData("busSearch.arrivalStation"))
                .chooseTravelDate(testData.getJsonData("busSearch.travelMonthYear"),  testData.getJsonData("busSearch.travelDay"))
                .clickSearchBtn()
                .clickChooseTripBtn()
                .clickBookingTripBtn()
                .clickConfirmSeatBtn()
                .chooseWalletPaymentOption()
                .agreeToTerms()
                .clickPayNowBtn();
        Assert.assertTrue(walletPaymentPage.getBookingCode().contains("Booking Code"), "Booking code is not displayed.");

    }
    @BeforeClass
    public void precondition() {
        testData = new JsonReader("payment-data");
    }


}
