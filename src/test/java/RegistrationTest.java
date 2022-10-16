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
        register = new RegisterPageObject(driver, 3);
        login = new LoginPageObject(driver, 3);
        deleteNeeded = true;
    }

    @Test
    @DisplayName("Check registration (correct pass)")
    public void correctRegistrationTest() {
        driver.get(registerPageUrl);
        register.register(name, email, password);
        assertTrue("Failed", register.checkRegister(email, password));
    }

    @Test
    @DisplayName("Check registration (wrong pass)")
    public void wrongPassRegisterTest() {
        deleteNeeded = false;
        driver.get(registerPageUrl);
        register.register(name, email, wrongPassword);
        register.pressLogin();
        assertFalse("Failed", register.checkRegister(email, password));
    }

    @After
    public void cleanUp() {
        if (deleteNeeded) {
            delete(email, password);
        }
        driver.quit();
    }
}