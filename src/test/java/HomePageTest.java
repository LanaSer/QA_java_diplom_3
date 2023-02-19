import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.HomePage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageTest {
    WebDriver driver;
    HomePage objHomePage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        objHomePage = new HomePage(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Булки")
    public void breadTest() {
        objHomePage.clickFillingButton();
        objHomePage.clickBreadButton();
        String newBreadText = objHomePage.getBreadText();
        assertThat(newBreadText, is("Булки"));
    }

    @Test
    @DisplayName("Соусы")
    public void sauceTest() {
        objHomePage.clickSauceButton();
        String newSauceText = objHomePage.getSauceText();
        assertThat(newSauceText, is("Соусы"));
    }

    @Test
    @DisplayName("Начинки")
    public void fillingTest() {
        objHomePage.clickSauceButton();
        String newFillingText = objHomePage.getFillingText();
        assertThat(newFillingText, is("Начинки"));
    }
}
