package ru.safron.docs;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExample {

    void cssXpathExamples(){
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">

        $("[data-testid=email]");
        $(by("data-testid", "email"));

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">

        $("#email");
        $(byId("email"));
        $(By.id("email"));
        $("[id=email]");
        $("[id='email']");
        $("[id=\"email\"]");
        $(by("id", "email"));
        $x("//*[@id='email']");
        $(byXpath("//*[@id='email']"));

        $("input#email]");
        $("input[id=email]");

        // <input type="email" class="inputtext login_form_input_box" name="email">

        $("[name=email]");
        $(byName("email"));

        // <input type="email" class="inputtext login_form_input_box">

        $(byClassName("login_form_input_box"));
        $(".login_form_input_box");
        $(".inputtext.login_form_input_box");
    }
}
