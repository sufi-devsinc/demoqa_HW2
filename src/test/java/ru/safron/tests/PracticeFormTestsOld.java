package ru.safron.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTestsOld {
    @BeforeAll
    static void beforeAll(){
        Configuration.startMaximized = true;
    }

    @Test
    void FillPracticeForm(){

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Ekaterina");
        $("#lastName").setValue("Safronova");
        $("#userEmail").setValue("Safronova@mail.ru");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("7771112233");

        //17 Jul 1990 datebirth
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__week .react-datepicker__day--017").click();

        //subjects
        $("#subjectsInput").setValue("Computer Science");
        $("#subjectsInput").pressEnter();

        $("[for=hobbies-checkbox-1]").click();
        $("#currentAddress").setValue("Bla-bla-bla");

        //state
        $("#state").click();
        $("#react-select-3-input").setValue("NCR");
        $("#react-select-3-input").pressEnter();

        //city
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi");
        $("#react-select-4-input").pressEnter();

        $("#submit").click();

        //output form
        $(".table-responsive").shouldHave(text("Ekaterina Safronova"));
        $(".table-responsive").shouldHave(text("Safronova@mail.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("7771112233"));
        $(".table-responsive").shouldHave(text("17 July,1990"));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Bla-bla-bla"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

    }
}
