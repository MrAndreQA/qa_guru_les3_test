package tests;

import les7PageObjects.TestProperties;
import les7PageObjects.pages.TextBoxPage;
import org.junit.jupiter.api.*;
import static les7PageObjects.pages.testData.TextBoxTestData.*;

public class TextBoxHomeWork7WithPomTests extends TestProperties {

    @Test
    @DisplayName("Отправка формы Text Box - с заполнением всех полей")
    void fillFormTextBoxWithPomTest() {
        new TextBoxPage().openPage()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmitButton()
        // *** Проверки ***//
                .checkNameResult(fullName)
                .checkEmailResult(email)
                .checkCurrentAddressResult(currentAddress)
                .checkPermanentAddressResult(permanentAddress);
    }
}