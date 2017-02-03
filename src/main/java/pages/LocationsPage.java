package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class LocationsPage extends BasePage {
    private static final String STORETILE = "//div[@id='locations-list']/ul[@class='list']/li";
    public static final String URL = "";

    //TODO: add actual locators

    @FindBy(xpath = "div[@id='city-form']//input[@class='form-control']")
    private WebElement queryInputField;
    @FindBy(xpath = "")
    private WebElement findByBtn;
    @FindBy(xpath = "//a[@href='#locations-list']")
    private WebElement gridViewSwitch;
    @FindBy(xpath = "//a[@href='#map-list']")
    private WebElement mapViewSwitch;
    @FindBy(xpath = "")
    private WebElement getDirectionsLink;


    public LocationsPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void openLocationsPage() {
        driver.get(URL);
    }

    public int typeOfTheView() {
        if (gridViewSwitch.getAttribute("class").contains("active"))
            return 1;
        else if (mapViewSwitch.getAttribute("class").contains("active"))
            return 2;
        else return 0;
       /* System.out.println(driver.findElement(By.xpath("//a[@href='#locations-list']")).getAttribute("class")+"\n");*/ // use to check the class
    }

    public void switchView(String expectedView) {
        switch (expectedView.toUpperCase()) {
            case "GRID": {
                if (typeOfTheView() != 1)
                    gridViewSwitch.click();
                break;
            }
            case "MAP": {
                if (typeOfTheView() != 2)
                    mapViewSwitch.click();
                break;
            }

        }
    }

    public void setQuery(String query) {
        queryInputField.sendKeys(query);
    }

    public void clickFindStories() {
        findByBtn.click();
        //TODO: add wait
    }

    public boolean isComingSoon(WebElement storeTile) {
        if (storeTile.getAttribute("class").equalsIgnoreCase("coming-soon")) { //TODO: add verify by 'notify me' btn
            return true;
        } else return false;
    }


    public int getCountofStoresInGrid() {
        List<WebElement> tiles = driver.findElements(By.xpath(STORETILE)); //TODO: need to take into consideration the pagination
        return tiles.size();
    }

    public int getCountOfFoundStores() {
        return Integer.parseInt(driver.findElement(By.xpath("")).getText().replaceAll(" stores", ""));  //TODO: add locator of the count of found stores "//div[@class='slider-holder']//div[@class='add-info']/strong"
    }

    public void clickGetDirections() {
        getDirectionsLink.click();
    }

    public LocationDetailsPage clickMoreDetailsBtn() {
        return new LocationDetailsPage(driver);
    }
}
