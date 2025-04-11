package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import java.io.File;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork3Test {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    @DisplayName("Practice Form: проверка заполнение всех полей")
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("James");
        $("#lastName").setValue("Bond");
        $("#userEmail").setValue("Jb@universal-exports.uk");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8989123456");

        //Календарик
        $("#dateOfBirthInput").click();
              // выбираем год
        $(".react-datepicker__year-select").selectOption("2008");
             // выбираем месяц
        $(".react-datepicker__month-select").selectOption("March");
             // выбираем день
        $$("div.react-datepicker__day").findBy(text("21")).click();

        //Заполнение Subjects
        $x("//div[@id = 'subjectsContainer']").click();
        $x("//div[@id = 'subjectsContainer']//input").setValue("E");
        $x("//div[@id = 'subjectsContainer']//div[contains(text(),'English')]").click();

        // выбираю Hobbies
        $("[for=hobbies-checkbox-1]").click();

        // добавляю picture
        $("#uploadPicture").uploadFile(new File("src/test/resources/картинка.jpg"));

        // заполняем currentAddress
        $("#currentAddress").setValue("Ленина,28");

        //заполняем State и City
        $(byText("Select State")).scrollIntoView(true).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();

        //нажимаем Submit
        $("#submit").click();

        // проверка отображения модалки
        $(".modal-content").shouldBe(visible);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));

        // проверка совпадения данных, введенных при заполнении формы
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("James Bond"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("Jb@universal-exports.uk"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8989123456"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("21 March,2008"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("картинка.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Ленина,28"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}