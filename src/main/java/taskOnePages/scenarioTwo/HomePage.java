package taskOnePages.scenarioTwo;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
   private final WebDriver driver;
   private final By TodaysDealsButton = By.xpath("//a[contains(text(),\"Today's Deals\")]");
    private final By DismissButton = By.xpath("//span[contains(text(),'Dismiss')]/preceding-sibling::input");

   public HomePage(WebDriver driver) {
       this.driver = driver;
   }
   public TodaysDeals clickOnTodaysDeals() {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       wait.until(ExpectedConditions.elementToBeClickable(TodaysDealsButton)).click();
       return new TodaysDeals(driver);
   }

    public HomePage ClickOnDismissButton() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.elementToBeClickable(DismissButton)).click();
        } catch (TimeoutException e) {
            System.out.println("no pop up appears");
        }
        return this;
    }

}



