package TaskTwoTests;

import TaskTwoPages.CreditCardPaymentPage;
import TaskTwoPages.HomePage;
import TaskTwoPages.WalletPaymentPage;
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

public class PaymentMethodTest {
    WebDriver driver;
    HomePage homePage;
    CreditCardPaymentPage creditCardPaymentPage;
    WalletPaymentPage walletPaymentPage;
    JsonReader testData;


    @Test
    public void creditCardPaymentMethodTest() {
        homePage = new HomePage(driver);
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
        homePage = new HomePage(driver);
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
