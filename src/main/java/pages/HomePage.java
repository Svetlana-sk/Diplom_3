package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    // локатор "Конструктор"
    private final By constructorLink = By.xpath(".//p[text()='Конструктор']");
    // локатор логотипа Stellar Burgers
    private final By stellarBurgersLogoLink = By.xpath(".//div/header/nav/div/a");
    // локатор раздела Булки
    private final By bunsChapter = By.xpath(".//span[text()='Булки']");
    // локатор раздела Соусы
    private final By saucesChapter = By.xpath(".//span[text()='Соусы']");
    // локатор раздела Ингридиенты
    private final By ingredientsChapter = By.xpath(".//span[text()='Начинки']");
    // локатор заголовка Соберите бургер
    private final By constructBurgerHeader = By.xpath(".//h1[text()='Соберите бургер']");
    // локатор текста элемента
    private final By theChosenElement = By.className("tab_tab_type_current__2BEPc");
    private final WebDriver webDriver;
    // локатор "Личный кабинет"
    private final By personalAreaLink = By.xpath(".//p[text()='Личный Кабинет']");
    // локатор "Войти в аккаунт"
    private final By enterAcountButton = By.xpath(".//button[text()='Войти в аккаунт']");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Клик на Личный кабинет")
    public void clickOnPersonalAreaLink() {
        webDriver.findElement(personalAreaLink).click();
    }

    @Step("Клик на кнопку Войти в аккаунт")
    public void clickOnEnterAcountButton() {
        webDriver.findElement(enterAcountButton).click();
    }

    @Step("Клик на Конструктор")
    public void clickOnConstructorLink() {
        webDriver.findElement(constructorLink).click();
    }

    @Step("Клик на лого Stellar Burgers")
    public void clickOnStellarBurgersLogoLink() {
        webDriver.findElement(stellarBurgersLogoLink).click();
    }

    @Step("Клик на раздел Булки")
    public void clickOnBunsChapter() {
        webDriver.findElement(bunsChapter).click();
    }

    @Step("Клик на раздел Соусы")
    public void clickOnSaucesChapter() {
        webDriver.findElement(saucesChapter).click();
    }

    @Step("Клик на раздел Начинки")
    public void clickOnIngredientsChapter() {
        webDriver.findElement(ingredientsChapter).click();
    }

    @Step("Пполучить заголовок Соберите бургер")
    public By getConstructBurgerHeader() {
        return constructBurgerHeader;
    }

    @Step("Получить текст элемента")
    public String getTextFromTheChosenElement() {
        return webDriver.findElement(theChosenElement).getText();
    }
}