package hardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage extends AbstractPage{
    @FindBy(xpath = "//a[@class='K5hUy'][@href='https://cloud.google.com/products/calculator-legacy?hl=es-419']")
    private WebElement searchResult;
    @Override
    protected SearchResultPage openPage() {
        return this;
    }

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME_IN_SECONDS), this);
    }

    public CalculatorPage goToResult(String resultName) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
            .until(ExpectedConditions.elementToBeClickable(searchResult)).click();
        return new CalculatorPage(driver);
    }
}
