package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class LocationsPage extends BasePage {
    private static final String STORETILE = "//div[@id='locations-list']/ul[@class='list']/li";
    public static final String URL = "https://hs.bigdropinc.net/locations";
    private static final String PRELOADER = ".tabs-holder.loading";

    //TODO: add actual locators

    @FindBy(xpath = ".//input[@name='zip_state_city']")
    private WebElement queryInputField;
    @FindBy(xpath = ".//div[@class='city-form']//input[@type='submit']")
    private WebElement findByBtn;
    @FindBy(xpath = ".//a[contains(@class,'icon-grid_view')]")
    private WebElement gridViewSwitch;
    @FindBy(xpath = ".//a[contains(@class,'icon-map_view')]")
    private WebElement mapViewSwitch;
    @FindBy(xpath = "")
    private WebElement getDirectionsLink;
    @FindBy(css = ".ui-slider-handle.ui-corner-all.ui-state-default")
    private WebElement radiusSlider;
    @FindBy(xpath = ".//div[@class='slider-holder']//div[@class='note']//input")
    private WebElement actualRadiusValue;
    @FindBy(css = ".add-info>strong")
    private WebElement coundOfFoundStores;

    public LocationsPage(WebDriver driver) {
        super(driver);
    }

    private void waitInsibilityOfPreloader() {
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(PRELOADER)));
    }

    @Step
    public LocationsPage openLocationsPage() {
        driver.get(URL);
        return this;
    }

    public int typeOfTheView() {
        if (gridViewSwitch.getAttribute("class").contains("active")) {
            return 1;
        } else if (mapViewSwitch.getAttribute("class").contains("active")) {
            return 2;
        }
        return 0;
    }

    public LocationsPage switchView(String expectedView) {
        switch (expectedView.toUpperCase()) {
            case "GRID": {
                if (typeOfTheView() != 1) {
                    gridViewSwitch.click();
                }
                break;
            }
            case "MAP": {
                if (typeOfTheView() != 2) {
                    mapViewSwitch.click();
                }
                break;
            }
        }
        return this;
    }

    public LocationsPage setQuery(String query) {
        waitInsibilityOfPreloader();
        queryInputField.clear();
        queryInputField.sendKeys(query);
        return this;
    }

    public LocationsPage clickFindStories() {
        findByBtn.click();
        waitInsibilityOfPreloader();
        return this;
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
        return Integer.parseInt(coundOfFoundStores.getText().replaceAll(" stores", ""));
    }

    public void clickGetDirections() {
        getDirectionsLink.click();
    }

    public LocationDetailsPage clickMoreDetailsBtn() {
        return new LocationDetailsPage(driver);
    }

    public int getRarius() {
        return Integer.parseInt(actualRadiusValue.getAttribute("value"));
    }

    public LocationsPage setRadius(int expectedRadius) {
        int actualRadius = getRarius();
        Action action = move.dragAndDropBy(radiusSlider, (int) ((expectedRadius - actualRadius) * 3.156), 0).build();
        action.perform();
        waitInsibilityOfPreloader();
        return this;
    }
}
