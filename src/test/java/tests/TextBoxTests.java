package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; //defoult = 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("[id=userName]").setValue("Semen");
        $("#userEmail").setValue("diamondMan67@mail.ru");
        $("#currentAddress").setValue("Центральная,23");
        $("#permanentAddress").setValue("Береговая, 37");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text("Semen"));
        $("#output").$("#email").shouldHave(text("diamondMan67@mail.ru"));
        $("#currentAddress", 1).shouldHave(text("Центральная,23"));
        $("#output #permanentAddress").shouldHave(text("Береговая, 37"));


    }
}
