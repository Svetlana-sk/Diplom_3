package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class AccountPage {
    private final By nameField = By.xpath(".//ul/li[1]/div/div/input");
    private final WebDriver driver;
    private final User user = new User();

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Вернуть заголовок Имя")
    public By getNameField() {
        return nameField;
    }
}