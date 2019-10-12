package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendPasswordResetEmailPage {

    private WebDriver driver;

    public SendPasswordResetEmailPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emterforgottenemaillocator = By.xpath("//input[@id='user-identifier-input']");
    private By resetemailbuttonlocator = By.xpath("//span[contains(text(),'Send password reset email')]");

    public SendPasswordResetEmailPage fillEmail(String username){
        driver.findElement(emterforgottenemaillocator).sendKeys(username);
        return this;
    }

    public CheckYourInboxPage clickOnReseEmailSubmitButton(){
        driver.findElement(resetemailbuttonlocator).click();
        return new CheckYourInboxPage(driver);
    }

    public CheckYourInboxPage resetPassword(String username){
        fillEmail(username);
        clickOnReseEmailSubmitButton();
        return new CheckYourInboxPage(driver);
    }
}
