package helpers;


public class EnvironmentHelper {

// BROWSERSTACK CONFIG
    public static final String
        bsLogin = System.getProperty("bs_login", ""),
        bsPassword = System.getProperty("bs_password", ""),
        platform = System.getProperty("platform", "android");

// CI CONFIG (jenkins)
    public static final String
        buildNumber = System.getProperty("build_number", "0"),
        jobBaseName = System.getProperty("job_base_name", "local");

// ANDROID CONFIG
    public static final boolean isAndroid = platform.equals("android");
    public static final String
        androidDevice = System.getProperty("mobile_device", "Google Pixel 3"),
        androidVersion = System.getProperty("mobile_version", "9.0"),
        androidBrowserstackApp = System.getProperty("bs_app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

// IOS CONFIG
    public static final boolean isIos = platform.equals("ios");
    public static final String
        iosDevice = System.getProperty("mobile_device", "iPhone 11 Pro Max"),
        iosVersion = System.getProperty("mobile_version", "13.2"),
        iosBrowserstackApp = System.getProperty("bs_app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

}
