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
                            hobbieCheckBox = $("#hobbiesWrapper"),
                            subjectInput = $("#subjectsInput"),
                            addressInput = $("#currentAddress"),
                            stateModal = $("#state"),
                            city = $("#city"),
                            submitButton = $("#submit"),
                            uploadPicture = $("#uploadPicture");


//    public void removeFooters() {
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('#footer').remove()");
//    }

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        practiceFormSelector.shouldHave(text(TITLE_TEXT));
    }

    public void setUserInformation(String firstName, String lastName, String email, String phone) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        emailInput.setValue(email);
        phoneNumber.setValue(phone);
    }

    public void setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        components.setDate(day, month, year);
    }

    public void setGenderAndHobbie(String gender, String hobbie) {
        genderButton.$(byText(gender)).click();
        hobbieCheckBox.$(byText(hobbie)).click();
    }

    public void setSubjectAndUploadPicture(String value) {
        subjectInput.setValue(value).pressEnter();
        uploadPicture.uploadFile(new File("src/test/resources/img/BlueBird.jpg"));
    }

    public void setAddress(String address, String state, String userCity) {
        addressInput.setValue(address);
        stateModal.scrollTo().click();
        $("#react-select-3-option-0").click();
        city.click();
        $("#react-select-4-option-1").click();
        submitButton.click();
    }

    public void registrationResultModalAppears() {
        registrationResultModal.verifyModalAppears();
    }

    public void verifyModalWindowResult(String key, String value) {
        registrationResultModal.verifyModalResult(key, value);
    }

}
