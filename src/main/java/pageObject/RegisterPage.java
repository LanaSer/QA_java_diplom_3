package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final By dataName = By.xpath("//fieldset[1]/div/div/input");
    private final By dataEmail = By.xpath("//fieldset[2]/div/div/input");
    private final By dataPassword = By.xpath("//fieldset[3]/div/div/input");
    private final By registerButton = By.xpath("//form/button");
    private final By loginButton = By.xpath("//div/div/p/a");
    private final By errorText = By.xpath("//form/fieldset[3]/div/p");

    private final WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setDataName(String name) {

        driver.findElement(dataName).sendKeys(name);
    }
    public void setDataEmail(String email) {

        driver.findElement(dataEmail).sendKeys(email);
    }
    public void setDataPassword(String password){

        driver.findElement(dataPassword).sendKeys(password);
    }
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public String getErrorText(){
        return driver.findElement(errorText).getText();
    }
    public void registerMethods(String name, String email,String password){
        setDataName(name);
        setDataEmail(email);
        setDataPassword(password);
        clickRegisterButton();
    }
}
