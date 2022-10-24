import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.HomePageObject;
import tools.StartUp;

import static org.junit.Assert.assertEquals;

public class BurgerConstructorTest extends StartUp {
    HomePageObject home;

    @Before
    public void setUp() {
        startUp();
        home = new HomePageObject(driver);
    }

    @Test
    @DisplayName("Check Buns")
    public void bunsTabTest() {
        driver.get(HOME_PAGE_URL);
        assertEquals(home.getBunClassName(), home.getCurrentClassAttributeValue());
    }

    @Test
    @DisplayName("Check sauce")
    public void sauceTabTest() {
        driver.get(HOME_PAGE_URL);
        assertEquals(home.getSauceClassName(), home.getCurrentClassAttributeValue());
    }

    @Test
    @DisplayName("Check filling")
    public void fillingTabTest() {
        driver.get(HOME_PAGE_URL);
        assertEquals(home.getFillingClassName(), home.getCurrentClassAttributeValue());
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}