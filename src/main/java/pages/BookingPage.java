package pages;

import blocks.ProgressBarBlock;
import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

/**
 * Created by bigdrop on 1/30/2017.
 */
public class BookingPage extends BasePage {

    public  static String SERVICE_NAME;
    public static int SERVICE_PRICE;
    public String URL = "https://hs.bigdropinc.net/locations/2/booking";
    public String serviceListLocator = "//div[contains(@class,'service-content')]//ul//li//";
    public String serviceListOnlyBookNowBtns = serviceListLocator + "a[contains(.,'book now')]";
    public String randomServiceLocator;
    private ProgressBarBlock progressBarBlock;
    private WebElement chosenService;


    public void setChosenService() throws Exception {
        this.chosenService = getRandomService();
    }

    public WebElement getChosenService() {
        return chosenService;
    }

    public BookingPage(WebDriver driver) {
        super(driver);
        progressBarBlock = new ProgressBarBlock(driver);
    }

    public String getUrl() {
        return this.URL;
    }

    public void chooseMassage() {
        chooseProcedure(1);
    }

//    public void chooseFacials() {
//        chooseProcedure(2);
//    }

    // TC#2 - Choose massage or facials
    public void chooseProcedure(int numberOfProcedure){
        String massageLocator = String.format("//ul[contains(@class,'services-list')]/li[%s]", numberOfProcedure);
        WebElement massageType = driver.findElement(By.xpath(massageLocator));
        massageType.click();
        System.out.println("Procedure chosen");
    }

    public  boolean isMassageListActive(){ //verify if the list of services appear
        WebElement massageType = driver.findElement(By.xpath("//ul[contains(@class,'services-list')]"));
        if (massageType.getAttribute("class").contains("active")) {System.out.println("Massage list is visible");}
        else {
            return false;
        }
        return true;
    }

    public void chooseService() throws Exception { // TC #3 - Choose the type of massage in the massages list

        if (progressBarBlock.verifyTitleOfProgressBar() == true) { // TC #1 - Verify the title of Progress Bar active item
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='booking-details  first-step']")));
          //  System.out.println(driver.findElement(By.xpath("//div[@class='booking-details  first-step']")).getText());
            chooseMassage();
            if (isMassageListActive()) {  //setChosenService();
           // System.out.println("Random index and path is " + getChosenService());
           // WebElement serviceItem = driver.findElement(By.xpath(getChosenService()));
                setChosenService();
                System.out.println("Random service locator is" + randomServiceLocator);
                saveServiceName(chosenService);
                System.out.println("Service name " + SERVICE_NAME);
            getChosenService().click();

          /*  System.out.println("Is Book Now btn Name has changed " + isBookNowBtnNameChanged());
            System.out.println("Chosen Service name is " + saveServiceName());
            System.out.println("Chosen Service start price is " + saveServicePrice());*/
            }
          //  serviceItem.click();}

            else {System.out.println("MassageList is not active"); }

        } else System.out.print("Progress Bar title is not on first step");
    }

    public boolean isBookNowBtnNameChanged(){
        return getChosenService().getText().equalsIgnoreCase("selected");
    }



    public String saveServiceName(WebElement chosenService) {
        //TODO change serviceListLocator to chosenService and get h4
        WebElement serviceNameLocator = driver.findElement(By.xpath(serviceListLocator + "h4"));
        SERVICE_NAME = serviceNameLocator.getText();
        return SERVICE_NAME;
    }

    public Float saveServicePrice() { // method to find and save initial price
        //TODO compare duration price >= servicePrice, compare endPrice with duration price
        WebElement sumLocator = driver.findElement(By.xpath(serviceListLocator + "div[@class='sum ']"));
        Float serviceStartPrice = Float.parseFloat(sumLocator.getAttribute("data-price"));
        return serviceStartPrice;


    }
   public WebElement getRandomService()
    {
        List<WebElement> serviceList = driver.findElements(By.xpath(serviceListOnlyBookNowBtns));
        int index = ThreadLocalRandom.current().nextInt(1, serviceList.size());
        randomServiceLocator = serviceListOnlyBookNowBtns.replace("li", String.format("li[%s]", index));
        return driver.findElement(By.xpath(randomServiceLocator));
    }



    private void getDuration(){ // TC#4 - Finds duration-list, choose duration, verifies price is bigger or equals to servicePrice
        WebElement durationList = driver.findElement(By.cssSelector(".duration-list"));
    }
}
