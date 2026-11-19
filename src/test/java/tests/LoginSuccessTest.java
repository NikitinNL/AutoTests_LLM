package tests;

import com.codeborne.selenide.Condition;
import core.BaseTest;
import pages.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSuccessTest extends BaseTest {

    private static final String USERNAME = "IvanIvanov";
    private static final String PASSWORD = "Ivan7$7";

    @Test
    void validLoginRedirectsToProfile() {
        LoginPage loginPage = new LoginPage();

        loginPage.openPage()
                .setUserName(USERNAME)
                .setPassword(PASSWORD)
                .clickLogin();

        // After successful login, no error message should be displayed
        boolean isErrorVisible = loginPage.isErrorMessageVisible();
        assertFalse(isErrorVisible,
                "After successful login, no error message should be displayed");

        // Verify that user is redirected to profile page by checking for profile content
        boolean isProfileVisible = com.codeborne.selenide.Selenide.$x("//div[contains(text(),'Profile') or contains(text(),'profile') or contains(text(),'Book Store')]").is(visible);
        assertTrue(isProfileVisible,
                "After successful login, user should be redirected to profile page");
    }
}