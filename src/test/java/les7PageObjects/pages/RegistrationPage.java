package les7PageObjects.pages;

import com.codeborne.selenide.SelenideElement;
import les7PageObjects.pages.components.CalendarComponent;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private final SelenideElement formHeader = $(".practice-form-wrapper"),
            tableWindow = $(".table-responsive"),
            modalHeader = $(".modal-title"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateButton = $(byText("Select State")),
            cityButton = $(byText("Select City")),
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formHeader.shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage clearBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {  // доработайй
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateButton.scrollIntoView(true).click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        cityButton.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkModalHeader (String value) {
        modalHeader.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableWindow.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
    public RegistrationPage checkResultEmpty(String key) {
        tableWindow.$(byText(key)).sibling(0)
                //.shouldHave(exactText(""));
                .shouldBe(empty);
        return this;
    }

    public RegistrationPage checkIsNotVisible_tableWindow() {
        tableWindow.shouldNotBe(visible);
        return this;
    }
    public RegistrationPage checkIsVisible_tableWindow() {
        tableWindow.shouldBe(visible);
        return this;
    }
}