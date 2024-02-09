package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    // локатор для "Вспомнили пароль?"
    private final By enterLink = By.xpath(".//p[text()='Вспомнили пароль?']/a[text()='Войти']");
    private final WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик на ссылку Вспомнили пароль?")
    public void clickOnEnterLinkOnForgotPasswordPage() {
        driver.findElement(enterLink).click();
    }

}