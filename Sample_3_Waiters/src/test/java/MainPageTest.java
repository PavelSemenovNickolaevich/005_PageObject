import itvdn.MainPage;
import itvdn.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

class MainPageTest {

    final DriverWrapper driverWrapper = new DriverWrapper();

    @BeforeEach
    void setUp() {
        driverWrapper.init();
    }

    @AfterEach
    void tearDown() {
        driverWrapper.close();
    }

    @Test
    void search() {
        MainPage mainPage = new MainPage(driverWrapper.getDriver());
        mainPage.search("QA");
        SearchPage searchPage = new SearchPage(driverWrapper.getDriver());
        List<WebElement> results = searchPage.getResults();
        Assertions.assertEquals(10, results.size());
    }

    @Test
    void requestOnlineSupport() {
        MainPage mainPage = new MainPage(driverWrapper.getDriver());
        mainPage.openSupportChat();
        mainPage.typeSupportChat("HELP ME PLEASE!!!");
        mainPage.closeSupportChat();
        Assertions.assertFalse(mainPage.isSupportChatDisplayed(),"");
    }
}