package ru.safron.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        String permamentAddress = "some street 1";


        open("https://demoqa.com/text-box");
        $("#userName").setValue("Eclipse");
        $("#userEmail").setValue("Eclipse@mail.ru");
        $("input#currentAddress").setValue("Qwe");
        $("#permanentAddress").setValue(permamentAddress);
        $("#submit").click();

        $("#output #name").shouldHave(text("Eclipse"));
        $("#output #email").shouldHave(text("Eclipse@mail.ru"));
        $("#output p#currentAddress").shouldHave(text("Qwe"));
        $("#output #permanentAddress").shouldHave(text(permamentAddress));
    }
}
