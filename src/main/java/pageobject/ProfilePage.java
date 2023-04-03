package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public final By accountLink = By.xpath("//*[text()='Профиль']");
    public final By accountOrder = By.xpath("//*[text()='История заказов']");
    public final By exitButton = By.xpath("//*[text()='Выход']");
    private final By designerButton = By.xpath("//*[text()='Конструктор']");
    private final By stellarBurgersButton = By.className("AppHeader_header__logo__2D0X2");


    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаем кнопку Выход")
    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    @Step("Нажимаем кнопку'Профиль'")
    public String getAccountLinkText() {
        return driver.findElement(accountLink).getText();
    }

    @Step("Нажимаем кнопку конструктор")
    public void clickDesignerButton() {
        driver.findElement(designerButton).click();
    }

    @Step("Нажимаем кнопку StellarBurger")
    public void clickStellarBurgersButton() {
        driver.findElement(stellarBurgersButton).click();
    }

    @Step("Ожидание кнопки 'Выход'")
    public void expectationEscButton() {
        new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.visibilityOfElementLocated(exitButton));
    }

    @Step("Ожидание кнопки 'Конструктор'")
    public void expectationDesignerButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(designerButton));
    }

    @Step("Ожидание кнопки 'Stellar Burgers'")
    public void expectationStellarBurgersButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(stellarBurgersButton));
    }

    @Step("Ожидание кнопки 'Профиль'")
    public void expectationAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(accountLink));
    }

}
