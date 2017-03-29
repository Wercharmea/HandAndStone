package pages;

import blocks.ProgressBarBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by bigdrop on 1/30/2017.
 */
public class BookingPage extends BasePage {


    public String URL = "https://hs.bigdropinc.net/locations/2/booking";
    public String serviceListLocator = "//div[contains(@class,'service-content')]//ul//li";
    private ProgressBarBlock progressBarBlock;
    private String chosenService;

    public void setChosenService() throws Exception {
        this.chosenService = defineService();
    }

    public String getChosenService() {
        return chosenService;
    }

    public BookingPage(WebDriver driver) {
        super(driver);
        progressBarBlock = new ProgressBarBlock(driver);
    }

    public String getUrl() {
        return this.URL;
    }

    public void chooseProcedure(){ // TC#2 - Choose massage of facials
        String massageLocator = "//ul[contains(@class,'services-list')]/li[1]";
        WebElement massageType = driver.findElement(By.xpath(massageLocator));
        massageType.click();
    }

    public void chooseService() throws Exception{ // TC #3 - Choose the type of massage in the massages list

        if (progressBarBlock.verifyTitleOfProgressBar() == true) { // TC #1 - Verify the title of Progress Bar active item
            chooseProcedure();
            WebElement testItem = driver.findElement(By.xpath(getChosenService()+"//a[contains(@class,'btn-blue')]"));
            if (testItem.getText().equalsIgnoreCase("book now")){

                WebElement serviceItem = driver.findElement(By.xpath(getChosenService() + "//a[contains(.,'book now')]"));
                serviceItem.click();
                getServiceName();

                if (serviceItem.getText().equalsIgnoreCase("selected")== true)  {

                    System.out.println("Btn txt on massage type has changed");

                }
                else System.out.println("Btn txt on massage type has not changed");

            }
            else{
                setChosenService();
            }

        } else {
            System.out.print("Progress Bar title is not on first step");
        }
    }

    public static int randomInt(int Min, int Max) {
        return (int) (Math.random() * (Max - Min)) + Min;
    }

    private String defineService() throws Exception { // finds random service from the Services List
        String serviceItem;
        //if (isElementPresent(By.xpath(serviceListLocator))) {
            List<WebElement> serviceList = driver.findElements(By.xpath(serviceListLocator));
            serviceItem = (new StringBuilder())
                    .append(serviceListLocator.toString())
                    .append("[" + randomInt(1, serviceList.size() + 1) + "]")
                    .toString();

            System.out.println(serviceItem);
            return serviceItem;
            // }
      //  else throw new Exception("service list not found");
    }

    public String getServiceName() { //gets name of chosen service
        WebElement serviceNameLocator = driver.findElement(By.xpath(getChosenService() + "//h4"));
        String serviceName;
        serviceName = serviceNameLocator.getText();
        System.out.println("Chosen service name " + serviceName);
        return serviceName;
    }

    public void getServicePrice() { // method to find and save initial price
        //TODO compare duration price >= servicePrice, compare endPrice with duration price
        WebElement sumLocator = driver.findElement(By.xpath(getChosenService() + "//div[contains(@data-price,'89.95')]"));
        String sumValue = sumLocator.toString();
        System.out.println(sumValue);
    }

    public void getDuration(){ // TC#4 - Finds duration-list, choose duration, verifies price is bigger or equals to servicePrice
        WebElement durationList = driver.findElement(By.cssSelector(".duration-list"));
    }
}
