import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import tools.StartUp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static tools.DeleteUser.delete;

public class RegistrationTest extends StartUp {
    Boolean deleteNeeded;
    RegisterPageObject register;
    LoginPageObject login;

    @Before
    public void setUp() {
        startUp();
        register = new RegisterPageObject(driver);
        login = new LoginPageObject(driver);
        deleteNeeded = true;
    }

    @Test
    @DisplayName("Check registration (correct pass)")
    public void correctRegistrationTest() {
        driver.get(REGISTER_PAGE_URL);
        register.register(NAME, EMAIL, PASSWORD);
        assertTrue("Failed", register.checkRegister(EMAIL, PASSWORD));
    }

    @Test
    @DisplayName("Check registration (wrong pass)")
    public void wrongPassRegisterTest() {
        deleteNeeded = false;
        driver.get(REGISTER_PAGE_URL);
        register.register(NAME, EMAIL, WRONG_PASSWORD);
        register.pressLogin();
        assertFalse("Failed", register.checkRegister(EMAIL, PASSWORD));
    }

    @After
    public void cleanUp() {
        if (deleteNeeded) {
            delete(EMAIL, PASSWORD);
        }
        driver.quit();
    }
}