package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private static final String URL = "https://demoqa.com/login";

    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("#login");
    private final SelenideElement newUserButton = $(byText("New User"));

    public LoginPage openPage() {
        Selenide.open(URL);
        userNameInput.shouldBe(Condition.visible);
        return this;
    }

    public LoginPage setUserName(String userName) {
        userNameInput.setValue(userName);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public LoginPage clickLogin() {
        loginButton.click();
        return this;
    }

    public boolean isUserNameInputVisible() {
        return userNameInput.is(Condition.visible);
    }

    public boolean isPasswordInputVisible() {
        return passwordInput.is(Condition.visible);
    }

    public boolean isLoginButtonVisible() {
        return loginButton.is(Condition.visible);
    }

    public boolean isNewUserButtonVisible() {
        return newUserButton.is(Condition.visible);
    }

    public boolean isErrorMessageVisible() {
        return $x("//div[contains(text(),'Invalid') or contains(text(),'invalid') or contains(text(),'error') or contains(@id,'message') or contains(@class,'error') or contains(text(),'Password')]")
                .is(Condition.visible);
    }

    public String getErrorMessageText() {
        return $x("//div[contains(text(),'Invalid') or contains(text(),'invalid') or contains(text(),'error') or contains(@id,'message') or contains(@class,'error') or contains(text(),'Password')]")
                .getText();
    }

    public SelenideElement getErrorMessage() {
        return $x("//div[contains(text(),'Invalid') or contains(text(),'invalid') or contains(text(),'error') or contains(@id,'message') or contains(@class,'error') or contains(text(),'Password')]");
    }
}