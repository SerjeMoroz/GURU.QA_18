package tests;

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
    Faker faker = new Faker();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                    .setFirstName(firstName())
                    .setLastName(lastName())
                    .setEmail(userEmail())
                    .setGender(userGender())
                    .setPhoneNumber(phoneNumber())
                    .setBirthDate(dayOfBirth(), monthOfBirth(), yearOfBirth())
                    .clickHobbieCheckBox()
                    .setSubject(userSubject())
                    .uploadPicture()
                    .setAddress(userAddress())
                    .setState(userState())
                    .setCity(userCity());

        registrationPage.registrationResultModalAppears()
                            .verifyModalWindowResult("Student name", firstName() + lastName())
                            .verifyModalWindowResult("Student Email", userEmail())
                            .verifyModalWindowResult("Gender", "Male")
                            .verifyModalWindowResult("Mobile",  phoneNumber())
                            .verifyModalWindowResult("Date of birth", dayOfBirth() + monthOfBirth() + yearOfBirth())
                            .verifyModalWindowResult("Subjects", userSubject())
                            .verifyModalWindowResult("Hobbies", userHobbie())
                            .verifyModalWindowResult("Picture", "BlueBird.jpg")
                            .verifyModalWindowResult("State and City", userState() + userCity());
        registrationResultModal.closeModalWindow();
    }

}
