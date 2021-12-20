package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selenide.*;

public class TroykaFitnessVoiding {
    @Test
    void TroikaTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-infobars");

        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.startMaximized = true;

        while (true) {

            open("https://myslo.ru/project/choice/c0734ac4-3755-423e-84d5-6179d17d7c56");

            while (true) {

                sleep(500);

                SelenideElement element = $(byPartialLinkText("Тройка фитнес"));
                SelenideElement nextButton = $(".header .float-right");
                if (element.exists()) {
                    element.click();
                    sleep(2000);
                    break;
                }
                if (nextButton.exists()) {
                    nextButton.click();
                } else {
                    break;
                }
            }

            clearBrowserCookies();
            clearBrowserLocalStorage();
            refresh();

        }
    }
}
