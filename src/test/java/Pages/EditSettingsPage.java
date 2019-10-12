package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditSettingsPage {

    private WebDriver driver;

    public EditSettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By changenamelocator = By.xpath("//input[@id='displayName-input']");
    private By savebuttonlocator = By.xpath("//button[@class='button']");

    public EditSettingsPage fillNewName(String newName){
        driver.findElement(changenamelocator).clear();
        driver.findElement(changenamelocator).sendKeys(newName);
        return this;
    }

    public SettingsPage clickOnSaveButton (){
        driver.findElement(savebuttonlocator).click();
        return new SettingsPage(driver);
    }

    public SettingsPage completeEditingNewName(String newName){
        fillNewName(newName);
        clickOnSaveButton();
        return new SettingsPage(driver);
    }
}
