package blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by bigdrop on 1/30/2017.
 */
public class ProgressBarBlock {

    public static WebDriver driver;
    public By progressBarLocator = By.xpath("//div[@class='step-area']//li");


    //   @FindBy (xpath = "//li[contains(@class,'active')]")
//    public WebElement firstStep;
    public ProgressBarBlock() {


    }

    public String getTitleOfProgressBar() {
        Wait wait = new FluentWait(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(progressBarLocator));
        String actualTitle = "";
        List<WebElement> progressBar = driver.findElements(progressBarLocator);

        for (int i = 0; i < progressBar.size(); i++) {
            if (progressBar.get(i).getAttribute("class").equalsIgnoreCase("active") == true) {
                actualTitle = progressBar.get(i).getAttribute("data-title");
            }
        }
        return actualTitle;
    }

    public boolean verifyTitleOfProgressBar() {

        String expectedResult = "Choose Services";
        return getTitleOfProgressBar().contains(expectedResult);

    }

    public ProgressBarBlock(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
