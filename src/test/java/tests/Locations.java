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
    @Test (description = "descriptino of the test")
    public void openLocationsPage() {
        locationsPage.openLocationsPage();
        Assert.assertEquals(driver.getTitle(), "Booking");
    }
}

    /*    private By progressBarLocator = By.xpath("//div[@class='step-area']//li");*/
/*    @Test
    public void locationsType() {
        driver.get("http://handandstone.bigdropinc.net/locations.html");
        List<WebElement> tiles = driver.findElements(By.xpath("//div[@id='locations-list']/ul[@class='list']/li"));
        int count = tiles.size();
        System.out.println("count: " + count);
        int k = 0;
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getAttribute("class").equalsIgnoreCase("coming-soon"))
                k += 1;
        }
        System.out.println("coming soon stores: " + k);
    }*/
/*
    @Test
    public void isComingSoonType() {
        driver.get("http://handandstone.bigdropinc.net/locations.html");
        List<WebElement> tiles = driver.findElements(By.xpath("//div[@id='locations-list']/ul[@class='list']/li"));
        int count = tiles.size();
        System.out.println("count: " + count);
        int k = 0;
        String[] titles = new String[tiles.size()];
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getAttribute("class").equalsIgnoreCase("coming-soon")) {
                titles[i] = driver.findElement(By.xpath("./*/
/*[@id='locations-list']/ul[@class='list']/li[" + (i + 1) + "]//h3")).getText();
                k += 1;
            }

        }
        System.out.println("coming soon stores: " + k);
        for (int i = 0; i < tiles.size(); i++) {
            if (titles[i] != null) {
                System.out.println(titles[i] + "\n");
            }
        }
    }

    @Test
    public void notifyMe() {
        driver.get("http://handandstone.bigdropinc.net/locations.html");
        driver.findElement(By.xpath("//a[@href='#notify-me']")).click();
        By emailInputField = By.xpath("./*/
/*[@id='notify-me']//input[@type='email']");
        Wait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputField));
        driver.findElement(emailInputField).sendKeys("qa@gmail.com");
        driver.findElement(By.xpath("./*/
/*[@id='notify-me']//input[@type='submit']")).click();

    }

    @Test
    public void isGridView() {
        driver.get("http://handandstone.bigdropinc.net/locations.html");
        if (driver.findElement(By.xpath("//a[@href='#locations-list']")).getAttribute("class").contains("active") == true)
            System.out.println("View is grid");
        else System.out.println("View is map");
        System.out.println(driver.findElement(By.xpath("//a[@href='#locations-list']")).getAttribute("class") + "\n");
    }

    @Test
        public void openLocationsPage() {
        String expectedTitle = "handandstone";
        locationsPage.openLocationsPage().setQuery("kharkiv").clickFindStories();
        WebElement slider = driver.findElement(By.xpath("html/body/div[1]/section/div/div[1]/div[2]/div/div/div[2]/span"));
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeAsyncScript("arguments[0].setAttribute('style', 'left: 30%;')",slider);
        System.out.println(locationsPage.typeOfTheView()+"\n"+locationsPage.getCountOfFoundStores());

        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
*/


