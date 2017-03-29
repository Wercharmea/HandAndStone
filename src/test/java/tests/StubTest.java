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

    }

    @Test
    public void test() throws Exception {
        driver.get(bookingPage.getUrl());
        System.out.println("Is the title of Progress Bar right? - " + progressBarBlock.verifyTitleOfProgressBar());

        bookingPage.setChosenService();
        bookingPage.chooseService();
      //  bookingPage.defineService();
      //  bookingPage.getServicePrice();
      //  bookingPage.getServicePrice();
      //  bookingPage.getServiceName();
    }
}