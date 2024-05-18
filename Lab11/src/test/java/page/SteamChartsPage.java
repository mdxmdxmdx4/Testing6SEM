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

public class SteamChartsPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://store.steampowered.com/charts/";
    private final Logger logger = LogManager.getRootLogger();

    public SteamChartsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/charts/topselling/BY']")
    private WebElement topSellersLink;


    public SteamChartsPage clickTopSellersLink(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.elementToBeClickable(topSellersLink));
        topSellersLink.click();
        logger.info("Redirecting to the top sellers chart...");
        return this;
    }

    @Override
    public SteamChartsPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(CustomCondition.jQueryAJAXsCompleted());
        logger.info("Charts page is opened!");
        return this;
    }
}
