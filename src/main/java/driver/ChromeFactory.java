package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class ChromeFactory implements BrowserDriverFactory {
    @Override
    public WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return new ChromeDriver(options);
    }
}
