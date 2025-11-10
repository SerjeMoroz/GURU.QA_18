package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchGithubTest {

    @Test
    void searchGithub() {
        Configuration.browserSize = "2560x1440";
        open("https://github.com");
        $("span[class='flex-1']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $$(By.xpath("//div[@class='Box-sc-62in7e-0 flaXet']//div[@class='Box-sc-62in7e-0 lnrylK search-title']")).first().click();
        $("#wiki-tab").click();
        $(By.xpath("//a[normalize-space()='Soft assertions']")).click();
        $("#wiki-body").shouldHave(text("JUnit5 extension - com.codeborne.selenide.junit5.SoftAssertsExtension"));
        Selenide.closeWebDriver();
    }

    @Test
    void solutionsTestGithub() {
        Configuration.browserSize = "2560x1440";
        open("https://github.com");
        $(By.xpath("//button[normalize-space()='Solutions']")).hover();
        $(By.linkText("Enterprises")).click();
        $("#hero-section-brand-heading").shouldBe(visible).
                shouldHave(text("The AI-powered developer platform for the agent-ready enterprise"));
        Selenide.closeWebDriver();
    }
    @Test
    void firsTestOpen() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#footer').remove()");
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
        $("#uploadPicture").uploadFile(new File("src/test/resources/BlueBird.jpg"));
        $("#currentAddress").setValue("Пушкина колотушкина 54");
        $("#state").scrollTo().click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();
        $(".modal-content").shouldBe(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
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
