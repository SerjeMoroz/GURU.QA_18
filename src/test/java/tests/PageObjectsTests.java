package tests;

import examples.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PageObjectsTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        String userName = "Serje";
        String lastName = "Moroz";
        String userEmail = "SerjeMoroz@gmail.com";
        String phoneNumber = "0123456789";

        registrationPage.openPage()
                    .setFirstName(userName)
                    .setLastName(lastName)
                    .setEmail(userEmail)
                    .setGender("Other")
                    .setPhoneNumber(phoneNumber)
                    .setBirthDate("16", "August", "2000")
                    .registrationResultModalAppears();

//        registrationPage.openPage();

        $("label[for='hobbies-checkbox-3']").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/BlueBird.jpg"));
        $("#currentAddress").setValue("Пушкина колотушкина 54");
        $("#state").scrollTo().click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        $(By.xpath("//td[normalize-space()='Student Name']/following-sibling::td[normalize-space()='Serje Moroz']"));
        $(By.xpath("//td[normalize-space()='Student Email']/following-sibling::td[normalize-space()='SerjeMoroz@gmail.com']"));
        $(By.xpath("//td[normalize-space()='Gender']/following-sibling::td[normalize-space()='Male']"));
        $(By.xpath("//td[normalize-space()='Mobile']/following-sibling::td[normalize-space()='0123456789']"));
        $(By.xpath("//td[normalize-space()='Date of Birth']/following-sibling::td[normalize-space()='17 August,2000']"));
        $(By.xpath("//td[normalize-space()='Subjects']/following-sibling::td[normalize-space()='English']"));
        $(By.xpath("//td[normalize-space()='Hobbies']/following-sibling::td[normalize-space()='Music']"));
        $(By.xpath("//td[normalize-space()='Picture']/following-sibling::td[normalize-space()='BlueBird.jpg']"));
        $(By.xpath("//td[normalize-space()='State and City']/following-sibling::td[normalize-space()='NCR Delhi']"));
        $("#closeLargeModal").click();
    }
}
