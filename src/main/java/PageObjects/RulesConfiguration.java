package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RulesConfiguration {

    //https://aml.tst.mercedes-pay.io/rules/DE-2
    public static final String DE2_URL = "https://aml.tst.mercedes-pay.io/rules/DE-2";
    private final WebDriver webDriver;
    private final WebDriverWait wait;
    protected WebElement searchContext;

    public RulesConfiguration(WebDriver driver) {
        this.webDriver = driver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@data-id='DE-2']")
    private WebElement DE2;

    @FindBy(xpath = "//*[@data-id='DE-2']")
    private WebElement deleteButton;

    @FindBy(xpath = "//wb-button[contains(@class, 'hydrated')]")
    private WebElement createButton;

    @FindBy(css = "wb-button[type='submit'].wb-button.hydrated")
    private WebElement continueEditingButton;

    @FindBy(css = "wb-button[type='button'][variant='secondary'].wb-button.hydrated")
    private WebElement discardChangesButton;

    @FindBy(css = "section.MuiBox-root div.MuiStack-root wb-tooltip.wb-tooltip")
    private WebElement addRulesButton;

    @FindBy(name = "screenFrom")
    private WebElement calendarIcon;

    @FindBy(css = ".MuiDialogContent-root.css-yrn3nb")
    private WebElement rulesDialog;

    @FindBy(id = "c7e7e2ip1__CUSTOM_RULE__tab")
    private WebElement customRulesTab;

    @FindBy (xpath = "//wb-text[contains(text(), 'checkTransactionCountry')]")
    private WebElement checkTransactionCountry;

    @FindBy (xpath = "//wb-button[@variant='secondary']//button[contains(text(), 'Cancel')]")
    private WebElement cancelButton;

   @FindBy(css = "wb-button[variant='primary'][class='wb-button hydrated']")
   private WebElement confirmButton;
   public void confirmButtonClick() {
       wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
       confirmButton.click();
   }

    @FindBy (css = ".css-1so3pej")
    private WebElement countryCodeInput;
    public void populatecountryCode(String text){
        wait.until(ExpectedConditions.visibilityOf(countryCodeInput));
            countryCodeInput.sendKeys("text");
    }

    //scopeType  --//select[@id='select-jbkmqckd9'] xpath

    //threshold - css - wb-input:nth-of-type(2) input#input -- xpath - (//input[@id='input'])[2]

    public void cancelButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButton.click();
    }

    public void checkTransactionCountryClick() {
        wait.until(ExpectedConditions.elementToBeClickable(checkTransactionCountry));
        checkTransactionCountry.click();
    }


    //icon caret-icon wb-icon hydrated
//    @FindBy(id = "select-c2itld0l3")
//    private WebElement iconTest;
//
//    public void clickIconTest() {
//        wait.until(ExpectedConditions.elementToBeClickable(iconTest));
//        iconTest.click();
//    }


    public void openCustomRulesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(customRulesTab));
        customRulesTab.click();
    }

    public boolean isopenRulesDialog() {
        return wait.until(ExpectedConditions.elementToBeSelected(rulesDialog));
    }

    public void openRulesDialog(){
        wait.until(ExpectedConditions.visibilityOf(rulesDialog));
        rulesDialog.click();
    }
    public void calendarIconlick() {
        wait.until(ExpectedConditions.elementToBeClickable(calendarIcon));
        calendarIcon.click();
    }

    public void addRulesButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(addRulesButton));
        addRulesButton.click();
    }

    public void DE2Click() {
        wait.until(ExpectedConditions.elementToBeClickable(DE2));
        DE2.click();
    }

    public boolean isDE2_URLLoaded() {
        return wait.until(ExpectedConditions.urlToBe(DE2_URL));
    }

    public void deleteButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
    }

    public void createButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(createButton));
        createButton.click();
    }

    public void continueEditingButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(continueEditingButton));
        continueEditingButton.click();
    }

    //DiscardChangesButton
    public void discardChangesButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(discardChangesButton));
        discardChangesButton.click();
    }

}
