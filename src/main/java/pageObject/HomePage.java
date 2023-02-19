package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final By personalAccountButton = By.xpath("//nav/a/p");
    private final By logInYourAccountButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    private final By orderFeedButton = By.xpath("//nav/ul/li[2]/a/p");

    private final By designerButton = By.xpath("//nav/ul/li[1]/a");
    private final By breadButton = By.xpath("//section[1]/div[1]/div[1]");
    private final By sauceButton = By.xpath("//section[1]/div[1]/div[2]");
    private final By fillingButton = By.xpath("//section[1]/div[1]/div[3]");
    private final By designerText =By.xpath("//*[text()='Соберите бургер']");
    private final By breadText = By.xpath("//section[1]/div[2]/h2[1]");
    private final By sauceText = By.xpath("//section[1]/div[2]/h2[2]");
    private final By fillingText = By.xpath("//section[1]/div[2]/h2[3]");

    private final WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickPersonalAccountButton(){// метод для кнопки "Личный кабинет"
        driver.findElement(personalAccountButton).click();
    }
    public void clickLogInYourAccountButton(){ // метод для кнопки "Войти в личный кабинет"
        driver.findElement(logInYourAccountButton).click();
    }
    public void clickOrderFeedButton(){// метод для кнопки "Лента заказов"
        driver.findElement(orderFeedButton).click();
    }
    public void clickDesignerButton(){
        driver.findElement(designerButton).click();
    }  public void clickBreadButton(){// метод для кнопки "булка"
        driver.findElement(breadButton).click();
    }
    public void clickSauceButton(){ // метод для кнопки "Соус"
        driver.findElement(sauceButton).click();
    }
    public void clickFillingButton(){ // метод для кнопки "Начинка"
        driver.findElement(fillingButton).click();
    }

    public String getDesignerText(){
        return driver.findElement(designerText).getText();
    }
    public String getBreadText(){ //метод для вытаскивания текста  "Булки"
        return driver.findElement(breadText).getText();
    }
    public String getSauceText(){ //метод для вытаскивания текста  "Соусы"
        return driver.findElement(sauceText).getText();
    }
    public String getFillingText(){ //метод для вытаскивания текста  "Начинки"
        return driver.findElement(fillingText).getText();
    }
}
