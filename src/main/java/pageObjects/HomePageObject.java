package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePageObject extends BasePageObject {
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By orderButton = By.xpath("//button[text()='Оформить заказ']");

    private final By bun = By.xpath("//span[text() = 'Булки']");
    private final By sauce = By.xpath("//span[text() = 'Соусы']");
    private final By filling = By.xpath("//span[text() = 'Начинки']");
    private final By bunSelected = By.xpath("//span[text()='Булки']/..");
    private final By sauceSelected = By.xpath("//span[text()='Соусы']/..");
    private final By fillingSelected = By.xpath("//span[text()='Начинки']/..");

    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    public WebElement getOrderButton() {
        return driver.findElement(orderButton);
    }

    public String getBunClassName() {
        driver.findElement(sauce).click();
        driver.findElement(bun).click();
        return driver.findElement(bunSelected).getAttribute("class");
    }

    public String getSauceClassName() {
        driver.findElement(filling).click();
        driver.findElement(sauce).click();
        return driver.findElement(sauceSelected).getAttribute("class");
    }

    public String getFillingClassName() {
        driver.findElement(sauce).click();
        driver.findElement(filling).click();
        return driver.findElement(fillingSelected).getAttribute("class");
    }

    private WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    @Step("Press Login button")
    public void pressLogInButton() {
        loadElement(getLoginButton());
        getLoginButton().click();
    }
}
