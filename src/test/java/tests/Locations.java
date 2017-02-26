package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LocationsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;


public class Locations extends BaseTest {

    private LocationsPage locationsPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        locationsPage = new LocationsPage(driver);
    }

    @TestCaseId("1")
    @Features("Locations")
    @Stories("Locations")
    @Test(description = "descriptino of the test")
    public void openLocationsPage() {
        locationsPage
                .openLocationsPage()
                .setQuery("new york")
                .clickFindStories()
                .setRadius(200);
        Assert.assertEquals(driver.getTitle(), "Booking");
    }
}



