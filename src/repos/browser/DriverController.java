package repos.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverController {

    private static WebDriver driver;

    private DriverController() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            new DriverController();
        }

        return driver;
    }
}
