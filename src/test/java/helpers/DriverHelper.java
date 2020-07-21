package helpers;

import com.codeborne.selenide.Configuration;
import drivers.CustomMobileDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static helpers.EnvironmentHelper.isAndroid;
import static helpers.EnvironmentHelper.isIos;


public class DriverHelper {

    public static void configureSelenide() {
        Configuration.browser = CustomMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    public static By byTestId(String testId) {
        if (isAndroid) {
            return MobileBy.xpath("//*[@content-desc='" + testId + "']");
        } else if (isIos) {
            return MobileBy.id(testId);
        } else {
            return by("some-desktop-attribute-name", testId);
        }
    }
    public static String getSessionId(){
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid","");
    }
//
//    public static String getConsoleLogs() {
//        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
//    }

}