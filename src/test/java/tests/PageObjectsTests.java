package tests;

import com.codeborne.selenide.Selenide;
import examples.BaseTest;
import examples.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import pages.RegistrationPage;
import pages.components.RegistrationResultModal;

import static examples.Faker.*;


public class PageObjectsTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    @CsvSource(value = {
            "Male",
            "Female",
            "Other"
    })
    @ParameterizedTest(name = "указываем {0} для обозначения гендера")
    void successfulRegistration(String testData) {
        registrationPage.openPage();
        registrationPage.setUserInformation(firstName(), lastName(), userEmail(), phoneNumber());
        registrationPage.setBirthDate(dayOfBirth(), monthOfBirth(), yearOfBirth());
        registrationPage.setGenderHobbie(testData, userHobbie());
        registrationPage.setSubjectAndUploadPicture(userSubject());
        registrationPage.setAddress(userAddress(), userState(), userCity());
        Selenide.sleep(1000);

        registrationPage.registrationResultModalAppears();
        registrationPage.verifyModalWindowResult("Student name", firstName() + lastName());
        registrationPage.verifyModalWindowResult("Student Email", userEmail());
        registrationPage.verifyModalWindowResult("Gender", userGender());
        registrationPage.verifyModalWindowResult("Mobile",  phoneNumber());
        registrationPage.verifyModalWindowResult("Date of birth", dayOfBirth() + monthOfBirth() + yearOfBirth());
        registrationPage.verifyModalWindowResult("Subjects", userSubject());
        registrationPage.verifyModalWindowResult("Hobbies", userHobbie());
        registrationPage.verifyModalWindowResult("Picture", "BlueBird.jpg");
        registrationPage.verifyModalWindowResult("State and City", userState() + userCity());
        Selenide.sleep(1000);
        registrationResultModal.closeModalWindow();
    }

}
