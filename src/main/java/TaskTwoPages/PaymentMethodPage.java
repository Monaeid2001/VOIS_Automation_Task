package TaskTwoPages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentMethodPage {
    WebDriver driver;
    private final By paymentMethodTitle = By.xpath("//h3[text()='Choose an electronic payment method']");
    private final By creditCardPaymentOption = By.xpath("//input[@id='credit_card']//following-sibling::span[@class='check-icon']");
    private final By walletPaymentOption = By.xpath("//input[@id='pos']//following-sibling::span[@class='check-icon']");
    private final By agreeTermsCheckbox = By.xpath("//input[@id='terms']//following-sibling::span[@class='check-icon']");
    private final By payNowBtn = By.xpath("//button[text()='Pay and Book Now']");
    public PaymentMethodPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public String getPaymentMethodTitle() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentMethodTitle)).getText();
    }
    public CreditCardPaymentPage chooseCreditCardPaymentOption() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(creditCardPaymentOption)).click();
        return new CreditCardPaymentPage(driver);
    }
    public PaymentMethodPage chooseWalletPaymentOption() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(walletPaymentOption)).click();
        return this;
    }
    public PaymentMethodPage agreeToTerms() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(agreeTermsCheckbox)).click();
        return this;
    }
    public WalletPaymentPage clickPayNowBtn() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(payNowBtn)).click();
        return new WalletPaymentPage(driver);
    }


}
