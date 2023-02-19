import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.*;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfileTest {
    WebDriver driver;
    HomePage objHomePage;
    LoginPage objloginPage;
    ProfilePage objProfilePage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
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
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Выход']")));
        objProfilePage.clickExitButton();
        String newGetEnterText = objloginPage.getEnterText();
        assertThat(newGetEnterText, is("Вход"));
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор ")
    public void transitionConstructorTest() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.className("AppHeader_header__link__3D_hX")));
        objProfilePage.clickDesignerButton();
        String newDesignerText = objHomePage.getDesignerText();
        assertThat(newDesignerText, is("Соберите бургер"));
    }

    @Test
    @DisplayName("Переход из личного кабинета  по Stellar Burgers в конструктор ")
    public void stellarBurgersTest() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.className("AppHeader_header__logo__2D0X2")));
        objProfilePage.clickDesignerButton();
        String newDesignerText = objHomePage.getDesignerText();
        assertThat(newDesignerText, is("Соберите бургер"));
    }


}
