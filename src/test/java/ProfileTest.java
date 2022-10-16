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
        home = new HomePageObject(driver, 3);
        login = new LoginPageObject(driver, 3);
        profile = new ProfilePageObject(driver, 3);

        driver.get(registerPageUrl);
        register = new RegisterPageObject(driver, 3);
        register.register(name, email, password);
    }

    @Test
    @DisplayName("Check ProfilePage")
    public void moveToAccountProfileFromHomePage() {
        driver.get(loginPageUrl);
        login.login(email, password);
        home.pressAccountProfileButton();
        assertTrue("Failed", profile.checkAccountProfileEnabled());
    }

    @Test
    @DisplayName("Check SingOut button")
    public void signOutButtonTest() {
        driver.get(loginPageUrl);
        login.login(email, password);
        home.pressAccountProfileButton();
        profile.signOut();
        String expectedURL = "https://stellarburgers.nomoreparties.site/login";
        assertEquals("Failed", expectedURL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check logo redirect")
    public void moveToConstructorFromAccountProfileByLogo() {
        driver.get(loginPageUrl);
        login.login(email, password);
        home.pressAccountProfileButton();
        profile.pressStellarLogo();
        assertEquals("Failed", homePageUrl, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check Constructor button")
    public void moveToConstructorFromAccountProfileByConstructorButton() {
        driver.get(loginPageUrl);
        login.login(email, password);
        home.pressAccountProfileButton();
        profile.pressConstructorButton();
        assertEquals("Failed", homePageUrl, driver.getCurrentUrl());
    }

    @After
    public void cleanUp() {
        delete(email, password);
        driver.quit();
    }
}