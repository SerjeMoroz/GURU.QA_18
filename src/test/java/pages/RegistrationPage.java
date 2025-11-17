package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Components;
import pages.components.RegistrationResultModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static examples.Constants.TITLE_TEXT;

public class RegistrationPage {

    Components components = new Components();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    private SelenideElement practiceFormSelector = $(".practice-form-wrapper"),
                            firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            emailInput = $("#userEmail"),
                            genderButton = $("#genterWrapper"),
                            phoneNumber = $("#userNumber"),
                            dateOfBirthInput = $("#dateOfBirthInput"),
                            hobbieCheckBox = $("label[for='hobbies-checkbox-3']"),
                            subjectInput = $("#subjectsInput"),
                            addressInput = $("#currentAddress"),
                            stateModal = $("#state"),
                            city = $("#city"),
                            submitButton = $("#submit");

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
        dateOfBirthInput.click();
        components.setDate(day, month, year);
        return this;
    }
    public RegistrationPage registrationResultModalAppears() {
       registrationResultModal.verifyModalAppears();
       return this;
    }

    public RegistrationPage verifyModalWindowResult(String key, String value) {
        registrationResultModal.verifyModalResult(key, value);
        return this;
    }

    public RegistrationPage clickHobbieCCheckBox() {
        hobbieCheckBox.click();
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage uploadPicture() {
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/BlueBird.jpg"));
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateModal.scrollTo().click();
        $("#react-select-3-option-0").click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        $("#react-select-4-option-1").click();
        submitButton.click();
        return this;
    }

}
