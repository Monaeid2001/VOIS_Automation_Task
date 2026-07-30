package pages.taskOnePages.scenarioTwo;

import org.openqa.selenium.*;
import utils.WaitUtils;

public class TodaysDealsPage {
    WebDriver driver;
    private final WaitUtils wait;
    private final By seeMoreButton1 = By.xpath("//span[@id='departments']/following-sibling::button/a");
    private final By GroceryButton = By.xpath("//span[contains(text(),'Grocery')]");
    private final By discountPill = By.id("percentOff-value");
    private final By groceryPill = By.cssSelector("button[data-testid='filter-departments-16310211']");
    private final By productDetailsButton =  By.cssSelector("button[data-testid='add-to-cart-button']");
    //private final By discountValue =  By.id("percentOff-value");

    public TodaysDealsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }
    public TodaysDealsPage setMinDiscount(int targetValue) {
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
    public TodaysDealsPage clickOnDepartment(){
        wait.waitForElementToBeClickable(seeMoreButton1).click();
        wait.waitForElementToBeClickable(GroceryButton).click();
        return this;
    }
    public String getDiscounttPillText(){
      return  wait.waitForElementVisiblity(discountPill).getText();
    }
    public String getDepartmentPillText(){
        return  wait.waitForElementVisiblity(groceryPill).getText();
    }
    public ProductDetailsPage clickOnProductDetailsButton() {
        wait.waitForElementToBeClickable(productDetailsButton).click();
        return new ProductDetailsPage(driver);
    }

}
