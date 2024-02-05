import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import steps.UserPage;
import user.LoginUser;
import user.User;
import user.UserGenerator;

import java.time.Duration;

import static model.BrowserSetup.browserDriverSetUp;
import static model.PathApi.BASE_URI;

public class BaseTest {
    private final String incorrectPassword = "9876";
    private final UserPage userPage = new UserPage();
    private WebDriver driver;
    private User user = new User();
    private final LoginUser loginUser = new LoginUser(user.getEmail(), user.getPassword());
    private final LoginUser incorrectLoginUser = new LoginUser(user.getEmail(), incorrectPassword);

    public void setDriver() {
        driver = browserDriverSetUp();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(BASE_URI);
    }

    @Before
    public void setUp() {
        user = UserGenerator.random();
        setDriver();
    }

    @After
    public void tearDown() {
        Response response = getUserPage().loginUser(getLoginUser());
        if (response.jsonPath().get("success").equals(true)) {
            getUserPage().logoutUser(response.jsonPath().get("accessToken"));
            getUserPage().deleteUser(response.jsonPath().get("accessToken"));
        }
        response = getUserPage().loginUser(getIncorrectLoginUser());
        if (response.jsonPath().get("success").equals(true)) {
            getUserPage().logoutUser(response.jsonPath().get("accessToken"));
            getUserPage().deleteUser(response.jsonPath().get("accessToken"));
        }
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public UserPage getUserPage() {
        return userPage;
    }

    public User getUser() {
        return user;
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public LoginUser getIncorrectLoginUser() {
        return incorrectLoginUser;
    }

    public String getIncorrectPassword() {
        return incorrectPassword;
    }
}
