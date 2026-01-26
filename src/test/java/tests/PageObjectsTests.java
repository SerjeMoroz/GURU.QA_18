package tests;

import com.codeborne.selenide.Selenide;
import examples.BaseTest;
import examples.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.RegistrationPage;
import pages.components.RegistrationResultModal;

import static examples.Faker.*;


public class PageObjectsTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage();
        registrationPage.setUserInformation(firstName(), lastName(), userEmail(), phoneNumber());
        registrationPage.setBirthDate(dayOfBirth(), monthOfBirth(), yearOfBirth());
        registrationPage.setGenderHobbie(userGender(), userHobbie());
        registrationPage.setSubjectAndUploadPicture(userSubject());
        registrationPage.setAddress(userAddress(), userState(), userCity());
        Selenide.sleep(3000);

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
        Selenide.sleep(3000);
        registrationResultModal.closeModalWindow();
    }

}
