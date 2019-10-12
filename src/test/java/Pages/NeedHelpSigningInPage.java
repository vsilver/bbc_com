package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NeedHelpSigningInPage {

    private WebDriver driver;

    public NeedHelpSigningInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By forgottenpasswordlocator = By.xpath("//span[contains(text(),\"forgotten my password\")]");

    public SendPasswordResetEmailPage clickOnForgottenMyPasswordlink(){
        driver.findElement(forgottenpasswordlocator).click();
        return new SendPasswordResetEmailPage(driver);
    }
}
