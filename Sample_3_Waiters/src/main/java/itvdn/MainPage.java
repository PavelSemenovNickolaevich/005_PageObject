package itvdn;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    @FindBy(css = "#search-on-top")
    private WebElement searchElement;

    @FindBy(css = ".hoverl_6R")
    private WebElement supportTabTrigger;

    @FindBy(css = ".inputField_2G")
    private WebElement supportTabTextBox;

    @FindBy(css = ".closeIcon_1U")
    private WebElement supportTabClose;

    @FindBy(css = ".drag_22")
    private WebElement supportTabBody;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void search(final String text) {
        searchElement.click();
        searchElement.sendKeys(text);
        searchElement.sendKeys(Keys.ENTER);
    }

    public void openSupportChat() {
        supportTabTrigger.click();

//      ExpectedConditions содержит большое количество готовых условий
        new WebDriverWait(driver, 10, 500)
                .until(ExpectedConditions.visibilityOf(supportTabBody));

//        Тем не менее у разработчика всегда есть возможность написать собственное условие для ожидания
//        new WebDriverWait(driver, 10, 500).until(webDriver -> supportTabBody.isDisplayed());

//        FluentWait это еще один способ создания Explicit wait
//        new FluentWait<>(driver)
//                .withMessage("Element was not found")
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofMillis(500))
//                .until(ExpectedConditions.visibilityOf(supportTabBody));
//
//        new FluentWait<>(driver)
//                .withMessage("Element was not found")
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofMillis(500))
//                .until(webDriver -> supportTabBody.isDisplayed());
    }

    public void typeSupportChat(final String text) {
        supportTabTextBox.sendKeys(text);
    }

    public void closeSupportChat() {
        supportTabClose.click();
    }

    public boolean isSupportChatDisplayed() {
        return supportTabBody.isDisplayed();

//         Всегда есть несколько способов получить результат
//        return !supportTabBody.getCssValue("display").equals("none");

//        return !supportTabBody.getAttribute("style").contains("display: none");
    }
}
