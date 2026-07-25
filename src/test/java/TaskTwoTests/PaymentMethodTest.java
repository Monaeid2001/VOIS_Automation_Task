package TaskTwoTests;

import TaskTwoPages.CreditCardPaymentPage;
import TaskTwoPages.HomePage;
import TaskTwoPages.WalletPaymentPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PaymentMethodTest {
    WebDriver driver;
    HomePage homePage;
    CreditCardPaymentPage creditCardPaymentPage;
    WalletPaymentPage walletPaymentPage;


    @Test
    public void creditCardPaymentMethodTest() {
        homePage = new HomePage(driver);
        creditCardPaymentPage =
                homePage.chooseEnglish()
                        .clickLoginRegisterBtn()
                        .login("monaeid5858@gmail.com", "Mm@123456")
                        .chooseDepartureCity("Alexandria")
                        .chooseDepartureStation("Miamy")
                        .chooseArrivalCity("Cairo")
                        .chooseArrivalStation("Tahrir")
                        .chooseTravelDate("August 2026", "15")
                        .clickSearchBtn()
                        .clickChooseTripBtn()
                        .clickBookingTripBtn()
                        .clickConfirmSeatBtn()
                        .chooseCreditCardPaymentOption()
                        .enterCreditCardDetails("5555 5555 5555 4444","Tester","12","2027","123")
                        .acceptTermsAndConditions();
        Assert.assertEquals(creditCardPaymentPage.getCreditCardPaymentHeader(), "Credit Cards", "Credit card payment header does not match expected value.");

    }
    @Test
    public void walletPaymentMethodTest() {
        homePage = new HomePage(driver);
        walletPaymentPage =
        homePage.chooseEnglish()
                .clickLoginRegisterBtn()
                .login("monaeid5858@gmail.com","Mm@123456")
                .chooseDepartureCity("Alexandria")
                .chooseDepartureStation("Miamy")
                .chooseArrivalCity("Cairo")
                .chooseArrivalStation("Tahrir")
                .chooseTravelDate("August 2026", "15")
                .clickSearchBtn()
                .clickChooseTripBtn()
                .clickBookingTripBtn()
                .clickConfirmSeatBtn()
                .chooseWalletPaymentOption()
                .agreeToTerms()
                .clickPayNowBtn();
        Assert.assertTrue(walletPaymentPage.getBookingCode().contains("Booking Code"), "Booking code is not displayed.");

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
