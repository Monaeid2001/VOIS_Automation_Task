package TaskTwoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreditCardPaymentPage {
    WebDriver driver;
    private final By creditCardPaymentHeader = By.xpath("//span[contains(text(),'Credit Cards')]");
    private final By creditCardNumberField= By.cssSelector("iframe.gw-proxy-number");
    private final By nameOnCardField= By.cssSelector("iframe.gw-proxy-nameOnCard");
    private final By expiryMonthField = By.cssSelector("iframe.gw-proxy-expiryMonth");
    private final By expiryYearField = By.cssSelector("iframe.gw-proxy-expiryYear");
    private final By cvvField = By.cssSelector("iframe.gw-proxy-securityCode");
    private final By acceptTermsCheckbox = By.id("ChkAccept");
    private final By inputInsideFrame= By.tagName("input");
    public CreditCardPaymentPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getCreditCardPaymentHeader() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardPaymentHeader)).getText();
    }
    public void switchToFrameAndEnterText(By frameLocator,String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputInsideFrame)).sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public CreditCardPaymentPage enterCreditCardDetails(String cardNumber, String nameOnCard, String expiryMonth, String expiryYear, String cvv) {
        switchToFrameAndEnterText(creditCardNumberField, cardNumber);
        switchToFrameAndEnterText(nameOnCardField, nameOnCard);
        switchToFrameAndEnterText(expiryMonthField, expiryMonth);
        switchToFrameAndEnterText(expiryYearField, expiryYear);
        switchToFrameAndEnterText(cvvField, cvv);
        return this;
    }
    public CreditCardPaymentPage acceptTermsAndConditions() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(acceptTermsCheckbox)).click();
        return this;
    }

}
