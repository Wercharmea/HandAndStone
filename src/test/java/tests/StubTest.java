package tests;

import blocks.ProgressBarBlock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookingPage;

public class StubTest extends BaseTest {

    private BookingPage bookingPage;
    private ProgressBarBlock progressBarBlock;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        bookingPage = new BookingPage(driver);
        progressBarBlock = new ProgressBarBlock(driver);
        driver.get(bookingPage.getUrl());
    }

    @Test
    public void test() {
        System.out.println("Is the title of Progress Bar right? - " + progressBarBlock.verifyTitleOfProgressBar());
        bookingPage.defineService();
        // bookingPage.chooseService();
    }
}