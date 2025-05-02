package tests;

import les7PageObjects.TestProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import les7PageObjects.pages.RegistrationPage;
import static les7PageObjects.pages.testData.PracticeFormTestData.*;

public class HomeWork7PageObjectTest extends TestProperties {

    @Test
    @DisplayName("Practice Form: отправка формы при заполнении всех полей")
    void fillAllFieldsInPracticeFormTest() {
        new RegistrationPage().openPage()
                .clearBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirht, yearOfBirth)
                .setSubject(subjectEnglish)
                .setHobbies(hobbieReading)
                .setPicture(pictureFileName)
                .setCurrentAddress(currentAddress)
                .setState(stateNcr)
                .setCity(cityDelhi)
                .clickSubmitButton()
                //*** проверки ***//
                .checkModalHeader("Thanks for submitting the form")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirht + "," + yearOfBirth)
                .checkResult("Subjects", subjectEnglish)
                .checkResult("Hobbies", hobbieReading)
                .checkResult("Picture", pictureFileName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", stateNcr + " " + cityDelhi);
    }

    @Test
    @DisplayName("Practice Form: отправка формы при заполнении только обязательных полей")
    void fillOnlyRequiredFieldsInPracticeFormTest() {
        new RegistrationPage().openPage()
                .clearBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .clickSubmitButton()
                //*** проверки ***//
                .checkModalHeader("Thanks for submitting the form")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResultEmpty("Student Email")
                .checkResultEmpty("Subjects")
                .checkResultEmpty("Hobbies")
                .checkResultEmpty("Picture")
                .checkResultEmpty("Address")
                .checkResultEmpty("State and City");
    }

    @Test
    @DisplayName("Practice Form: негативный тест - попытка отправить форму при незаполненном чек-боксе Sex")
    void fillPracticeFormNegativeTest() {
        new RegistrationPage().openPage()
                .clearBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserNumber(userNumber)
                .clickSubmitButton()
                //*** проверки ***//
                .checkIsNotVisible_tableWindow();
    }
}