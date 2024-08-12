package library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    //https://aml.tst.mercedes-pay.io/rules

    public static final String HOMEPAGE_URL = "https://aml.tst.mercedes-pay.io/rules";
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

//    @FindBy(xpath = "//a[contains(@class, 'MuiButtonBase-root') and .//span[text()='Upload Data']]")
//    private WebElement rulesConfiguration;
//
//
//    @FindBy(xpath = "//a[contains(@class, 'MuiButtonBase-root') and .//span[text()='Upload Data']]")
//    private WebElement uploadData;

    public void navigateTo() {
        this.webDriver.get(HOMEPAGE_URL);
    }

    public boolean isHomePageLoaded() {
        return wait.until(ExpectedConditions.urlToBe(HOMEPAGE_URL));
    }


}
