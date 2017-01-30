package pages;

import blocks.ProgressBarBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bigdrop on 1/30/2017.
 */
public class BookingPage extends ProgressBarBlock {

    By servicesList = By.xpath("//*[contains(@class, 'service-content')]/ul");
    public String URL = "http://handandstone.bigdropinc.net/booking.html";
    public ProgressBarBlock barBlock = new ProgressBarBlock();

    public BookingPage(){

    }

    public String chooseMassageType{
        
    }


}
