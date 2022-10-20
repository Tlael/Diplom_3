package tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartUp {
    protected WebDriver driver;
    public static String HOME_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    public static String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static String FORGOT_PASS_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    public static String NAME = "Ivan12";
    public static String EMAIL = "Ivan321321321@mail.ru";
    public static String PASSWORD = "123456";
    public static String WRONG_PASSWORD = "11";
    public static String BUN = "1";
    public static String SAUCE = "2";
    public static String FILLING = "3";

    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}