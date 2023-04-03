import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.ForgotPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.RegisterPage;
import pageobject.ProfilePage;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {
    private WebDriver driver;
    HomePage objHomePage;
    RegisterPage objRegisterPage;
    LoginPage objloginPage;
    ForgotPage objForgotPage;
    ProfilePage objProfilePage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        objHomePage = new HomePage(driver);
        objloginPage = new LoginPage(driver);
        objRegisterPage = new RegisterPage(driver);
        objForgotPage = new ForgotPage(driver);
        objProfilePage = new ProfilePage(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void loginHomePageTest() {
        objHomePage.clickLogInYourAccountButton();
        objloginPage.login("teste@example.com", "123422");
        objHomePage.clickPersonalAccountButton();
        objProfilePage.expectationAccount();
        String newAccountLinkText = objProfilePage.getAccountLinkText();
        assertThat(newAccountLinkText, is("Профиль"));
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»,")
    public void personalAccountButtonHomePageTest() {
        objHomePage.expectationPersonalAccount();
        objHomePage.clickPersonalAccountButton();
        objloginPage.login("teste@example.com", "123422");
        objHomePage.expectationPersonalAccount();
        objHomePage.clickPersonalAccountButton();
        objProfilePage.expectationAccount();
        String newAccountLinkText = objProfilePage.getAccountLinkText();
        assertThat(newAccountLinkText, is("Профиль"));
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void registerHomeLoginTest() {
        objHomePage.expectationPersonalAccount();
        objHomePage.clickLogInYourAccountButton();
        objloginPage.clickRegisterButton();
        objRegisterPage.clickLoginButton();
        objloginPage.login("teste@example.com", "123422");
        objHomePage.expectationPersonalAccount();
        objHomePage.clickPersonalAccountButton();
        objProfilePage.expectationAccount();
        String newAccountLinkText = objProfilePage.getAccountLinkText();
        assertThat(newAccountLinkText, is("Профиль"));
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void forgotPasswordTest() {
        objHomePage.expectationPersonalAccount();
        objHomePage.clickPersonalAccountButton();
        objloginPage.clickForgotPasswordButton();
        objForgotPage.clickLoginEnter();
        objloginPage.login("teste@example.com", "123422");
        objHomePage.expectationPersonalAccount();
        objHomePage.clickPersonalAccountButton();
        objProfilePage.expectationAccount();
        String newAccountLinkText = objProfilePage.getAccountLinkText();
        assertThat(newAccountLinkText, is("Профиль"));
    }

}
