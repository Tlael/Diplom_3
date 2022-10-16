package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPageObject extends BasePageObject {
    private final By login = By.xpath("//a[text() = 'Войти']");

    public ForgotPageObject(WebDriver driver, int timeoutDuration) {
        super(driver, timeoutDuration);
    }

    @Step("Press Login")
    public void pressLogInLink() {
        WebElement e = driver.findElement(login);
        loadElement(e);
        e.click();
    }
}