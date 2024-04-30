package steam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SteamCS2SearchTest {
    private static final String GAME_TITLE = "CS2";
    private static final String FINAL_URL = "https://store.steampowered.com/app/730/CounterStrike_2/";

    private WebDriver driver;
    private SteamCS2SearchPage steamCS2SearchPage;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new EdgeDriver();
        steamCS2SearchPage = new SteamCS2SearchPage(driver);
    }

    @Test
    public void seartchItemOnMarket(){
        steamCS2SearchPage = steamCS2SearchPage.openPage()
                .writeItemTitle(GAME_TITLE)
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
