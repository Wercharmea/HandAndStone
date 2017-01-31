package pages;

import blocks.ProgressBarBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.util.List;

/**
 * Created by bigdrop on 1/30/2017.
 */
public class BookingPage extends ProgressBarBlock {


    public String URL = "http://handandstone.bigdropinc.net/booking.html";
    public By serviceListLocator = By.xpath("//div[contains(@class,'service-content')]//li");

    @FindBy (xpath = "//a[contains(.,'Book now')]")
    public WebElement serviceType;

    public BookingPage(WebDriver driver){
        super(driver);
    }

    public void chooseServiceType(){
        String serviceTypeName = "";
        if (verifyTitleOfProgressBar() == true){
            serviceType.click();
        }
    }

    public static int randomInt(int Min, int Max){

        return (int) (Math.random()*(Max-Min))+Min;
    }

    public void getServicePrice(){ // method to find and compound dollars and cents into price

    }

    public String defineService(){

        List<WebElement> serviceList = driver.findElements(serviceListLocator);
        String serviceItem = (new StringBuilder())
                .append(serviceListLocator.toString())
                .append("[" + randomInt(1, serviceList.size()) + "]")
                .toString();
        System.out.println(serviceItem);
        System.out.println(serviceList.size());
        return serviceItem; //changed xpaths
    }


    public String getUrl() {
        return this.URL;
    }




}
