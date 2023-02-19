package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final By dataEmail = By.xpath("//fieldset[1]/div/div/input");
    private final By dataPassword = By.xpath("//fieldset[2]/div/div/input");
    private final By enterButton = By.xpath("//main/div/form/button");
    private final By registerButton = By.xpath("//main/div/div/p[1]/a");
    private final By forgotPasswordButton = By.xpath("//main/div/div/p[2]/a");
    private final By enterText = By.xpath("//*[text()='Вход']");

    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setDataEmail(String email) {

        driver.findElement(dataEmail).sendKeys(email);
    }
    public void setDataPassword(String email){

        driver.findElement(dataPassword).sendKeys(email);
    }
    public void clickEnterButton(){
        driver.findElement(enterButton).click();
    }
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }
    public String getEnterText(){
        return driver.findElement(enterText).getText();
    }
    public void clickForgotPasswordButton(){
        driver.findElement(forgotPasswordButton).click();
    }
    public void login(String email, String password) {
        setDataEmail(email);
        setDataPassword(password);
        clickEnterButton();

    }

}
