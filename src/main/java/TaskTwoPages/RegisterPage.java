package TaskTwoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    WebDriver driver;
    private final By fullName = By.xpath("//label[contains(text(),'fullname')]//following-sibling::input");
    private final By phoneNumber = By.xpath("//div[@class='w-full']//input");
    private final By email = By.xpath("//label[contains(text(),'Email')]//following-sibling::input");
    private final By password = By.xpath("//label[contains(text(),'Password')]//following-sibling::input");
    private final By confirmPassword = By.xpath("//label[contains(text(),'Confirm Password')]//following-sibling::input");
    private final By registerSubmitBtn = By.xpath("//button[contains(text(),'Register')]");
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage register(String fullName, String phoneNumber, String email, String password, String confirmPassword) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.fullName)).sendKeys(fullName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.phoneNumber)).sendKeys(phoneNumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.email)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.password)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.confirmPassword)).sendKeys(confirmPassword);
        wait.until(ExpectedConditions.elementToBeClickable(registerSubmitBtn)).click();
        return new HomePage(driver);
    }
    
}
