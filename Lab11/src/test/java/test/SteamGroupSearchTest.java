package test;

import driver.DriverSingleton;
import model.Game;
import model.GameItem;
import model.Group;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GameHubPage;
import page.SteamGroupSearchPage;
import service.GameGenerator;
import service.GameItemCreator;
import service.GroupGenerator;

public class SteamGroupSearchTest extends CommonConditions{
    private static final String FINAL_URL = "https://steamcommunity.com/groups/tradingcards";
    @Test
    public void seartchGameNewsOnHub(){
        Group group = GroupGenerator.withTitleFromProperty();
        SteamGroupSearchPage groupSearchPage = new SteamGroupSearchPage(driver)
                .openPage()
                .writeGroupTitle(group.getGroup_name())
                .clickGroupLinkButton();
        Assert.assertEquals(driver.getCurrentUrl(), FINAL_URL, "Inccorrect Url");
    }
}
