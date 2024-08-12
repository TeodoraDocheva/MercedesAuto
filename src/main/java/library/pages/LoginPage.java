package library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    //https://aml.tst.mercedes-pay.io/login
    //D0X10245
    //qW73zgaAKc

    public static final String PAGE_URL = "https://aml.tst.mercedes-pay.io/login";
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.webDriver = driver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//wb-button[@class='wb-button hydrated']")
    private WebElement firstLoginButton;
    @FindBy(id ="userid")
    private WebElement usernameTextField;

    @FindBy(xpath = "//input[@id='rememberme-username']")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//*[@id='next-btn']")
    private WebElement nextButton;

    @FindBy(id ="password")
    private WebElement passwordTextField;

    @FindBy(xpath = "//*[@id='loginSubmitButton']")
    private WebElement loginButton;

    @FindBy(id = "errorLogin")
    private WebElement errorLoginButton;

    public void firstLoginButtonClick() {
        firstLoginButton.click();
    }
    public boolean isUrlLoaded(){
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }

    public void fillInUserName(String username){
        wait.until(ExpectedConditions.visibilityOf(usernameTextField));
        usernameTextField.sendKeys(username);
    }

    public void clickRememberMe(){
        wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
        rememberMeCheckbox.click();
    }

    public boolean isCheckedRememberMe(){
        return rememberMeCheckbox.isSelected();
    }

    public void navigateTo() {
        this.webDriver.get(PAGE_URL);
    }

    public boolean isURLLoaded() {
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }

    public void nextButtonClick() {
        nextButton.click();
    }

    public void fillInPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordTextField));
        passwordTextField.sendKeys(password);
    }

    public void loginButtonClick() {
        loginButton.click();

    }

    public void completeSingIn(String username, String password){
        firstLoginButtonClick();
        fillInUserName(username);
        nextButtonClick();
        fillInPassword(password);
        loginButtonClick();
    }

    public boolean isLoginFailed(){
        return errorLoginButton.isDisplayed();
    }
}

