package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourAccountPage {

    private WebDriver driver;

    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By settingslocator = By.xpath("//span[contains(text(),'Settings')]");

    public SettingsPage clickOnProfileLink (){
        driver.findElement(settingslocator).click();
        return new SettingsPage(driver);
    }
}
