package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {
    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signinlocator = By.xpath("//span[@id='idcta-username']");

    public SignInPage clickOnSignInButton (){
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.presenceOfElementLocated(signinlocator));
        driver.findElement(signinlocator).click();
        return new SignInPage(driver);
    }
}
