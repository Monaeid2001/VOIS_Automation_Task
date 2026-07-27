package TaskTwoTests;

import TaskTwoPages.HomePage;
import driver.DriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.JsonReader;
import utils.PropertyReader;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected JsonReader testData;
    @BeforeMethod
    public void setUp() {
        driver = DriverManager.createDriver(PropertyReader.getProperty("browser"));
        driver.navigate().to(PropertyReader.getProperty("baseUrl"));
        driver.manage().window().setSize(new Dimension(1024, 768));
        homePage = new HomePage(driver);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
