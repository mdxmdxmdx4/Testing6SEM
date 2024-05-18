package test;

import driver.DriverSingleton;
import model.Game;
import model.GameItem;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GameHubPage;
import service.GameGenerator;
import service.GameItemCreator;

public class GameHubTest extends CommonConditions {
    private static final String FINAL_URL = "https://steamcommunity.com/app/303800/allnews/";
    @Test
    public void seartchGameNewsOnHub(){
        Game game = GameGenerator.gameForHubSearch();
        GameHubPage gameHubPage = new GameHubPage(driver)
                .openPage()
                .writeHubTitle(game.getGame_name())
                .clickSearchItemButton()
                .clickNewsOption();
        Assert.assertEquals(driver.getCurrentUrl(), FINAL_URL, "Inccorrect Url");
    }
}