package steam;

import general.AbstractPage;
import general.CustomCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SteamCS2SearchPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://store.steampowered.com/";

    protected SteamCS2SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"store_nav_search_term\"]")
    private WebElement gameTitleInput;
    @FindBy(xpath = "//*[@id=\"search_suggestion_contents\"]/a[1]")
    private WebElement hrefToNeededGame;

    public SteamCS2SearchPage writeItemTitle(String input){
        gameTitleInput.sendKeys(input);
        return this;
    }
    public SteamCS2SearchPage clickSearchItemButton(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.elementToBeClickable(hrefToNeededGame));
        hrefToNeededGame.click();
        return this;
    }

    @Override
    protected SteamCS2SearchPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(CustomCondition.jQueryAJAXsCompleted());
        return this;
    }
}
