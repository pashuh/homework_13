package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import credentials.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void beForAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";

        String browserResolution = System.getProperty("resolution", "1920x1080");
        Configuration.browserSize = browserResolution;
        String browserVersion = System.getProperty("version", "100");
        Configuration.browserVersion = browserVersion;
        String remoteBrowser = System.getProperty("remote", "selenoid.autotests.cloud/wd/hub");
        CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class);
        Configuration.remote = "https://" + credentialsConfig.login() + ":" + credentialsConfig.password() + "@" + remoteBrowser;
        String browserOption = System.getProperty("browser", "chrome");
        Configuration.browser = browserOption;
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
