package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePageObject extends BasePageObject {
    private final Actions actions = new Actions(driver);
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By orderButton = By.xpath("//button[text()='Оформить заказ']");

    private final By bun = By.xpath("//span[text() = 'Булки']");
    private final By sauce = By.xpath("//span[text() = 'Соусы']");
    private final By filling = By.xpath("//span[text() = 'Начинки']");

    public HomePageObject(WebDriver driver, int timeoutDuration) {
        super(driver, timeoutDuration);
    }

    public WebElement getOrderButton() {
        return driver.findElement(orderButton);
    }

    private WebElement getBun() {
        return driver.findElement(bun);
    }

    private WebElement getIngredient(String ingredient) {
        return driver.findElement(By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/ul[" + ingredient + "]/a[1]/img"));
    }

    private WebElement getSauce() {
        return driver.findElement(sauce);
    }

    private WebElement getFilling() {
        return driver.findElement(filling);
    }

    private WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    @Step("Press Bun button")
    public void pressOnBuns() {
        loadElement(getBun());
        actions.moveToElement(getBun()).click().perform();
    }

    @Step("Check visibility")
    public Boolean checkIngredientDisplayed(String ingredient) {
        loadElement(getIngredient(ingredient));
        return getIngredient(ingredient).isDisplayed();
    }

    @Step("Press Sauce button")
    public void pressOnSauce() {
        loadElement(getSauce());
        actions.moveToElement(getSauce()).click().perform();
    }

    @Step("Press Filling button")
    public void pressOnFilling() {
        loadElement(getFilling());
        actions.moveToElement(getFilling()).click().perform();
    }

    @Step("Press Login button")
    public void pressLogInButton() {
        loadElement(getLoginButton());
        getLoginButton().click();
    }
}
