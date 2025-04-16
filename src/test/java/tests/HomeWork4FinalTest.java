package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class HomeWork4FinalTest {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://github.com/";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

   @BeforeEach
    void openPage() {
        open(baseUrl);
    }

    @Test
    @DisplayName("Провека, что внутри страницы SoftAssertions - есть пример кода для JUnit5")
    void findSampleCodeJU5InsideSoftAssertionsPage() {
        // нажимаю на кнопку поиска
        $("[placeholder='Search or jump to...']").click();
        // ввожу поисковый запрос и нажимаю enter
        $("#query-builder-test").setValue("Selenide").pressEnter();
        //нажимаю в результатах поиска на строку, которая относится к репозиторию обычного Selenide
        $("[data-testid=results-list]").$("[href=\"/selenide/selenide\"]").click();
        // проверяю, что попал в нужный репозиторий
        webdriver().shouldHave(url("https://github.com/selenide/selenide"));
        // перехожу на вкладку Wiki
        $$("ul li a").findBy(text("Wiki")).click();

        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions:
          //1 Разворачиваем весь список в Pages
        $("li.Box-row.wiki-more-pages-link").$("button").click();
          //2 Убеждаемся, что в списке страниц (Pages) есть пункт SoftAssertions и открываем эту страницу
        $$("[data-filterable-for=wiki-pages-filter] li a").findBy(exactText("SoftAssertions")).shouldBe(visible).click();

        //Проверяем, что внутри страницы SoftAssertions - есть пример кода для JUnit5
          //заголовок JUnit5
        $$("h4.heading-element").findBy(exactText("3. Using JUnit5 extend test class:")).shouldBe(visible)
                // находим предка уровнем выше > следующий элемент за этим предком > проваливаемся в pre (где содержится пример кода JUnit5) и сравниваем сам код
                .closest(".markdown-heading").sibling(0).$("pre")
                .shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));
    }
}