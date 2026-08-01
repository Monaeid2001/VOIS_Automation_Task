package pages.taskOnePages.scenarioTwo;

import org.openqa.selenium.*;
import utils.WaitUtils;

public class HomePage {
   private final WebDriver driver;
   private final WaitUtils wait;
   private final By TodaysDealsButton = By.xpath("//a[contains(text(),\"Today's Deals\")]");
    private final By DismissButton = By.xpath("//span[contains(text(),'Dismiss')]/preceding-sibling::input");
    private final By continueShoppingButton = By.xpath("//button[contains(text(),'Continue shopping')]");


    public HomePage(WebDriver driver) {
       this.driver = driver;
       wait = new WaitUtils(driver);
   }
    public HomePage dismissContinueShoppingPageIfPresent() {
        try {
            wait.waitForElementToBeClickable(continueShoppingButton).click();
        } catch (TimeoutException e) {
            System.out.println(" Continue shopping button not present, proceeding without clicking.");
        }
        return this;
    }
   public TodaysDealsPage clickOnTodaysDeals() {
       wait.waitForElementToBeClickable(TodaysDealsButton).click();
       return new TodaysDealsPage(driver);
   }

    public HomePage ClickOnDismissButton() {
        try {
            wait.waitForElementToBeClickable(DismissButton).click();
        } catch (TimeoutException e) {
            System.out.println("no pop up appears");
        }
        return this;
    }

}



