import client.RegisterGenerator;
import client.User;
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
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RegisterPage;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterTest {
    WebDriver driver;
    User user;
    HomePage objhomePage;
    RegisterPage objregisterPage;
    LoginPage objloginPage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        objhomePage = new HomePage(driver);
        objhomePage.clickPersonalAccountButton();
        objloginPage = new LoginPage(driver);
        objloginPage.clickRegisterButton();
        objregisterPage = new RegisterPage(driver);

    }

    @After
    public void teardown() {
        driver.quit();
    }


    @Test
    @DisplayName("Регистрация c некорректный паролем")
    public void createUserErrorTest() {
        objregisterPage.registerMethods("Shrek", "31@example.com", "1234");
        String newGetErrorText = objregisterPage.getErrorText();
        assertThat(newGetErrorText, is("Некорректный пароль"));
    }

    @Test
    @DisplayName("Регистрация")
    public void createUserTest() {
        User user = RegisterGenerator.random();
        objregisterPage.registerMethods(user.getName(), user.getEmail(), user.getPassword());
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Вход']")));
        String newGetEnterText = objloginPage.getEnterText();
        assertThat(newGetEnterText, is("Вход"));
    }
}
