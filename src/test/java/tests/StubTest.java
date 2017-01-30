package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookingPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import java.util.List;

/**
 * Created by bigdrop on 1/23/2017.
 */

public class StubTest extends BookingPage {

   private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void test(){
        BookingPage bookingPage = PageFactory.initElements(driver,BookingPage.class);
        bookingPage.verifyTitleOfProgressBar();
        driver.findElement(firstStep);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }




}