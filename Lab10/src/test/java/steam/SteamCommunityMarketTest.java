package steam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SteamCommunityMarketTest {
    private static final String GAME_ITEM_NAME = "Great Sage's Reckoning";
    private static final String FINAL_URL = "https://steamcommunity.com/market/search?q=Great+Sage%27s+Reckoning";

    private WebDriver driver;
    private SteamCommunityMarketPage steamCommunityMarketPage;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new EdgeDriver();
        steamCommunityMarketPage = new SteamCommunityMarketPage(driver);
    }

    @Test
    public void seartchItemOnMarket(){
        steamCommunityMarketPage = steamCommunityMarketPage.openPage()
                .writeItemTitle(GAME_ITEM_NAME)
                .clickSearchItemButton();
        Assert.assertEquals(driver.getCurrentUrl(), FINAL_URL, "Inccorrect Url");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
