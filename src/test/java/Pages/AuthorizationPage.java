package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorizationPage {

    private WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By youraccountlocator = By.xpath("//span[@id='idcta-username']");
    private By newstlocator = By.xpath("//div[@id='orb-nav-links']//a[contains(text(),'News')]");

    public boolean yourProfileIsDisplayed(){
        driver.findElement(youraccountlocator).isDisplayed();
        return true;
    }

    public NewsPage clickOnNewsLink (){
        driver.findElement(newstlocator).click();
        return new NewsPage(driver);
    }

    public YourAccountPage clickOnProfileLink (){
        driver.findElement(youraccountlocator).click();
        return new YourAccountPage(driver);
    }
}
