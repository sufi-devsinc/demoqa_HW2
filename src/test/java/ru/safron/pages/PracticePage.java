package ru.safron.pages;

import com.codeborne.selenide.SelenideElement;
import ru.safron.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticePage {

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form_wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneInput = $("#userNumber");

    public CalendarComponent calendar = new CalendarComponent();

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));

    }

    public PracticePage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);

    }

    public void typeEmail(String value) {
        emailInput.setValue(value);

    }

    public void typePhone(String value) {
        phoneInput.setValue(value);

    }

    public void checkResultsValue(String key, String value) {
        $x("//td[text()='" + key + "']").parent().shouldHave(text(value));

    }

}
