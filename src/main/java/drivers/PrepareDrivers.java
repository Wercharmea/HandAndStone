package drivers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PrepareDrivers {
    public static DesiredCapabilities capabilities;

    public static DesiredCapabilities prepareFirefox() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");
        capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        return capabilities;
    }

    public static DesiredCapabilities prepareChrome() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
        capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox");
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return capabilities;
    }
    public static DesiredCapabilities prepareEDGE() {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\MicrosoftWebDriver.exe");
        capabilities = DesiredCapabilities.edge();
        EdgeOptions options = new EdgeOptions();
        capabilities.setCapability(EdgeOptions.CAPABILITY, options);
        return capabilities;
    }

    public static DesiredCapabilities prepareRemoteFirefoxDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WIN10);
        capabilities.setVersion("50.0.1");
        return capabilities;
    }

}

