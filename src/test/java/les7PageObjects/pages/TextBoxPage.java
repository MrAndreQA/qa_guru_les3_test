package les7PageObjects.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private final SelenideElement fullNameInput = $("[id=userName]"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            nameOutput = $("#name"),
            emailOutput = $("#email"),
            currentAddressOutput = $("#currentAddress", 1),
            permanentAddressOutput = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkNameResult(String value) {
        nameOutput.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkEmailResult(String value) {
        emailOutput.shouldHave(text(value));
        return this;
    }
    public TextBoxPage checkCurrentAddressResult(String value) {
        currentAddressOutput.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkPermanentAddressResult(String value) {
        permanentAddressOutput.shouldHave(text(value));
        return this;
    }
}