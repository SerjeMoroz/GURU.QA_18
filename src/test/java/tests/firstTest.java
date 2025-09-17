package tests;

import examples.BaseTest;
import org.junit.jupiter.api.Test;

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

        $("#currentAddress").setValue("Пушкина колотушкина 54");
    }
}
