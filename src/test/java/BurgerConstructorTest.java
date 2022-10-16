import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.HomePageObject;
import tools.StartUp;

import static org.junit.Assert.assertTrue;

public class BurgerConstructorTest extends StartUp {
    HomePageObject home;

    @Before
    public void setUp() {
        startUp();
        home = new HomePageObject(driver, 3);
    }

    @Test
    @DisplayName("Check Buns")
    public void bunsTabTest() {
        driver.get(homePageUrl);
        home.pressOnBuns();
        assertTrue("Failed", home.checkIngredientDisplayed(bun));
    }

    @Test
    @DisplayName("Check sauce")
    public void sauceTabTest() {
        driver.get(homePageUrl);
        home.pressOnSauce();
        assertTrue("Failed", home.checkIngredientDisplayed(sauce));
    }

    @Test
    @DisplayName("Check filling")
    public void fillingTabTest() {
        driver.get(homePageUrl);
        home.pressOnFilling();
        assertTrue("Failed", home.checkIngredientDisplayed(filling));
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}