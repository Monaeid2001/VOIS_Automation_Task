package TaskTwoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    private final By EmailOrPhoneInput = By.xpath("//label[contains(text(),'Email or Phone Number')]/following-sibling::input");
    private final By PasswordInput = By.xpath("//label[contains(text(),'Password')]/following-sibling::input");
    private final By LoginBtn = By.xpath("//button[contains(text(),'Login')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage login(String emailOrPhone, String password) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailOrPhoneInput)).sendKeys(emailOrPhone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordInput)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(LoginBtn)).click();
        return new HomePage(driver);
    }
}
