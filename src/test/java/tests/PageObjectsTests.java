package tests;

import examples.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.RegistrationPage;
import pages.components.RegistrationResultModal;


public class PageObjectsTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    @Test
    void successfulRegistrationTest() {

        String userName = "Serje";
        String lastName = "Moroz";
        String userEmail = "SerjeMoroz@gmail.com";
        String phoneNumber = "0123456789";
        String subject = "English";
        String address = "Пушкина колотушкина 54";

        registrationPage.openPage()
                    .setFirstName(userName)
                    .setLastName(lastName)
                    .setEmail(userEmail)
                    .setGender("Other")
                    .setPhoneNumber(phoneNumber)
                    .setBirthDate("16", "August", "2000")
                    .clickHobbieCCheckBox()
                    .setSubject(subject)
                    .uploadPicture()
                    .setAddress(address)
                    .setState()
                    .setCity();



        registrationPage.registrationResultModalAppears()
                            .verifyModalWindowResult("Student name", userName + lastName)
                            .verifyModalWindowResult("Student Email", userEmail)
                            .verifyModalWindowResult("Gender", "Male")
                            .verifyModalWindowResult("Mobile",  phoneNumber)
                            .verifyModalWindowResult("Date of birth", "17 August,2000")
                            .verifyModalWindowResult("Subjects", subject)
                            .verifyModalWindowResult("Hobbies", "Music")
                            .verifyModalWindowResult("Picture", "BlueBird.jpg")
                            .verifyModalWindowResult("State and City", "NCR Delhi");
        registrationResultModal.closeModalWindow();

//        $(By.xpath("//td[normalize-space()='Student Name']/following-sibling::td[normalize-space()='Serje Moroz']"));
//        $(By.xpath("//td[normalize-space()='Student Email']/following-sibling::td[normalize-space()='SerjeMoroz@gmail.com']"));
//        $(By.xpath("//td[normalize-space()='Gender']/following-sibling::td[normalize-space()='Male']"));
//        $(By.xpath("//td[normalize-space()='Mobile']/following-sibling::td[normalize-space()='0123456789']"));
//        $(By.xpath("//td[normalize-space()='Date of Birth']/following-sibling::td[normalize-space()='17 August,2000']"));
//        $(By.xpath("//td[normalize-space()='Subjects']/following-sibling::td[normalize-space()='English']"));
//        $(By.xpath("//td[normalize-space()='Hobbies']/following-sibling::td[normalize-space()='Music']"));
//        $(By.xpath("//td[normalize-space()='Picture']/following-sibling::td[normalize-space()='BlueBird.jpg']"));
//        $(By.xpath("//td[normalize-space()='State and City']/following-sibling::td[normalize-space()='NCR Delhi']"));

    }
}
