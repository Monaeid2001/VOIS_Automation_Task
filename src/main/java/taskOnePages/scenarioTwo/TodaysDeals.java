package taskOnePages.scenarioTwo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TodaysDeals {
    WebDriver driver;
    private final By seeMoreButton1 = By.xpath("//span[@id='departments']/following-sibling::button/a");
    private final By GroceryButton = By.xpath("//span[contains(text(),'Grocery')]");
    private final By discountPill = By.cssSelector("button[data-testid='filter-percentOff-10-100']");
    private final By groceryPill = By.cssSelector("button[data-testid='filter-departments-16310211']");
    private final By productDetailsButton =  By.cssSelector("button[data-testid='add-to-cart-button']");
    //private final By discountValue =  By.id("percentOff-value");

    public TodaysDeals(WebDriver driver) {
        this.driver = driver;
    }
    public TodaysDeals setMinDiscount(int targetValue) {
        WebElement minDiscountInput = driver.findElement(
                By.xpath("//input[@aria-label='Minimum discount']")
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].focus();", minDiscountInput);

        minDiscountInput.sendKeys(Keys.HOME);
        for (int i = 0; i < targetValue; i++) {
            minDiscountInput.sendKeys(Keys.ARROW_RIGHT);
        }
   return this;
    }
    public TodaysDeals clickOnDepartment(){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(seeMoreButton1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(GroceryButton)).click();
        return this;
    }
    public String getDiscounttPillText(){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
      return  wait.until(ExpectedConditions.visibilityOfElementLocated(discountPill)).getText();
    }
    public String getDepartmentPillText(){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(groceryPill)).getText();
    }
    public ProductDetailsPage clickOnProductDetailsButton() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(productDetailsButton)).click();
        return new ProductDetailsPage(driver);
    }

}
