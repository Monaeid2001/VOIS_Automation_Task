package TaskTwoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    private final By loginRegisterBtn = By.xpath("//div[@class='login-button']/a");
    private final By EnglishBtn = By.xpath("//button[text()='English']");
    private final By departureCity = By.xpath("//label[text()='Travel from City']/following-sibling::div");
    private final By departureStation = By.xpath("//label[text()='Travel from Station']/following-sibling::div");
    private final By inputField = By.xpath("//input[@class='search-inputs']");
    private final By arrivalCity = By.xpath("//label[text()='Travel to City']/following-sibling::div");
    private final By arrivalStation = By.xpath("//label[text()='Travel to Station']/following-sibling::div");
    private final By travelDate= By.xpath("//label[text()='Travel Date']/following-sibling::div");
    private final By submitTravelBtn = By.xpath("//button[contains(text(),'Show Go Bus Trips')]");
    private final By chooseDate= By.cssSelector("input[placeholder='Choose Date']");
    private final By calenderHeader = By.className("react-datepicker__current-month");
    private final By nextMonthBtn = By.cssSelector("button[aria-label='Next Month']");
    private final By myAccountBtn = By.xpath("//div[text()='My Account']");

    private By getOptionLocator(String value) {
        return By.xpath("//li[contains(text(),'"+value+"')]");
    }
    private By selectDay(String day) {
        return By.xpath("//div[@aria-disabled='false' and text()='"+day+"']");
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginRegisterBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        int attempts = 0;
        while (attempts < 3) {
            try {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.elementToBeClickable(loginRegisterBtn))
                        .click();
                return new LoginPage(driver);
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        throw new RuntimeException("Failed to click element after retries: " + loginRegisterBtn);
    }

    public HomePage chooseEnglish(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.elementToBeClickable(EnglishBtn)
        ).click();
        return this;
    }
    public HomePage chooseDepartureCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.elementToBeClickable(departureCity)
        ).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(inputField)
        ).sendKeys(city);
        wait.until(
                ExpectedConditions.elementToBeClickable(getOptionLocator(city))
        ).click();
        return this;
    }
    public HomePage chooseDepartureStation(String station) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.elementToBeClickable(departureStation)
        ).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(inputField)
        ).sendKeys(station);
        wait.until(
                ExpectedConditions.elementToBeClickable(getOptionLocator(station))
        ).click();
        return this;
    }
    public HomePage chooseArrivalCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.elementToBeClickable(arrivalCity)
        ).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(inputField)
        ).sendKeys(city);
        wait.until(
                ExpectedConditions.elementToBeClickable(getOptionLocator(city))
        ).click();
        return this;
    }
    public HomePage chooseArrivalStation(String station) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.elementToBeClickable(arrivalStation)
        ).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(inputField)
        ).sendKeys(station);
        wait.until(
                ExpectedConditions.elementToBeClickable(getOptionLocator(station))
        ).click();
        return this;
    }
    public HomePage chooseTravelDate(String monthYear, String day){
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       wait.until(
                ExpectedConditions.elementToBeClickable(chooseDate)
        ).click();
        while (!wait.until(ExpectedConditions.visibilityOfElementLocated(calenderHeader)).getText().contains(monthYear)){
            wait.until(
                    ExpectedConditions.elementToBeClickable(nextMonthBtn)
            ).click();
        }
        wait.until(
                ExpectedConditions.elementToBeClickable(selectDay(day))
        ).click();
        return this;
    }
    public BusSearchResultsPage clickSearchBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.elementToBeClickable(submitTravelBtn)
        ).click();
        return new BusSearchResultsPage(driver);
    }
    public boolean isAccountDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      return  wait.until(
                ExpectedConditions.visibilityOfElementLocated(myAccountBtn)
        ).isDisplayed();
    }



}
