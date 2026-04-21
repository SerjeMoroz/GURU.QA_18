package tests.github;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubStepsMethods {

    @Step("Открываем главную страницу GitHub")
    public void openGitHub() {
        open("https://github.com");
    }

    @Step("Вводим текст поиска и нажимаем Enter")
    public void enterTextAndPressEnterGithub() {
        $("span[class='flex-1']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
    }

    @Step("Кликаем на первый в поиске результат")
    public void clickFirstSearhResultGithub() {
        $$(By.xpath("//div[@class='Box-sc-62in7e-0 flaXet']//div[@class='Box-sc-62in7e-0 lnrylK search-title']")).first().click();
        $("#wiki-tab").click();
        $(By.xpath("//a[normalize-space()='Soft assertions']")).click();
    }

    @Step("Верифицируем результат")
    public void verifyResultGithub() {
        $("#wiki-body").shouldHave(text("JUnit5 extension - com.codeborne.selenide.junit5.SoftAssertsExtension"));
    }
}

