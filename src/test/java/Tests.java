import PageObjects.NavigationMenu;
import PageObjects.RulesConfiguration;
import io.github.sukgu.Shadow;
import library.pages.HomePage;
import library.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Tests extends BaseTest {



    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        String text = "DE";
        return new Object[][]{
                {"D0X10245", "qW73zgaAKc", text}
        };

    }

    @DataProvider(name = "getWrongUser")
    public Object[][] getWrongUser() {
        return new Object[][]{
                {"D0X102455", "qW73zgaAKc"}
        };

    }

    @Test(dataProvider = "getUser")
    public void loginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(webDriver);
        HomePage homePage = new HomePage(webDriver);

        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isURLLoaded(), "Home page is not loaded");

        loginPage.firstLoginButtonClick();
        loginPage.fillInUserName(username);
    //    loginPage.clickRememberMe();
      //  Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me checkbox is not checked.");
          loginPage.nextButtonClick();
          loginPage.fillInPassword(password);
          loginPage.loginButtonClick();

    }

    @Test(dataProvider = "getUser")
    public void loginTestRememberMe(String username, String password) {

        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isURLLoaded(), "Home page is not loaded");

        loginPage.firstLoginButtonClick();
        loginPage.fillInUserName(username);
        loginPage.clickRememberMe();
        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me checkbox is not checked.");
        loginPage.nextButtonClick();
        loginPage.fillInPassword(password);
        loginPage.loginButtonClick();

    }

    @Test(dataProvider = "getWrongUser")
    public void wrongLoginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isURLLoaded(), "Home page is not loaded");

        loginPage.firstLoginButtonClick();
        loginPage.fillInUserName(username);
        loginPage.nextButtonClick();
        loginPage.fillInPassword(password);
        loginPage.loginButtonClick();

       Assert.assertTrue(loginPage.isLoginFailed(), "Login Failed");

        //add assert

    }


    @Test(dataProvider = "getUser")
    public void navigationMenuTest(String username, String password) {
        LoginPage loginPage = new LoginPage(webDriver);
        NavigationMenu navigationMenu = new NavigationMenu(webDriver);

        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isURLLoaded(), "Home page is not loaded");

        loginPage.completeSingIn(username, password);

        navigationMenu.uploadDataClick();
        Assert.assertTrue(navigationMenu.isUploadDataURL(), "Upload Data page is not loaded");

        navigationMenu.rulesConfigurationClick();
        Assert.assertTrue(navigationMenu.isRulesConfigurationURL(), "Rules configuration pge is not loaded");

        navigationMenu.transactionRedFlagsClick();
        Assert.assertTrue(navigationMenu.isTransactionRedFlagsURL(), "Transaction Red Flags page is not loaded");


    }

    @Test(dataProvider = "getUser")
    public void rulesConfiguration(String username, String password) {
        LoginPage loginPage = new LoginPage(webDriver);
        NavigationMenu navigationMenu = new NavigationMenu(webDriver);
        RulesConfiguration rulesConfiguration = new RulesConfiguration(webDriver);

        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isURLLoaded(), "Home page is not loaded");
        loginPage.completeSingIn(username, password);
        navigationMenu.rulesConfigurationClick();
        Assert.assertTrue(navigationMenu.isRulesConfigurationURL(), "Rules configuration pge is not loaded");
        rulesConfiguration.DE2Click();
        Assert.assertTrue(rulesConfiguration.isDE2_URLLoaded(), "DE2 page is not loaded");

    }

    @Test(dataProvider = "getUser")
    public void testCreateNewRule(String username, String password, String text) {

        LoginPage loginPage = new LoginPage(webDriver);
        NavigationMenu navigationMenu = new NavigationMenu(webDriver);
        RulesConfiguration rulesConfiguration = new RulesConfiguration(webDriver);

        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isURLLoaded(), "Home page is not loaded");
        loginPage.completeSingIn(username, password);

        navigationMenu.rulesConfigurationClick();
        rulesConfiguration.DE2Click();
        rulesConfiguration.createButtonClick();
        rulesConfiguration.addRulesButtonClick();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        rulesConfiguration.openRulesDialog();

        Shadow shadow = new Shadow(webDriver);
        shadow.setImplicitWait(5);

        WebElement functionDropdown = shadow.findElement("wb-select[label='Function']");
        wait.until(ExpectedConditions.elementToBeClickable(functionDropdown));
        functionDropdown.click();

        rulesConfiguration.checkTransactionCountryClick();

        WebElement countryCode = shadow.findElement("wb-input[name='countryCode'");
        wait.until(ExpectedConditions.visibilityOf(countryCode));
        countryCode.click();
        countryCode.sendKeys(text);

        WebElement scopeType = shadow.findElement("wb-select[label='Scope type']");
        scopeType.click();
        WebElement individual = shadow.findElement("select[name='scopeType'] option[value='individual']");
        individual.click();

        WebElement addRuleButton = shadow.findElement("wb-button[type='submit'");
        addRuleButton.click();

        WebElement saveButton = shadow.findElement("wb-button[variant='primary'");
        saveButton.click();

        WebElement successMessage = shadow.findElement("wb-notification[variant='success'");
        Assert.assertTrue(successMessage.isDisplayed(), "Rule is not saved");

    }

    @Test(dataProvider = "getUser")
    public void editDraftRule(String username, String password, String text) {

        LoginPage loginPage = new LoginPage(webDriver);
        NavigationMenu navigationMenu = new NavigationMenu(webDriver);
        RulesConfiguration rulesConfiguration = new RulesConfiguration(webDriver);

        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isURLLoaded(), "Home page is not loaded");
        loginPage.completeSingIn(username, password);

        navigationMenu.rulesConfigurationClick();
        rulesConfiguration.DE2Click();

        Shadow shadow = new Shadow(webDriver);
        shadow.setImplicitWait(5);

        WebElement editButton = shadow.findElement("wb-button[variant='primary']");
        editButton.click();

    }

    @Test(dataProvider = "getUser")
    public void deleteDraftRule(String username, String password, String text) {

        LoginPage loginPage = new LoginPage(webDriver);
        NavigationMenu navigationMenu = new NavigationMenu(webDriver);
        RulesConfiguration rulesConfiguration = new RulesConfiguration(webDriver);

        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isURLLoaded(), "Home page is not loaded");
        loginPage.completeSingIn(username, password);

        navigationMenu.rulesConfigurationClick();
        rulesConfiguration.DE2Click();

        Shadow shadow = new Shadow(webDriver);
        shadow.setImplicitWait(5);

        WebElement deleteButton = shadow.findElement("wb-button[variant='destructive']");
        deleteButton.click();
