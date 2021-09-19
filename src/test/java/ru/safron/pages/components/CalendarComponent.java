package ru.safron.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {

        //17 Jul 1990 datebirth
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__week .react-datepicker__day--0"+day).click();

    }


}
