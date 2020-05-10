package itvdn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    @FindBy(css = ".search-result")
    List<WebElement> searchResultElements;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getResults() {
        return searchResultElements;
    }
}
