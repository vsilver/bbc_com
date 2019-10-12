package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.SignInPage;
import Pages.StartPage;
import Pages.AuthorizationPage;
import Pages.NeedHelpSigningInPage;
import Pages.SendPasswordResetEmailPage;
import Pages.CheckYourInboxPage;
import Pages.NewsPage;
import Pages.SearchResultPage;
import Pages.YourAccountPage;
import Pages.SettingsPage;
import Pages.EditSettingsPage;

import java.util.concurrent.TimeUnit;

public class Tests {

    private WebDriver driver;

    private StartPage startPage;
    private SignInPage signInPage;
    private AuthorizationPage authorizationPage;
    private NeedHelpSigningInPage needHelpSigningInPage;
    private SendPasswordResetEmailPage sendPasswordResetEmailPage;
    private CheckYourInboxPage checkYourInboxPage;
    private NewsPage newsPage;
    private SearchResultPage searchResultPage;
    private YourAccountPage yourAccountPage;
    private SettingsPage settingsPage;
    private EditSettingsPage editSettingsPage;


    private String log;
    private String pass;
    private String search;
    private String newname;
    private final static String MYLOGIN = "vsilver@bigmir.net";
    private final static String MYPASS = "qwert123";
    private final static String SEARCHWORD = "news";
    private final static String NEWNAME = "Valdemort1";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com");
        startPage = new StartPage(driver);
        signInPage = new SignInPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        needHelpSigningInPage = new NeedHelpSigningInPage(driver);
        sendPasswordResetEmailPage = new SendPasswordResetEmailPage(driver);
        checkYourInboxPage = new CheckYourInboxPage(driver);
        newsPage = new NewsPage(driver);
        searchResultPage = new SearchResultPage(driver);
        yourAccountPage = new YourAccountPage(driver);
        settingsPage = new SettingsPage(driver);
        editSettingsPage = new EditSettingsPage(driver);
    }

    @Test
    public void checkLogInWithExistingUser() throws InterruptedException{
        log = MYLOGIN;
        pass = MYPASS;
        startPage.clickOnSignInButton();
        signInPage.signIn(log,pass);
        Assert.assertTrue(authorizationPage.yourProfileIsDisplayed());
    }

    @Test
    public void checkForgotPassword() throws InterruptedException{
        log = MYLOGIN;
        startPage.clickOnSignInButton();
        signInPage.clickOnNeedHelpSigningInLink();
        needHelpSigningInPage.clickOnForgottenMyPasswordlink();
        sendPasswordResetEmailPage.resetPassword(log);
        Assert.assertTrue(checkYourInboxPage.messageIsDisplayed());
    }

    @Test
    public void checkSearchViaNewsPage() throws InterruptedException{
        log = MYLOGIN;
        pass = MYPASS;
        search = SEARCHWORD;
        startPage.clickOnSignInButton();
        signInPage.signIn(log,pass);
        authorizationPage.clickOnNewsLink();
        newsPage.enterSearchWord(search);
        Assert.assertEquals("Home - BBC News", driver.getTitle());
    }

    @Test
    public void checkEditProfile() throws InterruptedException{
        log = MYLOGIN;
        pass = MYPASS;
        newname = NEWNAME;
        startPage.clickOnSignInButton();
        signInPage.signIn(log,pass);
        authorizationPage.clickOnProfileLink();
        yourAccountPage.clickOnProfileLink();
        settingsPage.clickOnEditNameButton();
        editSettingsPage.completeEditingNewName(newname);
        Assert.assertTrue((driver.findElement(By.xpath("//div[contains(text(),'Valdemort1')]")).getText().contains(newname)));
    }

    @After
    public void closeConnect() throws Exception {
        driver.quit();
    }
}
