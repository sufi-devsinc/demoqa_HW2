package ru.safron.tests;

import org.junit.jupiter.api.Test;
import ru.safron.pages.PracticePage;
import ru.safron.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.safron.tests.TestData.firstName;
import static ru.safron.tests.TestData.lastName;

public class PracticeFormWithPageObjectTests extends TestBase {

    PracticePage practicePage = new PracticePage();

    @Test
    void FillPracticeForm(){
        practicePage.openPage();

        practicePage.typeFirstName(firstName)
                    .typeLastName(lastName);

        $("#userEmail").setValue("Safronova@mail.ru");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("7771112233");

        practicePage.calendar.setDate("17", "July", "1990");

        //subjects
        $("#subjectsInput").setValue("Computer Science").pressEnter();
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

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        practicePage.checkResultsValue("Student Name", firstName +" "+ lastName);

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
