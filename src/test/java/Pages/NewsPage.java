package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsPage {
    private WebDriver driver;

    public NewsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchlocator = By.xpath("//input[@id='orb-search-q']");
    private By buttonsearclocator = By.xpath("//button[@id='orb-search-button']");

    public NewsPage enterSearchWord(String searchword){
        driver.findElement(searchlocator).sendKeys(searchword);
        return this;
    }

    public SearchResultPage clickOnSearchField(){
        driver.findElement(buttonsearclocator).click();
        return new SearchResultPage(driver);
    }

    public SearchResultPage makeSearch(String searchword){
        enterSearchWord(searchword);
        clickOnSearchField();
        return new SearchResultPage(driver);
    }
}
