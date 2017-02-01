package pages;

import blocks.ProgressBarBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by bigdrop on 1/30/2017.
 */
public class BookingPage extends BasePage {


    public String URL = "http://handandstone.bigdropinc.net/booking.html";
    public String serviceListLocator = "//div[contains(@class,'service-content')]//li";
    private ProgressBarBlock progressBarBlock;
    @FindBy(xpath = "//a[contains(.,'Book now')]")
    WebElement serviceType;

    public BookingPage(WebDriver driver) {
        super(driver);
        progressBarBlock = new ProgressBarBlock(driver);
    }

    public void chooseService() {
        WebElement serviceItem = driver.findElement(By.xpath(defineService()));

        if (progressBarBlock.verifyTitleOfProgressBar() == true) {
            System.out.println("serviceItemNewXpath=" + serviceItem);
            // serviceItem.click();
        } else {
            System.out.print("Progress Bar title is not on first step");
        }
    }

    public static int randomInt(int Min, int Max) {

        return (int) (Math.random() * (Max - Min)) + Min;
    }

    public void getServicePrice() { // method to find and compound dollars and cents into price

    }

    public String defineService() { // finds random service from the Services List

        List<WebElement> serviceList = driver.findElements(By.xpath(serviceListLocator));
        String serviceItem = (new StringBuilder())
                .append(serviceListLocator.toString())
                .append("[" + randomInt(1, serviceList.size()) + "]")
                .toString();

        //System.out.println(serviceItem);

        //System.out.println(serviceList.size());
        return serviceItem; //changed xpath
    }


    public String getUrl() {
        return this.URL;
    }


}
