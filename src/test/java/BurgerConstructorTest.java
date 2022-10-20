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
        String classNameAfterSelected = new HomePageObject(driver).getBunClassName();
        assertEquals(home.getBunClassName(), classNameAfterSelected);
    }

    @Test
    @DisplayName("Check sauce")
    public void sauceTabTest() {
        driver.get(HOME_PAGE_URL);
        String classNameAfterSelected = new HomePageObject(driver).getSauceClassName();
        assertEquals(home.getSauceClassName(), classNameAfterSelected);
    }

    @Test
    @DisplayName("Check filling")
    public void fillingTabTest() {
        driver.get(HOME_PAGE_URL);
        String classNameAfterSelected = new HomePageObject(driver).getFillingClassName();
        assertEquals(home.getFillingClassName(), classNameAfterSelected);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}