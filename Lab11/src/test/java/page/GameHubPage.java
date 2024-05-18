package page;

import model.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CustomCondition;

import java.time.Duration;

public class GameHubPage extends  AbstractPage {
    private static final String HOMEPAGE_URL = "https://steamcommunity.com/";
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(id = "appHubsSearchText")
    private WebElement gameHubInput;
    @FindBy(xpath = "//div[contains(text(), 'The Witcher Adventure Game')]")
    private WebElement witcherAdventureGameLink;

    @FindBy(css = "a[href='https://steamcommunity.com/app/303800/allnews/']")
    private WebElement steamNewsOption;

    @FindBy(className = "responsive_tab_select")
    private  WebElement pageSelect;

    public GameHubPage(WebDriver driver) {
        super(driver);
    }

    public GameHubPage writeHubTitle(String input){
        gameHubInput.sendKeys(input);
        logger.info("Game title has been written");
        return this;
    }

    public GameHubPage clickSearchItemButton(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.elementToBeClickable(witcherAdventureGameLink));
        witcherAdventureGameLink.click();
        logger.info("Redirecting to the game hub...");
        return this;
    }

    public GameHubPage clickNewsOption(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.elementToBeClickable(steamNewsOption));
        steamNewsOption.click();
        logger.info("Redirecting to the news page...");
        return this;
    }

    @Override
    public GameHubPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(CustomCondition.jQueryAJAXsCompleted());
        logger.info("Game Hubs page is opened!");
        return this;
    }

}
