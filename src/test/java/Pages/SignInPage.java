package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernamelocator = By.xpath("//input[@id='user-identifier-input']");
    private By passwordlocator = By.xpath("//input[@id='password-input']");
    private By submitbuttonlocator = By.xpath("//button[@id='submit-button']");
    private By needhelplocator = By.xpath("//p[@class='button__label']//a[@class='link']");

    public SignInPage fillUserName(String username){
        driver.findElement(usernamelocator).sendKeys(username);
        return this;
    }

    public SignInPage fillPassword(String password){
        driver.findElement(passwordlocator).sendKeys(password);
        return this;
    }

    public AuthorizationPage clickOnSubmitButton(){
        driver.findElement(submitbuttonlocator).click();
        return new AuthorizationPage(driver);
    }

    public AuthorizationPage signIn(String username, String password){
        fillUserName(username);
        fillPassword(password);
        clickOnSubmitButton();
        return new AuthorizationPage(driver);
    }

    public NeedHelpSigningInPage clickOnNeedHelpSigningInLink (){
        driver.findElement(needhelplocator).click();
        return new NeedHelpSigningInPage(driver);
    }
}
