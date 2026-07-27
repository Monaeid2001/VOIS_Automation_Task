package TaskTwoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class PaymentMethodPage {
    WebDriver driver;
    private final WaitUtils wait;
    private final By paymentMethodTitle = By.xpath("//h3[text()='Choose an electronic payment method']");
    private final By creditCardPaymentOption = By.xpath("//input[@id='credit_card']//following-sibling::span[@class='check-icon']");
    private final By walletPaymentOption = By.xpath("//input[@id='pos']//following-sibling::span[@class='check-icon']");
    private final By agreeTermsCheckbox = By.xpath("//input[@id='terms']//following-sibling::span[@class='check-icon']");
    private final By payNowBtn = By.xpath("//button[text()='Pay and Book Now']");
    public PaymentMethodPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public String getPaymentMethodTitle() {
        return wait.waitForElementVisiblity(paymentMethodTitle).getText();
    }
    public CreditCardPaymentPage chooseCreditCardPaymentOption() {
        wait.waitForElementToBeClickable(creditCardPaymentOption).click();
        return new CreditCardPaymentPage(driver);
    }
    public PaymentMethodPage chooseWalletPaymentOption() {
        wait.waitForElementToBeClickable(walletPaymentOption).click();
        return this;
    }
    public PaymentMethodPage agreeToTerms() {
        wait.waitForElementToBeClickable(agreeTermsCheckbox).click();
        return this;
    }
    public WalletPaymentPage clickPayNowBtn() {
        wait.waitForElementToBeClickable(payNowBtn).click();
        return new WalletPaymentPage(driver);
    }


}
