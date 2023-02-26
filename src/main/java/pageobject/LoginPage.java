package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final By dataEmail = By.xpath("//label[contains(text(),'Email')]/../input");
    private final By dataPassword = By.xpath("//input[@type='password']");
    private final By enterButton = By.xpath("//*[text()='Войти']");
    private final By registerButton = By.xpath("//*[text()='Зарегистрироваться']");
    private final By forgotPasswordButton = By.xpath("//*[text()='Восстановить пароль']");
    private final By enterText = By.xpath("//*[text()='Вход']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("метод для заполения поля email")
    public void setDataEmail(String email) {
        driver.findElement(dataEmail).sendKeys(email);
    }

    @Step("метод для заполения поля password")
    public void setDataPassword(String password) {
        driver.findElement(dataPassword).sendKeys(password);
    }

    @Step("Нажимаем кнопку Вход")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Нажимаем кнопку регистрация")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Вытаскиваем текст 'Вход'")
    public String getEnterText() {
        return driver.findElement(enterText).getText();
    }

    @Step("Нажимаем кнопку Востановить пароль")
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    @Step("Ожидание кнопки 'Вход'")
    public void expectationEnterText() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(enterText));

    }

    @Step("авторизация")
    public void login(String email, String password) {
        setDataEmail(email);
        setDataPassword(password);
        clickEnterButton();

    }

}
