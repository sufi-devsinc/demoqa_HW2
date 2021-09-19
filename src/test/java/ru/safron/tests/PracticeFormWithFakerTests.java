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
            phone = faker.phoneNumber().subscriberNumber(10),
            address = faker.address().fullAddress(),
            subject = "Computer Science",
            state = "NCR",
            city = "Delhi",
            sName = "Student Name",
            sEmail = "Student Email",
            dayBirth = "17 July,1990";

    @Test
    void FillPracticeForm(){

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue(phone);

        practicePage.calendar.setDate("17", "July", "1990");

        $("#subjectsInput").setValue(subject).pressEnter();

        $("[for=hobbies-checkbox-1]").click();

        $("#currentAddress").setValue(address);

        $("#state").click();
        $("#react-select-3-input").setValue(state).pressEnter();

        $("#city").click();
        $("#react-select-4-input").setValue(city).pressEnter();

        $("#submit").click();

        //output form
        $(".table-responsive").shouldHave(text(sName +" "+ firstName +" "+ lastName));
        $(".table-responsive").shouldHave(text(sEmail +" "+ email));
        $(".table-responsive").shouldHave(text("Gender" +" "+ "Female"));
        $(".table-responsive").shouldHave(text("Mobile" +" "+ phone));
        $(".table-responsive").shouldHave(text("Date of Birth" + " "+ dayBirth));
        $(".table-responsive").shouldHave(text("Subjects" +" "+ subject));
        $(".table-responsive").shouldHave(text("Hobbies" +" "+ "Sports"));
        $(".table-responsive").shouldHave(text("Address" +" "+ address));
        $(".table-responsive").shouldHave(text("State and City" +" "+ state + " "+ city));

    }
}
