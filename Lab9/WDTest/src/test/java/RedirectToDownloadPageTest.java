import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RedirectToDownloadPageTest {
    private WebDriver webDriver;
    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        webDriver = new EdgeDriver();
    }
    @Test
    public void testNavigationToDownloads() throws InterruptedException {
        webDriver.get("https://www.selenium.dev/");

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10)); // ожидание до 10 секунд
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main_navbar\"]/ul/li[2]/a")));

        searchBtn.click();
        Thread.sleep(2000);

        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.selenium.dev/downloads/", "Navigation to Downloads page failed");

        webDriver.quit();
    }

    @AfterMethod(alwaysRun = true)
    public  void  browserTearDown(){
        webDriver.quit();
        webDriver = null;
    }
}