package icanwin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ICanWinTest {
    private WebDriver driver;
    private ICanWinPage ICanWinPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new EdgeDriver();
        ICanWinPage = new ICanWinPage(driver);
    }

    @Test
    public void testCreateNewPaste() {
        ICanWinPage iCanWinPageInstance = ICanWinPage.openPage();
        String oldUrl = driver.getCurrentUrl();
        iCanWinPageInstance.writeCode("Hello from WebDriver!")
                .chooseExpiration("10 Minutes")
                .writeName("helloWeb")
                .clickCreateNewPasteButton();

        Assert.assertNotEquals(oldUrl, driver.getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
