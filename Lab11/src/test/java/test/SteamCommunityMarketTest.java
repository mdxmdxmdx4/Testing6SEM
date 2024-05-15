package test;

import driver.DriverSingleton;
import model.GameItem;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SteamCommunityMarketPage;
import service.GameItemCreator;

public class SteamCommunityMarketTest extends CommonConditions {
    private static final String FINAL_URL = "https://steamcommunity.com/market/search?q=Great+Sage%27s+Reckoning";
    @Test
    public void seartchItemOnMarket(){
        GameItem gameItem = GameItemCreator.withTitleFromProperty();
        SteamCommunityMarketPage steamCommunityMarketPage = new SteamCommunityMarketPage(driver)
                .openPage()
                .writeItemTitle(gameItem.getTitle())
                .clickSearchItemButton();
        Assert.assertEquals(driver.getCurrentUrl(), FINAL_URL, "Inccorrect Url");
    }
}