//        WebElement confirmDeleteButton = shadow.findElement("wb-button[variant='primary'][class='wb-button hydrated']");
//
//        confirmDeleteButton.click();
        rulesConfiguration.confirmButtonClick();

    }

    @Test(dataProvider = "getUser")
    public void calendarTest(String username, String password) {

        LoginPage loginPage = new LoginPage(webDriver);
        HomePage homePage = new HomePage(webDriver);
        NavigationMenu navigationMenu = new NavigationMenu(webDriver);
        RulesConfiguration rulesConfiguration = new RulesConfiguration(webDriver);

        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isURLLoaded(), "Home page is not loaded");
        loginPage.completeSingIn(username, password);

        navigationMenu.rulesConfigurationClick();
        rulesConfiguration.DE2Click();
        rulesConfiguration.createButtonClick();
        rulesConfiguration.calendarIconlick();

        //finish the test

    }

    @Test(dataProvider = "getUser") // to be finished
    public void testDiscardChanges(String username, String password) {

        LoginPage loginPage = new LoginPage(webDriver);
        HomePage homePage = new HomePage(webDriver);
        NavigationMenu navigationMenu = new NavigationMenu(webDriver);
        RulesConfiguration rulesConfiguration = new RulesConfiguration(webDriver);


        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isURLLoaded(), "Home page is not loaded");
        loginPage.completeSingIn(username, password);

        navigationMenu.rulesConfigurationClick();
        rulesConfiguration.DE2Click();

        rulesConfiguration.createButtonClick();
        //rulesConfiguration.addRulesButtonClick();
      //  rulesConfiguration.continueEditingButtonClick();

        //rulesConfiguration.discardChangesButtonClick();


     //   Shadow shadow = new Shadow(webDriver);

     //   shadow.setImplicitWait(5);

     //   WebElement createButtonDE2 = shadow.findElement("icon caret-icon wb-icon hydrated");

     //   WebElement shadowHost = webDriver.findElement(By.cssSelector("MuiDialogContent-root css-yrn3nb"));
     //    createButtonDE2.click();


    }


}
