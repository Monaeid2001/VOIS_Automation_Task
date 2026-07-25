package TaskTwoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WalletPaymentPage {
    WebDriver driver;
    private final By bookingCode = By.xpath("//div[contains(text(),'Booking Code')]");
    public WalletPaymentPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getBookingCode() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(bookingCode)).getText();
    }
}
