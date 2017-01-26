package blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import java.util.List;

/**
 * Created by bigdrop on 1/23/2017.
 */

public class ProgressBarBlock {
    private WebDriver driver;

    //public static By progressBarLocator = By.xpath("//div[@class='step-area']//li");
    public By firstStep = By.xpath("//li[contains(@class,'active')]");
    public String URL = "http://handandstone.bigdropinc.net/booking.html";

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        /*DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox");
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\chrome.exe");*/
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome\\chromedriver.exe");
       /* options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);*/
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void test(){
        String expectedResult = "Choose Services";
        driver.findElement(firstStep);
        if (firstStep.toString() == expectedResult){
            System.out.print("Success");
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

   /* public String getTitleOfProgressBar() {
        String actualTitle = "";
        List<WebElement> progressBar = driver.findElements(progressBarLocator);
        for (int i = 0; i < progressBar.size(); i++) {
            if (progressBar.get(i).getAttribute("class").equalsIgnoreCase("active") == true) {
                actualTitle = progressBar.get(i).getAttribute("data-title");

            }
            System.out.print(actualTitle);
        }
        return actualTitle;
    }
*/

}