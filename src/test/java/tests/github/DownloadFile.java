package tests.github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DownloadFile {




    @Test
    void firstDowloadFile() throws Exception {

        open("https://github.com/qa-guru/niffler/blob/master/README.md");
        getWebDriver().manage().window().maximize();

//        File download = $("button[data-testid='download-raw-button']").download();

        Configuration.fileDownload = FileDownloadMode.FOLDER;
        File download = $("button[data-testid='download-raw-button']").download();
        try (InputStream is = new FileInputStream(download)) {
            byte [] bytes = is.readAllBytes();
            String fileAsString = new String(bytes, StandardCharsets.UTF_8);
            Assertions.assertTrue(fileAsString.contains("Технологии, использованные в Niffler 2.0"));
        }

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }


    @Test
    void secondDowloadFile() throws Exception {
        Selenide.open("https://tus.io/demo.html");
        getWebDriver().manage().window().maximize();
        $("input[type='file']").uploadFromClasspath("img/BlueBird.jpg");
        $(byXpath("//p[@class='_heading_gq6c0_21']")).shouldHave(text("The upload is complete!"));
        sleep(3000);
    }

}
