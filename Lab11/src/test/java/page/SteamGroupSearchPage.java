package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CustomCondition;

import java.time.Duration;

public class SteamGroupSearchPage extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://steamcommunity.com/search/groups";
    private final Logger logger = LogManager.getRootLogger();

    public SteamGroupSearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "search_text_box")
    private WebElement groupTitleInput;
    @FindBy(css = "a[href='https://steamcommunity.com/groups/tradingcards']")
    private WebElement groupLink;
    public SteamGroupSearchPage writeGroupTitle(String input){
        groupTitleInput.sendKeys(input);
        logger.info("Group title has been written");
        return this;
    }

    public SteamGroupSearchPage clickGroupLinkButton(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.elementToBeClickable(groupLink));
        groupLink.click();
        logger.info("Redirecting to the group page...");
        return this;
    }
    public SteamGroupSearchPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(CustomCondition.jQueryAJAXsCompleted());
        logger.info("Groups pages is opened!");
        return this;
    }
}
