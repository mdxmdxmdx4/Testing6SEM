package test;

import model.Game;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GameHubPage;
import page.SteamChartsPage;
import service.GameGenerator;

public class SteamChartsTest extends CommonConditions {
    private static final String FINAL_URL = "https://store.steampowered.com/charts/topselling/global";
    @Test
    public void seartchGameNewsOnHub(){
        SteamChartsPage gameHubPage = new SteamChartsPage(driver)
                .openPage()
                .clickTopSellersLink();
        Assert.assertEquals(driver.getCurrentUrl(), FINAL_URL, "Inccorrect Url");
    }
}
