package tests;

import examples.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class firstTest extends BaseTest {

    @Test
    void firsTestOpen() {
        open("/automation-practice-form");

        $("#firstName").setValue("Serje");
        $("#lastName").setValue("Moroz");
        $("#userEmail").setValue("SerjeMoroz@gmail.com");
        $("label[for='gender-radio-1']").parent().click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--016:not(react-datepicker__day--weekend)").click();
        $("label[for='hobbies-checkbox-3']").click();
        $("#subjectsInput").setValue("English").pressEnter();
//        $("#uploadPicture").uploadFile(new File("BlueBird.jpg"));
        $("#currentAddress").setValue("Пушкина колотушкина 54");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();
    }
}
