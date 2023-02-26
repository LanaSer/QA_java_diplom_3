package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.profiler.model.Profile;

public class ProfilePage {
    public final By accountLink = By.xpath("//div/nav/ul/li[1]/a");
    public final By accountOrder = By.xpath("//div/nav/ul/li[2]/a");
    public final By exitButton = By.xpath("//nav/ul/li[3]/button");
    private final By designerButton = By.xpath("//nav/ul/li[1]/a");
    private final By stellarBurgersButton = By.className("AppHeader_header__logo__2D0X2");


    private final WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }
    public String getAccountLinkText(){
        return driver.findElement(accountLink).getText();
    }
    public void clickDesignerButton(){
        driver.findElement(designerButton).click();
    }
    public void clickStellarBurgersButton(){
        driver.findElement(stellarBurgersButton).click();
    }


}
