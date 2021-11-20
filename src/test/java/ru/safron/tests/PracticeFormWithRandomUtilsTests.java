package ru.safron.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.safron.utils.RandomUtils.*;

public class PracticeFormWithRandomUtilsTests extends TestBase {

    String firstName = getRandomString(10),
            lastName = getRandomString(10),
            email = getRandomEmail(),
            phone = getRandomPhone();

    @Test
    void FillPracticeForm(){

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue(phone);

        //17 Jul 1990 datebirth
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__week .react-datepicker__day--017").click();

        //subjects
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        //$("#subjectsInput").pressEnter();

        //file
        //$("#uploadPicture").uploadFromClasspath("img/1.png");
        //$("#subjectsInput").pressEnter();


        $("[for=hobbies-checkbox-1]").click();
        $("#currentAddress").setValue("Bla-bla-bla");

        //state
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        //$("#react-select-3-input").pressEnter();

        //city
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        //$("#react-select-4-input").pressEnter();

        $("#submit").click();

        //output form
        $(".table-responsive").shouldHave(text(firstName +" "+ lastName));
        $(".table-responsive").shouldHave(text("Safronova@mail.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("7771112233"));
        $(".table-responsive").shouldHave(text("17 July,1990"));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Bla-bla-bla"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));


        //sleep(5000);
        //Selenide.closeWindow();
        //Selenide.closeWebDriver();


    }
}
