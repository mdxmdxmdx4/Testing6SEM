package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.CustomCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SteamCS2SearchPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://store.steampowered.com/";
    private final Logger logger = LogManager.getRootLogger();
    public SteamCS2SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"store_nav_search_term\"]")
    private WebElement gameTitleInput;
    @FindBy(xpath = "//*[@id=\"search_suggestion_contents\"]/a[1]")
    private WebElement hrefToNeededGame;

    public SteamCS2SearchPage writeItemTitle(String input){
        gameTitleInput.sendKeys(input);
        logger.info("Game title has been written");
        return this;
    }
    public SteamCS2SearchPage clickSearchItemButton(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.elementToBeClickable(hrefToNeededGame));
        hrefToNeededGame.click();
        logger.info("Redirecting to the game page...");
        return this;
    }

    @Override
    public SteamCS2SearchPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(CustomCondition.jQueryAJAXsCompleted());
        logger.info("Steam Market Search Page is opened!");
        return this;
    }
}
