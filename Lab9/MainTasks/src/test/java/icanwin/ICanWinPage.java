package icanwin;

import general.CustomCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ICanWinPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    protected final int WAIT_TIME_IN_SECONDS = 10;
    private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement codeInput;

    @FindBy(xpath = "//select[@id='postform-expiration']/following::span[1]")
    private WebElement selectExpiration;

    @FindAll(
            {
                    @FindBy(xpath = "//li[@class='select2-results__option']")
            }
    )
    private List<WebElement> expirationOptions;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createButton;

    public ICanWinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ICanWinPage openPage() {
        driver.get(HOMEPAGE_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(codeInput));
        return this;
    }
    public ICanWinPage writeCode(String code){
        codeInput.sendKeys(code);
        return  this;
    }
    public void setSelectOption(WebElement select, String optionValue) {
        select.click();
        for (WebElement selectOption : expirationOptions) {
            if (selectOption.getText().trim().equals(optionValue.trim())) {
                selectOption.click();
                new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.invisibilityOf(selectOption));
                break;
            }
        }
    }
    public ICanWinPage chooseExpiration(String expiration) {
        setSelectOption(selectExpiration, expiration);
        return  this;
    }

    public ICanWinPage writeName(String name) {
        pasteName.sendKeys(name);
        return  this;
    }
    public ICanWinPage clickCreateNewPasteButton() {
        createButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(CustomCondition.changingURL(driver.getCurrentUrl()));
        return  this;
    }
}
