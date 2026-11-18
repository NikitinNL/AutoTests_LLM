package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$x;

public class PracticeFormPage {

    private static final String URL = "https://demoqa.com/automation-practice-form";

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement mobileInput = $("#userNumber");
    private final SelenideElement submitButton = $("#submit");

    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");

    private final SelenideElement resultTable = $(".modal-content");

    public PracticeFormPage openPage() {
        Selenide.open(URL);
        return this;
    }

    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public PracticeFormPage setGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public PracticeFormPage setMobile(String mobile) {
        mobileInput.setValue(mobile);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String monthValue, String monthLabel, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthLabel);
        $(".react-datepicker__year-select").selectOption(year);
        $x(String.format("//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='%s']", day)).click();
        return this;
    }

    public PracticeFormPage setSubjects(String subject) {
        subjectsInput.setValue(subject);
        String xpath = String.format(".//div[contains(text(),'%s')]", subject);
        $(".subjects-auto-complete__menu").shouldBe(Condition.visible).$x(xpath).click();
        return this;
    }

    public PracticeFormPage setHobbies(String hobby) {
        $(byText(hobby)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String filePath) {
        uploadPictureInput.uploadFromClasspath(filePath);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public PracticeFormPage setState(String state) {
        stateInput.scrollIntoView(true);
        stateInput.click();
        $$x(String.format("//div[contains(@class,'css-') and contains(@class,'-menu')]//div[text()='%s']", state)).last().click();
        return this;
    }

    public PracticeFormPage setCity(String city) {
        cityInput.scrollIntoView(true);
        cityInput.click();
        $$x(String.format("//div[contains(@class,'css-') and contains(@class,'-menu')]//div[text()='%s']", city)).last().click();
        return this;
    }

    public PracticeFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public SelenideElement getResultTable() {
        return resultTable;
    }

    public String getResultTableText() {
        return resultTable.getText();
    }
}