package tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeFormTest extends BaseTest {

    private static final String FIRST_NAME = "Ivan";
    private static final String LAST_NAME = "Ivanov";
    private static final String EMAIL = "ivan.ivanov@example.com";
    private static final String GENDER = "Male";
    private static final String MOBILE = "1234567890";
    private static final String DAY = "15";
    private static final String MONTH_VALUE = "5";
    private static final String MONTH_LABEL = "May";
    private static final String YEAR = "1995";
    private static final String SUBJECT = "Maths";
    private static final String HOBBY = "Reading";
    private static final String ADDRESS = "123 Test Street, Test City";
    private static final String STATE = "NCR";
    private static final String CITY = "Delhi";

    @Test
    void fillPracticeFormAndVerifySubmission() {
        PracticeFormPage formPage = new PracticeFormPage();

        formPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setGender(GENDER)
                .setMobile(MOBILE)
                .setDateOfBirth(DAY, MONTH_VALUE, MONTH_LABEL, YEAR)
                .setSubjects(SUBJECT)
                .setHobbies(HOBBY)
                .setCurrentAddress(ADDRESS)
                .setState(STATE)
                .setCity(CITY)
                .submitForm();

        formPage.getResultTable()
                .shouldBe(com.codeborne.selenide.Condition.visible)
                .shouldHave(text(FIRST_NAME + " " + LAST_NAME))
                .shouldHave(text(EMAIL))
                .shouldHave(text(MOBILE))
                .shouldHave(text(SUBJECT))
                .shouldHave(text(HOBBY))
                .shouldHave(text(ADDRESS))
                .shouldHave(text(STATE))
                .shouldHave(text(CITY));

        String tableText = formPage.getResultTableText();
        assertTrue(tableText.contains(DAY) && tableText.contains(MONTH_LABEL) && tableText.contains(YEAR),
                "Date of birth should be present in the result table");
    }
}