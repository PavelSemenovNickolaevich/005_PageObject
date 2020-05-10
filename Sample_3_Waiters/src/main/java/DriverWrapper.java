import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverWrapper {
    WebDriver driver;

    public DriverWrapper() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    public void init() {
        this.driver.get("https://itvdn.com/ru");
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void close() {
        this.driver.quit();
    }
}