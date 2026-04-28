package examples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static examples.Faker.*;

public class BaseTest {

    @BeforeAll
    static void setupClass() {
        ChromeOptions options = new ChromeOptions();
        Configuration.browserCapabilities = options;
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-search-engine-choice-screen");
//        options.addArguments("--disable-features=OptimizationGuideModelDownloading,OptimizationHintsFetching,OptimizationTargetPrediction,OptimizationHints");
//        options.addArguments("--disable-cache");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--unsafely-treat-insecure-origin-as-secure=хттпсайт");
        Configuration.browser = "chrome";
        Configuration.headless = true;
//        Configuration.baseUrl = "https://demoqa.com";
        Configuration.fastSetValue = false;
//        Configuration.browserSize = "2560x1440";
    }

//    @BeforeEach
//    void setUp() {
////        open("/automation-practice-form");
////        getWebDriver().manage().window().maximize();
//    }

    @AfterEach
    void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}