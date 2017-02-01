package drivers;

import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import java.util.logging.Logger;

public class Browser {
    private WebDriver driver;
    private static final Logger LOG = Logger.getLogger("PrepareDrivers");

    public WebDriver getDriver(String browser) {
        WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
        if (browser == null)
            browser = "UNKNOWN BROWSER INPUT";
        switch (browser.toUpperCase()) {
            case "FIREFOX":
                LOG.info("MyWebDriverFactory: browser FF. ");
                return driver = WebDriverFactory.getDriver(PrepareDrivers.prepareFirefox());

            case "CHROME":
                LOG.info("MyWebDriverFactory: browser Chrome. ");
                return driver = WebDriverFactory.getDriver(PrepareDrivers.prepareChrome());

            case "EDGE":
                LOG.info("MyWebDriverFactory: browser EDGE. ");
                return driver = WebDriverFactory.getDriver(PrepareDrivers.prepareEDGE());

            default:
                LOG.info("MyWebDriverFactory: browser unknown. Default option - Chrome");
                return driver = WebDriverFactory.getDriver(PrepareDrivers.prepareChrome());
        }
    }
}


