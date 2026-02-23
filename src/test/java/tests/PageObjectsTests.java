package tests;

import com.codeborne.selenide.Selenide;
import examples.BaseTest;
import examples.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import pages.RegistrationPage;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Selenide.sleep;
import static examples.Faker.*;


public class PageObjectsTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    @DisplayName("Проверка регистрации разных гендеров")
//    @CsvSource(value = {
//            "Male",
//            "Female",
//            "Other"
//    })
    @Tag("Smoke")
    @CsvFileSource (resources = "/testdata/fileNameGender.csv")
    @ParameterizedTest(name = "гендер: {0} и хобби:{1}")
    void successfulRegistration(String testData, String hobby) {
        registrationPage.openPage();
        registrationPage.setUserInformation(firstName(), lastName(), userEmail(), phoneNumber());
        registrationPage.setBirthDate(dayOfBirth(), monthOfBirth(), yearOfBirth());
        registrationPage.setGenderAndHobbie(testData, hobby);
        registrationPage.setSubjectAndUploadPicture(userSubject());
        registrationPage.setAddress(userAddress(), userState(), userCity());

        registrationPage.registrationResultModalAppears();
        registrationPage.verifyModalWindowResult("Student name", firstName() + lastName());
        registrationPage.verifyModalWindowResult("Student Email", userEmail());
        registrationPage.verifyModalWindowResult("Gender", testData);
        registrationPage.verifyModalWindowResult("Mobile",  phoneNumber());
        registrationPage.verifyModalWindowResult("Date of birth", dayOfBirth() + monthOfBirth() + yearOfBirth());
        registrationPage.verifyModalWindowResult("Subjects", userSubject());
        registrationPage.verifyModalWindowResult("Hobbies", hobby);
        registrationPage.verifyModalWindowResult("Picture", "BlueBird.jpg");
        registrationPage.verifyModalWindowResult("State and City", userState() + userCity());
        registrationResultModal.closeModalWindow();
    }

}
