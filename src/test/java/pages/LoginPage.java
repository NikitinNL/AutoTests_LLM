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

    public SelenideElement getErrorMessage() {
        return $x("//p[text()='Invalid username or password!']");
    }

    public boolean isErrorMessageVisible() {
        return getErrorMessage().is(Condition.visible);
    }

    public String getErrorMessageText() {
        return getErrorMessage().getText();
    }
}