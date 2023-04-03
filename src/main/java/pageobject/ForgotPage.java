package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPage {
    private final By dataEmail = By.xpath("//label[contains(text(),'Email')]/../input");
    private final By recoverButton= By.xpath("//button[contains(text(),'Восстановить')]");
    private final By loginEnter = By.className("Auth_link__1fOlj");

    private final WebDriver driver;
    public ForgotPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Запоняем поле Email")
    public void setDataEmail(String email) {

        driver.findElement(dataEmail).sendKeys(email);
    }
    @Step("Нажимаем кнопку Востановить")
    public void clickRecoverButton(){
        driver.findElement(recoverButton).click();
    }
    @Step("Нажимаем кнопку Войти")
    public void clickLoginEnter(){
        driver.findElement(loginEnter).click();
    }
    @Step("Востановления пароля")
    public void recoverMethods(String email){
        setDataEmail(email);
        clickRecoverButton();
    }
}
