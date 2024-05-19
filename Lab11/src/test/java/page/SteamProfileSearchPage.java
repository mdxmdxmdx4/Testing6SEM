package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CustomCondition;

import java.time.Duration;

public class SteamProfileSearchPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://steamcommunity.com/";
    private final Logger logger = LogManager.getRootLogger();

    public SteamProfileSearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "SearchPlayers")
    private WebElement gameHubInput;

    @FindBy(css = "a[href='https://steamcommunity.com/id/domovoi8888']")
    private WebElement profileLink;


    public SteamProfileSearchPage writeProfileNameAndSubmit(String input){
        gameHubInput.sendKeys(input);
        gameHubInput.sendKeys(Keys.RETURN);
        logger.info("Profile name has been written");
        return this;
    }

    public SteamProfileSearchPage clickProfileLink(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.elementToBeClickable(profileLink));
        profileLink.click();
        logger.info("Redirecting to the user's profile with nickname \'ДОМОВОЙ\'...");
        return this;
    }


    @Override
    public SteamProfileSearchPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(CustomCondition.jQueryAJAXsCompleted());
        logger.info("Steam Community market page is opened!");
        return this;
    }
}
