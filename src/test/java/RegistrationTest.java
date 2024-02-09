import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {
    @Test
    @DisplayName("Проверка успешного создания пользователя")
    public void checkCreateCorrectUser() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnPersonalAreaLink();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.clickOnRegistrationButton();
        registrationPage.registrationUser(getUser().getName(), getUser().getEmail(), getUser().getPassword());
        Assert.assertTrue(getDriver().findElement(loginPage.getLogo()).isDisplayed());
    }

    @Test
    @DisplayName("Проверка создания пользователя с неверным паролем")
    public void checkCreateUserWithInvalidPassword() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnPersonalAreaLink();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.registrationUser(getUser().getName(), getUser().getEmail(), getIncorrectPassword());
        Assert.assertTrue(getDriver().findElement(registrationPage.getIncorrectPassword()).isDisplayed());
    }
}