package tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartUp {
    protected WebDriver driver;
    protected String homePageUrl;
    protected String registerPageUrl;
    protected String loginPageUrl;
    protected String forgotPassUrl;
    protected String accountProfileURL;
    protected String name;
    protected String email;
    protected String password;
    protected String wrongPassword;
    protected String bun;
    protected String sauce;
    protected String filling;

    public void startUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        homePageUrl = "https://stellarburgers.nomoreparties.site/";
        registerPageUrl = "https://stellarburgers.nomoreparties.site/register";
        loginPageUrl = "https://stellarburgers.nomoreparties.site/login";
        forgotPassUrl = "https://stellarburgers.nomoreparties.site/forgot-password";
        accountProfileURL = "https://stellarburgers.nomoreparties.site/account/profile";
        name = "Ivan12";
        email = "Ivan321321321@mail.ru";
        password = "123456";
        wrongPassword = "11";
        bun = "1";
        sauce = "2";
        filling = "3";
    }
}