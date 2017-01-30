package pages;

import blocks.ProgressBarBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bigdrop on 1/30/2017.
 */
public class BookingPage extends ProgressBarBlock {


    public String URL = "http://handandstone.bigdropinc.net/booking.html";
    @FindBy (xpath = "//a[contains(.,'Book now')]")
    public WebElement serviceType;
    public ProgressBarBlock barBlock = new ProgressBarBlock();

    public BookingPage(WebDriver driver){
        super(driver);
    }

    public void chooseMassageType(){
        float massagePrice;
        
        if (verifyTitleOfProgressBar() == true){
            serviceType.click();
        }


    }
    public String getUrl() {
        return this.URL;
    }


}
