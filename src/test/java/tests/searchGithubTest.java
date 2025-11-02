package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class searchGithubTest {

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
}
