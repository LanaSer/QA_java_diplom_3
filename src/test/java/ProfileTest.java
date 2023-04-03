import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;;
import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfileTest {
    private WebDriver driver;
    HomePage objHomePage;
    LoginPage objloginPage;
    ProfilePage objProfilePage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        objHomePage = new HomePage(driver);
        objHomePage.clickLogInYourAccountButton();
        objloginPage = new LoginPage(driver);
        objloginPage.login("teste@example.com", "123422");
        objHomePage.clickPersonalAccountButton();
        objProfilePage = new ProfilePage(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void exitLoginTest() {
        objProfilePage.expectationEscButton();
        objProfilePage.clickExitButton();
        objloginPage.expectationEnterText();
        String newGetEnterText = objloginPage.getEnterText();
        assertThat(newGetEnterText, is("Вход"));
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор ")
    public void transitionConstructorTest() {
        objProfilePage.expectationDesignerButton();
        objProfilePage.clickDesignerButton();
        String newDesignerText = objHomePage.getDesignerText();
        assertThat(newDesignerText, is("Соберите бургер"));
    }

    @Test
    @DisplayName("Переход из личного кабинета  по Stellar Burgers в конструктор ")
    public void stellarBurgersTest() {
        objProfilePage.expectationStellarBurgersButton();
        objProfilePage.clickDesignerButton();
        String newDesignerText = objHomePage.getDesignerText();
        assertThat(newDesignerText, is("Соберите бургер"));
    }
}
