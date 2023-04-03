package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final By personalAccountButton = By.xpath("//p[contains(text(),'Личный')]");
    private final By logInYourAccountButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    private final By orderFeedButton = By.xpath("//p[contains(text(),'Лента')]");

    private final By designerButton = By.xpath("//*[text()='Конструктор']");
    private final By breadButton = By.xpath("//span[contains(text(),'Булки')]");
    private final By sauceButton = By.xpath("//span[contains(text(),'Соус')]");
    private final By fillingButton = By.xpath("//span[contains(text(),'Начинки')]");
    private final By designerText =By.xpath("//*[text()='Соберите бургер']");
    private final By breadText = By.xpath("//h2[contains(text(),'Булки')]");
    private final By sauceText = By.xpath("//h2[contains(text(),'Соусы')]");
    private final By fillingText = By.xpath("//h2[contains(text(),'Начинки')]");

    private final WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Нажимаем кнопку  Личный кабинет")
    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }
    @Step("Нажимаем кнопку  Войти в личный кабинет")
    public void clickLogInYourAccountButton(){
        driver.findElement(logInYourAccountButton).click();
    }
    @Step("Нажимаем кнопку 'Лента заказов'")
    public void clickOrderFeedButton(){
        driver.findElement(orderFeedButton).click();
    }
    @Step("Нажимаем кнопку  конструктор")
    public void clickDesignerButton(){
        driver.findElement(designerButton).click();
    }
    @Step("Нажимаем кнопку 'Булка'")
    public void clickBreadButton(){
        driver.findElement(breadButton).click();
    }
    @Step("Нажимаем кнопку 'Соус'")
    public void clickSauceButton(){
        driver.findElement(sauceButton).click();
    }
    @Step("Нажимаем кнопку 'Начинка'")
    public void clickFillingButton(){
        driver.findElement(fillingButton).click();
    }
    @Step("Вытаскиваем текст 'Соберите бургер'")
    public String getDesignerText(){
        return driver.findElement(designerText).getText();
    }
    @Step("Вытаскиваем текст 'Булки'")
    public String getBreadText(){
        return driver.findElement(breadText).getText();
    }
    @Step("Вытаскиваем текст 'Соусы'")
    public String getSauceText(){
        return driver.findElement(sauceText).getText();
    }

    @Step("Вытаскиваем текст 'Начинки'")
    public String getFillingText(){
        return driver.findElement(fillingText).getText();
    }

    @Step("Ожидание кнопки 'Личный Кабинет'")
    public void expectationPersonalAccount(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(personalAccountButton));
    }

}
