package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookingPage;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * Created by bigdrop on 1/23/2017.
 */

public class StubTest {

    public WebDriver driver;
    private BookingPage bookingPage;
    @BeforeMethod(alwaysRun = true)
    public void setUp(){

        driver = new ChromeDriver();
        bookingPage = new BookingPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get(bookingPage.getUrl());
    }

    @Test
    public void test(){

        System.out.print(bookingPage.verifyTitleOfProgressBar());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }




}