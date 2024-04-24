package steam;

import general.AbstractPage;
import general.CustomCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SteamMarketPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://steamcommunity.com/market/";

    protected SteamMarketPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"findItemsSearchBox\"]")
    private WebElement itemNameInput;
    @FindBy(id = "findItemsSearchSubmit")
    private WebElement findButton;

    public  SteamMarketPage writeItemTitle(String input){
        itemNameInput.sendKeys(input);
        return this;
    }
    public  SteamMarketPage clickSearchItemButton(){
        findButton.click();
        return this;
    }
    @Override
    protected SteamMarketPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(CustomCondition.jQueryAJAXsCompleted());
        return this;
    }
}
