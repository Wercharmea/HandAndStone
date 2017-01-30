package blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BookingPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by bigdrop on 1/30/2017.
 */
public class ProgressBarBlock {

    public static WebDriver driver;
    public By progressBarLocator = By.xpath("//div[@class='step-area']//li");
    public By firstStep = By.xpath("//li[contains(@class,'active')]");
    public static ProgressBarBlock barBlock = new ProgressBarBlock();

    public ProgressBarBlock() {
     }

    public String getTitleOfProgressBar() {
        String actualTitle = "";
        List<WebElement> progressBar = driver.findElements(progressBarLocator);

        for (int i = 0; i < progressBar.size(); i++) {
            if (progressBar.get(i).getAttribute("class").equalsIgnoreCase("active") == true) {
                actualTitle = progressBar.get(i).getAttribute("data-title");
            }
        }
        return actualTitle;
    }

    public boolean verifyTitleOfProgressBar(){

        String expectedResult = "Choose Services";
        return getTitleOfProgressBar().contains(expectedResult);

    }

 /*  public ProgressBarBlock (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
*/

    public static void main(String[] args){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://handandstone.bigdropinc.net/booking.html");
        System.out.print(barBlock.verifyTitleOfProgressBar());
    }
}
