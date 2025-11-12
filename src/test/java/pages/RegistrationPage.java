package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static examples.Constants.TITLE_TEXT;

public class RegistrationPage {

    Components components = new Components();

    private SelenideElement practiceFormSelector = $(".practice-form-wrapper"),
                            firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            emailInput = $("#userEmail"),
                            genderButton = $("#genterWrapper"),
                            phoneNumber = $("#userNumber");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        practiceFormSelector.shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderButton.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumber.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        components.setDate(day, month, year);
        return this;
    }
}
