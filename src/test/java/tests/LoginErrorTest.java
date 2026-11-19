package tests;

import core.BaseTest;
import pages.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginErrorTest extends BaseTest {

    private static final String USERNAME = "Ivanii";
    private static final String PASSWORD = "Ivan7$7";
    private static final String EXPECTED_ERROR = "Invalid username or password!";

    @Test
    void invalidLoginShowsErrorMessage() {
        LoginPage loginPage = new LoginPage();

        loginPage.openPage()
                .setUserName(USERNAME)
                .setPassword(PASSWORD)
                .clickLogin();

        // Wait for error message to appear
        com.codeborne.selenide.Selenide.sleep(2000);

        // Check if error message is visible
        boolean isErrorVisible = loginPage.isErrorMessageVisible();
        assertTrue(isErrorVisible,
                "Error message should be visible after invalid login");

        // Verify error text
        String actualError = loginPage.getErrorMessageText();
        assertTrue(actualError.contains(EXPECTED_ERROR),
                "Expected error message: " + EXPECTED_ERROR + ", but got: " + actualError);
    }
}