package page;

import util.CustomCondition;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SteamCommunityMarketPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://steamcommunity.com/market/";
    private final Logger logger = LogManager.getRootLogger();
    public SteamCommunityMarketPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"findItemsSearchBox\"]")
    private WebElement itemNameInput;
    @FindBy(id = "findItemsSearchSubmit")
    private WebElement findButton;

    public SteamCommunityMarketPage writeItemTitle(String input){
        itemNameInput.sendKeys(input);
        logger.info("Item title has been written");
        return this;
    }
    public SteamCommunityMarketPage clickSearchItemButton(){
        findButton.click();
        logger.info("Search button has been clicked");
        return this;
    }
    @Override
    public SteamCommunityMarketPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(CustomCondition.jQueryAJAXsCompleted());
        logger.info("Steam Community market page is opened!");
        return this;
    }
}
