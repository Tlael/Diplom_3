import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.ForgotPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import tools.StartUp;

import static org.junit.Assert.assertTrue;
import static tools.DeleteUser.delete;

public class LoginTest extends StartUp {
    RegisterPageObject register;
    HomePageObject home;
    LoginPageObject login;
    ForgotPageObject forgot;

    @Before
    public void setUp() {
        startUp();
        home = new HomePageObject(driver, 3);
        login = new LoginPageObject(driver, 3);
        forgot = new ForgotPageObject(driver, 3);

        driver.get(registerPageUrl);
        register = new RegisterPageObject(driver, 3);
        register.register(name, email, password);
    }

    @Test
    @DisplayName("HomePage login")
    public void loginFromAccountProfileButton() {
        driver.get(homePageUrl);
        home.pressLogInButton();
        login.login(email, password);
        assertTrue("Failed", login.checkLogin());
    }

    @Test
    @DisplayName("Profile login")
    public void logInFromAccountProfileButton() {
        driver.get(homePageUrl);
        home.pressAccountProfileButton();
        login.login(email, password);
        assertTrue("Failed", login.checkLogin());
    }

    @Test
    @DisplayName("Registration login")
    public void logInFromRegistrationForm() {
        driver.get(registerPageUrl);
        register.pressLogin();
        login.login(email, password);
        assertTrue("Failed", login.checkLogin());
    }

    @Test
    @DisplayName("ForgotPass login")
    public void logInFromForgotPassPageLink() {
        driver.get(forgotPassUrl);
        forgot.pressLogInLink();
        login.login(email, password);
        assertTrue("Failed", login.checkLogin());
    }

    @After
    public void cleanUp() {
        delete(email, password);
        driver.quit();
    }
}