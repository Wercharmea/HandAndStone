package tests;

import drivers.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ru.stqa.selenium.factory.WebDriverFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

@Listeners(value = AllureTestListener.class)
public class BaseTest {
    protected Browser browser;
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional String browserName) {
        this.browser = new Browser();
        driver = this.browser.getDriver(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30L, SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        WebDriverFactory.dismissAll();
    }
}