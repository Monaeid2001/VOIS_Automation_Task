package TaskOneTests.ScenarioOne;

import driver.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import pages.taskOnePages.scenarioOne.HomePage;
import utils.JsonReader;

public class BaseTest implements WebDriverProvider {
    protected WebDriver driver;
    protected HomePage homePage;
    protected JsonReader testData;

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
     }


