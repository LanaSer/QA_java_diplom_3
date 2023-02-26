package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPage {
    private final By dataEmail = By.xpath("//fieldset/div/div/input");
    private final By recoverButton= By.xpath("//div/form/button");
    private final By loginEnter = By.className("Auth_link__1fOlj");

    private final WebDriver driver;
    public ForgotPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setDataEmail(String email) {  // метод для запонения поля "Email"

        driver.findElement(dataEmail).sendKeys(email);
    }
    public void clickRecoverButton(){
        driver.findElement(recoverButton).click();
    }
    public void clickLoginEnter(){
        driver.findElement(loginEnter).click();
    }
    public void recoverMethods(String email){
        setDataEmail(email);
        clickRecoverButton();
    }
}
