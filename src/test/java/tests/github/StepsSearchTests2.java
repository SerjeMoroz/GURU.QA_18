package tests.github;

import examples.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepsSearchTests2 extends BaseTest {


    @Test
    void solutionsTestGithub() {
        open("https://github.com");
        $(By.xpath("//button[normalize-space()='Solutions']")).hover();
        $(By.linkText("Enterprises")).click();
        $(By.xpath("//div[@data-testid='contentful-bg-content']")).
                shouldHave(text("Bring your DevOps together"));
    }

    @Test
    void searchGitHubTestWithLambdaStep() {
        step("Открываем главную страницу GitHub", () -> {
            open("https://github.com");
        });
        step("Вводим текст поиска и нажимаем Enter", () -> {
            $(".HeaderSearch-module__content__kMpxU").click();
            $("input[placeholder='Search or jump to...']").setValue("Selenide").pressEnter();
        });
        step("Кликаем на первый в поиске результат", () -> {
            $$(By.xpath("//div[@class='search-title Header-module__title__EpJLU']")).first().click();
            $("#wiki-tab").click();
            $(By.xpath("//a[normalize-space()='Soft assertions']")).click();
        });
        step("Верифицируем результат", () -> {
            $("#wiki-body").shouldHave(text("Welcome to the Selenide wiki!"));
        });
    }

}
