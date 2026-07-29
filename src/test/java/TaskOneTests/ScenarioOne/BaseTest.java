package TaskOneTests.ScenarioOne;

import driver.DriverManager;
import driver.WebDriverProvider;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import taskOnePages.scenarioOne.HomePage;
import utils.JsonReader;
import utils.PropertyReader;

public class BaseTest implements WebDriverProvider {
    protected WebDriver driver;
    protected HomePage homePage;
    protected JsonReader testData;

    @BeforeMethod
    public void setUp() {
         driver = DriverManager.createDriver(PropertyReader.getProperty("browser"));
         driver.navigate().to(PropertyReader.getProperty("baseUrl2"));
         driver.manage().window().setSize(new Dimension(1024, 768));
         homePage = new HomePage(driver);
     }
     @AfterMethod
    public void tearDown() {
         driver.quit();
     }
    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
     }


