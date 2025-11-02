package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class searchGithubTest {

    @Test
    void searchGithub() {
        Configuration.browserSize = "1920x1080";
        open("https://github.com/");
        $("span[class='flex-1']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $$(By.xpath("//div[@class='Box-sc-62in7e-0 flaXet']//div[@class='Box-sc-62in7e-0 lnrylK search-title']")).first().click();
        $("#wiki-tab").click();
        $(By.xpath("//a[normalize-space()='Soft assertions']")).click();
        $("#wiki-body").shouldHave(text("JUnit5 extension - com.codeborne.selenide.junit5.SoftAssertsExtension"));
        sleep(4000);
    }
}
