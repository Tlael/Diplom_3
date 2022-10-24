import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.ProfilePageObject;
import pageObjects.RegisterPageObject;
import tools.StartUp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static tools.DeleteUser.delete;

public class ProfileTest extends StartUp {
    RegisterPageObject register;
    HomePageObject home;
    LoginPageObject login;
    ProfilePageObject profile;

    @Before
    public void setUp() {
        startUp();
        home = new HomePageObject(driver);
        login = new LoginPageObject(driver);
        profile = new ProfilePageObject(driver);

        driver.get(REGISTER_PAGE_URL);
        register = new RegisterPageObject(driver);
        register.register(NAME, EMAIL, PASSWORD);
    }

    @Test
    @DisplayName("Check ProfilePage")
    public void moveToAccountProfileFromHomePage() {
        driver.get(LOGIN_PAGE_URL);
        login.login(EMAIL, PASSWORD);
        home.pressAccountProfileButton();
        assertTrue("Failed", profile.checkAccountProfileEnabled());
    }

    @Test
    @DisplayName("Check SingOut button")
    public void signOutButtonTest() {
        driver.get(LOGIN_PAGE_URL);
        login.login(EMAIL, PASSWORD);
        home.pressAccountProfileButton();
        profile.signOut();
        String expectedURL = "https://stellarburgers.nomoreparties.site/login";
        assertEquals("Failed", expectedURL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check logo redirect")
    public void moveToConstructorFromAccountProfileByLogo() {
        driver.get(LOGIN_PAGE_URL);
        login.login(EMAIL, PASSWORD);
        home.pressAccountProfileButton();
        profile.pressStellarLogo();
        assertEquals("Failed", HOME_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check Constructor button")
    public void moveToConstructorFromAccountProfileByConstructorButton() {
        driver.get(LOGIN_PAGE_URL);
        login.login(EMAIL, PASSWORD);
        home.pressAccountProfileButton();
        profile.pressConstructorButton();
        assertEquals("Failed", HOME_PAGE_URL, driver.getCurrentUrl());
    }

    @After
    public void cleanUp() {
        delete(EMAIL, PASSWORD);
        driver.quit();
    }
}