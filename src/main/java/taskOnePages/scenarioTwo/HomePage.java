package taskOnePages.scenarioTwo;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;

public class HomePage {
   private final WebDriver driver;
   private final WaitUtils wait;
   private final By TodaysDealsButton = By.xpath("//a[contains(text(),\"Today's Deals\")]");
    private final By DismissButton = By.xpath("//span[contains(text(),'Dismiss')]/preceding-sibling::input");

   public HomePage(WebDriver driver) {
       this.driver = driver;
       wait = new WaitUtils(driver);
   }
   public TodaysDeals clickOnTodaysDeals() {
       wait.waitForElementToBeClickable(TodaysDealsButton).click();
       return new TodaysDeals(driver);
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



