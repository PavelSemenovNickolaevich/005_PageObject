package itvdn;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MainPage {

    final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(final String query) {
        driver.findElement(By.cssSelector("#search-on-top")).click();
        driver.findElement(By.cssSelector("#search-on-top")).sendKeys(query);
        driver.findElement(By.cssSelector("#search-on-top")).sendKeys(Keys.ENTER);
    }
}
