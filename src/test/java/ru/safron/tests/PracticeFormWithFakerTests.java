package ru.safron.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.safron.pages.PracticePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormWithFakerTests extends TestBase {

    PracticePage practicePage = new PracticePage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phone = faker.phoneNumber().cellPhone(),
            address = faker.address().fullAddress();



    @Test
    void FillPracticeForm(){

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue(phone);

        practicePage.calendar.setDate("17", "July", "1990");


        //subjects
        $("#subjectsInput").setValue("Computer Science").pressEnter();

        $("[for=hobbies-checkbox-1]").click();
        $("#currentAddress").setValue(address);

        //state
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        //$("#react-select-3-input").pressEnter();

        //city
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        //output form
        $(".table-responsive").shouldHave(text(firstName +" "+ lastName));
        $(".table-responsive").shouldHave(text(email));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text(phone));
        //$(".table-responsive").shouldHave(text(calendarComponent.toString()));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text(address));
        $(".table-responsive").shouldHave(text("NCR Delhi"));


        //sleep(5000);

    }
}
