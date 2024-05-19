package test;

import model.Group;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SteamGroupSearchPage;
import page.SteamProfileSearchPage;
import service.GroupGenerator;
import service.UserGenerator;

public class SteamProfileSearchTest extends  CommonConditions{
    private static final String FINAL_URL = "https://steamcommunity.com/id/domovoi8888";
    @Test
    public void seartchGameNewsOnHub(){
        User user = UserGenerator.withConcreteUsername();
        SteamProfileSearchPage groupSearchPage = new SteamProfileSearchPage(driver)
                .openPage()
                .writeProfileNameAndSubmit(user.getUsername())
                .clickProfileLink();
        Assert.assertEquals(driver.getCurrentUrl(), FINAL_URL, "Inccorrect Url");
    }
}
