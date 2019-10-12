package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage {

    private WebDriver driver;

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By editlocator = By.xpath("//div[@id='Display name-field']//span[@class='link__text'][contains(text(),'Edit')]");
    private By visualnamelocator = By.xpath("/span[@id='idcta-username']");

    public EditSettingsPage clickOnEditNameButton(){
        driver.findElement(editlocator).click();
        return new EditSettingsPage(driver);
    }

    public boolean yourProfileNameIsDisplayed(){
        driver.findElement(visualnamelocator).isDisplayed();
        return true;
    }
}
