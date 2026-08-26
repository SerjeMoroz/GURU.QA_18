package examples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Map;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.WebDriverRunner;

public class BaseTest {

    @BeforeAll
    static void setupClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--disable-notifications",
                "--disable-search-engine-choice-screen",
                "--disable-features=OptimizationGuideModelDownloading,OptimizationHintsFetching,OptimizationTargetPrediction,OptimizationHints",
                "--disable-cache",
                "--ignore-certificate-errors",
                "--no-sandbox", "--disable-dev-shm-usage"
// "--unsafely-treat-insecure-origin-as-secure=хттпсайт"
        );

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
// options.setAcceptInsecureCerts(true);
// options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//
// options.setCapability("selenoid:options", Map.of(
// "enableVNC", true,
// "enableVideo", true
// ));

// Configuration.browserCapabilities = options;

        Configuration.remote = "https://qa_engineer:-aAb_-4gs53FD@selenoid.qa.guru/wd/hub";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("version", "151");
        Configuration.browserSize = System.getProperty("size", "1920x1080");
// Configuration.baseUrl = "https://demoqa.com/";
        Configuration.fastSetValue = false;
        Configuration.headless = false;

    }

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener(
                "AllureSelenide", new AllureSelenide()
        );
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }
}