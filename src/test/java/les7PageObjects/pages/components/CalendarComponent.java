package les7PageObjects.pages.components;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class CalendarComponent {

    private final ElementsCollection dayInCalendar = $$("div.react-datepicker__day");
    private final SelenideElement monthInCalendar = $(".react-datepicker__month-select"),
            yearInCalendar = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        yearInCalendar.selectOption(year);
        monthInCalendar.selectOption(month);
        dayInCalendar.findBy(text(day)).click();
    }
}