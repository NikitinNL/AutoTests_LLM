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

        loginPage.getErrorMessage()
                .shouldBe(com.codeborne.selenide.Condition.visible)
                .shouldHave(text(EXPECTED_ERROR));

        String actualError = loginPage.getErrorMessageText();
        assertTrue(actualError.contains(EXPECTED_ERROR),
                "Expected error message: " + EXPECTED_ERROR + ", but got: " + actualError);
    }
}