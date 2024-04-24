package steam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SteamMarketTest {
    private static final String ITEM_NAME = "Great Sage's Reckoning";
    private static final String FINAL_URL = "https://steamcommunity.com/market/search?q=Great+Sage%27s+Reckoning";

    private WebDriver driver;
    private SteamMarketPage steamMarketPage;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new EdgeDriver();
        steamMarketPage = new SteamMarketPage(driver);
    }

    @Test
    public void seartchItemOnMarket(){
        steamMarketPage = steamMarketPage.openPage()
                .writeItemTitle(ITEM_NAME)
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
