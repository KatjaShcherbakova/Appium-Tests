package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static helpers.BrowserstackHelper.getBrowserstackUrl;
import static helpers.EnvironmentHelper.*;

public class CustomMobileDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        if (isAndroid) {
            return getAndroidDriver();
        } else if (isIos) {
            return getIosDriver();
        } else {
            return null;
        }
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", "Appium_tests");
        capabilities.setCapability("build", jobBaseName);
        capabilities.setCapability("name", "Tests - " + platform + " - " + buildNumber);
        capabilities.setCapability("autoGrantPermissions", "true");

        return capabilities;
    }

    public AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("device", androidDevice);
        capabilities.setCapability("os_version", androidVersion);
        capabilities.setCapability("app", androidBrowserstackApp);

        return new AndroidDriver(getBrowserstackUrl(), capabilities);
    }

    public IOSDriver getIosDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("device", iosDevice);
        capabilities.setCapability("os_version", iosVersion);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("app", iosBrowserstackApp);

        return new IOSDriver(getBrowserstackUrl(), capabilities);
    }
}