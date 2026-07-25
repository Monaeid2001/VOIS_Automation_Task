package TaskTwoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeatsSelection {
    WebDriver driver;
    private final By yourSeat=By.xpath("//h5[contains(text(),'Your Seat')]");
    private final By time = By.xpath("//p[@class='time']");
    private final By date = By.xpath("//p[@class='date']");
    private final By confirmSeatBtn = By.xpath("//div[@class='hide-tablet']//button[contains(text(),'Confirm Seats')]");

    public SeatsSelection(WebDriver driver) {
            this.driver = driver;
    }
    public boolean isYourSeatDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
       return wait.until(ExpectedConditions.visibilityOfElementLocated(yourSeat)).isDisplayed();
    }
    public String getTime() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(time)).getText();
    }
    public String getDate() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(date)).getText();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public PaymentMethodPage clickConfirmSeatBtn() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(confirmSeatBtn)).click();
        return new PaymentMethodPage(driver);
    }
}
