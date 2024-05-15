package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSingleton {
    private static WebDriver driver;
    private DriverSingleton(){}
    public static WebDriver getDriver(){
        if (null == driver){
            switch (System.getProperty("browser")){
                case "edge": {
                    driver = new EdgeDriver();
                }
                default: {
                    driver = new EdgeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}