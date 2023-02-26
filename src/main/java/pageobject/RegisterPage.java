package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final By dataName = By.xpath("//label[contains(text(),'Имя')]/../input");
    private final By dataEmail = By.xpath("//label[contains(text(),'Email')]/../input");
    private final By dataPassword = By.xpath("//input[@type='password']");
    private final By registerButton = By.xpath("//*[text()='Зарегистрироваться']");
    private final By loginButton = By.xpath("//*[text()='Войти']");
    private final By errorText = By.xpath("//*[text()='Некорректный пароль']");

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDataName(String name) {

        driver.findElement(dataName).sendKeys(name);
    }

    @Step("Запоняем поле Email")
    public void setDataEmail(String email) {

        driver.findElement(dataEmail).sendKeys(email);
    }

    @Step("Запоняем поле password")
    public void setDataPassword(String password) {
        driver.findElement(dataPassword).sendKeys(password);
    }

    @Step("Нажимаем кнопку Регитсрация")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Нажимаем кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Вытаскиваем текст ошибки")
    public String getErrorText() {
        return driver.findElement(errorText).getText();
    }

    @Step("Регитсрация")
    public void registerMethods(String name, String email, String password) {
        setDataName(name);
        setDataEmail(email);
        setDataPassword(password);
        clickRegisterButton();
    }
}
