package tests;

import core.BaseTest;
import pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginFormDisplayTest extends BaseTest {

    @Test
    void loginFormIsDisplayedOnPageLoad() {
        LoginPage loginPage = new LoginPage();

        loginPage.openPage();

        // Verify all form elements are visible
        assertTrue(loginPage.isUserNameInputVisible(),
                "UserName input should be visible");
        assertTrue(loginPage.isPasswordInputVisible(),
                "Password input should be visible");
        assertTrue(loginPage.isLoginButtonVisible(),
                "Login button should be visible");
        assertTrue(loginPage.isNewUserButtonVisible(),
                "New User button should be visible");
    }
}