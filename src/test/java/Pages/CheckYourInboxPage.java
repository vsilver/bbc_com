package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckYourInboxPage {

    private WebDriver driver;

    public CheckYourInboxPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkyourinboxlocator = By.xpath("//span[contains(text(),'Please check your inbox')]");

    public boolean messageIsDisplayed(){
        driver.findElement(checkyourinboxlocator).isDisplayed();
        return true;
    }
}

