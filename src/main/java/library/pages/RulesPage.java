package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RulesPage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    protected WebElement searchContext;


    public RulesPage(WebDriver driver, WebElement objectContainer){
        this.webDriver = driver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        searchContext = objectContainer;
        PageFactory.initElements(driver, this);
    }


}
