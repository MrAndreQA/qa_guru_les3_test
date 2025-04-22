package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class HomeWork5Test {

    @Test
    void loadPageEnterprizeInGitHubTest() {

        open("https://github.com/");
         // навожу курсор на Solutions
        $$("button").filterBy(text(" Solutions")).first().hover();  //надо было выбрать единственный элемент, т.к. hover() не работает с коллекциями

        // нажимаю на подпункт Enterprises
        $$("li a").findBy(text(" Enterprises")).click();

        // проверяю, что открылась страница enterprise
        webdriver().shouldHave(url("https://github.com/enterprise"));
        //  проверяю, что заголовок соответствует тексту: "The AI-powered developer platform.").
        $("#hero-section-brand-heading").shouldHave(text("""
       The AI-powered 
       developer platform"""));
    }

    @Test
    void dragAndDropHerokuAppWithoutActionsTest() {

        open("https://the-internet.herokuapp.com/drag_and_drop");

        // проверяем начальное расположение элементов
        $("#column-a").shouldHave(exactText("A"));
        $("#column-b").shouldHave(exactText("B"));

        // Перенесите прямоугольник А на место В
        $("#column-b").dragAndDrop(to($("#column-a")));

        // проверяем итоговое расположение элементов после dragAndDrop
        $("#column-a").shouldHave(exactText("B"));
        $("#column-b").shouldHave(exactText("A"));
    }

    @Test
    void dragAndDropHerokuAppWithActions1Test() {

        open("https://the-internet.herokuapp.com/drag_and_drop");

        // проверяем начальное расположение элементов
        $("#column-a").shouldHave(exactText("A"));
        $("#column-b").shouldHave(exactText("B"));

        // Запрограммируйте Drag&Drop с помощью Selenide.actions()
        $("#column-b").hover();
        actions().clickAndHold().moveByOffset(-200, 0).release().perform();

        // проверяем итоговое расположение элементов после dragAndDrop
        $("#column-a").shouldHave(exactText("B"));
        $("#column-b").shouldHave(exactText("A"));
    }

    @Test
    void dragAndDropHerokuAppWithActions2Test() {

        open("https://the-internet.herokuapp.com/drag_and_drop");

        SelenideElement source = $("#column-a");
        SelenideElement target = $("#column-b");

        // проверяем начальное расположение элементов
        source.shouldHave(exactText("A"));
        target.shouldHave(exactText("B"));

        // Запрограммируйте Drag&Drop с помощью Selenide.actions(), второй вариант реализации
        source.hover();
        actions().clickAndHold().moveToElement(target).release().perform();

        // проверяем итоговое расположение элементов после dragAndDrop
        source.shouldHave(exactText("B"));
        target.shouldHave(exactText("A"));
    }
}