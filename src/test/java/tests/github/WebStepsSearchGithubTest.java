package tests.github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Story;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import tests.github.GitHubStepsMethods;


public class WebStepsSearchGithubTest extends GitHubStepsMethods {

    GitHubStepsMethods gitHubStepsMethods = new GitHubStepsMethods();
    GitHubStepsMethods steps = new GitHubStepsMethods();
    @Test
    @Story("Проверка github allure")
    @DisplayName("Проверка теста с шагами allure вынесенными в отдельный класс")
    public void searchGithubWithAnnotationsStep() {
        steps.openGitHub();
        steps.enterTextAndPressEnterGithub();
        steps.clickFirstSearhResultGithub();
        steps.verifyResultGithub();
    }
}
