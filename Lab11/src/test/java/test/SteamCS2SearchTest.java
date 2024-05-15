package test;

import model.Game;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SteamCS2SearchPage;
import service.GameGenerator;

public class SteamCS2SearchTest extends CommonConditions {
    private static final String FINAL_URL = "https://store.steampowered.com/app/730/CounterStrike_2/";
    @Test
    public void seartchItemOnMarket(){
        Game game = GameGenerator.withTitleFromProperty();
        SteamCS2SearchPage steamCS2SearchPage = new SteamCS2SearchPage(driver).openPage()
                .writeItemTitle(game.getGame_name())
                .clickSearchItemButton();
        Assert.assertEquals(driver.getCurrentUrl(), FINAL_URL, "Inccorrect Url");
    }
}
