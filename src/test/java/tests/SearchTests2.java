package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchTests2 {

    @DisplayName("Тест на поиск в github слова Selenide")
    @Test
    void searchGitHubTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу GitHub", () -> {
                    open("https://github.com");
                });
        step("Вводим текст поиска и нажимаем Enter", () -> {
             $("span[class='flex-1']").click();
             $("#query-builder-test").setValue("Selenide").pressEnter();
         });
        step("Кликаем на первый в поиске результат", () -> {
             $$(By.xpath("//div[@class='Search-module__columnLeftWrapper__rycTi']" +
                     "//div[@class='search-title Header-module__title__QUX7e']")).first().click();
             $("#wiki-tab").click();
             $(By.xpath("//a[normalize-space()='Soft assertions']")).click();
         });
        step("Верифицируем результат", () -> {
             $("#wiki-body").shouldHave(text("JUnit5 extension - com.codeborne.selenide.junit5.SoftAssertsExtension"));
         });
    }

    @DisplayName("Поиск слова 'Solutions' в github")
    @Test
    void solutionsTestGithub() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "2560x1440";
        open("https://github.com");
        $(By.xpath("//button[normalize-space()='Solutions']")).hover();
        $(By.linkText("Enterprises")).click();
        $("#hero-section-brand-heading").shouldBe(visible).
                shouldHave(text("The AI-powered developer platform for the agent-ready enterprise"));
        Selenide.closeWebDriver();
    }

}
