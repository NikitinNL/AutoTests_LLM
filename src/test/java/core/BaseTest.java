package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    @BeforeEach
    void setUpBrowser() {
        Configuration.browser = "chrome";
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "normal";
    }

    @AfterEach
    void tearDownBrowser() {
        Selenide.closeWebDriver();
    }
}