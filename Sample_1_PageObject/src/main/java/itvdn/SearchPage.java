package itvdn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

    final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getResults() {
        return driver.findElements(By.cssSelector(".search-result"));
    }

}
