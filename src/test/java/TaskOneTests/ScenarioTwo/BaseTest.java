package TaskOneTests.ScenarioTwo;

import driver.DriverManager;
import driver.WebDriverProvider;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.taskOnePages.scenarioTwo.HomePage;
import utils.JsonReader;
import utils.PropertyReader;

public class BaseTest implements WebDriverProvider {
    protected WebDriver driver;
    protected HomePage homePage;
    protected JsonReader testData;

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
