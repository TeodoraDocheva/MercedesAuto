package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationMenu {

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public static final String rulesConfigurationURL = "https://aml.tst.mercedes-pay.io/rules";
    public static final String uploadDataURL = "https://aml.tst.mercedes-pay.io/upload";
    public static final String transactionRedFlagsURL = "https://aml.tst.mercedes-pay.io/red-flags";


    public NavigationMenu(WebDriver driver) {
        this.webDriver = driver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[contains(@class, 'MuiButtonBase-root') and .//span[text()='Rules Configuration']]") //пробвай cssSelector
    private WebElement rulesConfiguration;

    @FindBy(xpath = "//a[contains(@class, 'MuiButtonBase-root') and .//span[text()='Upload Data']]")
    private WebElement uploadData;

    @FindBy(xpath = "//a[contains(@class, 'MuiButtonBase-root') and .//span[text()='Transaction Red Flags']]")
    private WebElement transactionRedFlags;

    public void uploadDataClick() {
        wait.until(ExpectedConditions.elementToBeClickable(uploadData));
        uploadData.click();
    }
    public void rulesConfigurationClick() {
        wait.until(ExpectedConditions.elementToBeClickable(rulesConfiguration));
        rulesConfiguration.click();
    }
    public void transactionRedFlagsClick(){
        wait.until(ExpectedConditions.elementToBeClickable(transactionRedFlags));
        transactionRedFlags.click();
    }
    public boolean isRulesConfigurationURL() {
        return wait.until(ExpectedConditions.urlToBe(rulesConfigurationURL));
    }
    public boolean isUploadDataURL() {
        return wait.until(ExpectedConditions.urlToBe(uploadDataURL));
    }
    public boolean isTransactionRedFlagsURL() {
        return wait.until(ExpectedConditions.urlToBe(transactionRedFlagsURL));
    }

}

