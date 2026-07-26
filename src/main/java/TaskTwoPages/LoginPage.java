package TaskTwoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    private final By emailOrPhoneInput = By.xpath("//label[contains(text(),'Email or Phone Number')]/following-sibling::input");
    private final By passwordInput = By.xpath("//label[contains(text(),'Password')]/following-sibling::input");
    private final By loginSubmitBtn = By.xpath("//button[contains(text(),'Login')]");
    private final By registerBtn = By.xpath("//a[text()='Register']");
    private final By loginErrorMessage = By.xpath("//div[contains(text(),'Not Found')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage login(String emailOrPhone, String password) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailOrPhoneInput)).sendKeys(emailOrPhone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitBtn)).click();
        return new HomePage(driver);
    }
    public LoginPage loginWithInvalidCredentials(String emailOrPhone, String password) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailOrPhoneInput)).sendKeys(emailOrPhone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitBtn)).click();
        return this;
    }
    public RegisterPage clickRegisterBtn() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn)).click();
        return new RegisterPage(driver);
    }
    public String getLoginErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage)).getText();
    }
}
