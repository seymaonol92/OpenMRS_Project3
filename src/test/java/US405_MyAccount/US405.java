package US405_MyAccount;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.DataRepo;
import pages.HomePage;
import pages.LoginPage;
import utility.BaseDriver;

public class US405 {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;

    private static final Logger LOGGER = LogManager.getLogger(US405.class);

    @Test(priority = 1, groups = {"smoke"})
    @Description("Verify that home page is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyHomePage() {
        homePage.verifyHomePage();
        LOGGER.info("Home page opened");
    }

    @Test(priority = 2, groups = {"smoke"},dependsOnMethods = "verifyHomePage")
    @Description("Demo button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickDemoBtn() {
        homePage.clickDemoBtn();
        LOGGER.info("Demo button clicked");
        BaseDriver.threadWait(3);
    }
    @Test(priority = 3, groups = {"smoke"},dependsOnMethods = "clickDemoBtn")
    @Description("Scroll down successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void scrollDownPage() {
        homePage.scrollDown();
        LOGGER.info("Scroll down");
        BaseDriver.threadWait(3);
    }
    @Test(priority = 4, groups = {"smoke"}, dependsOnMethods = "scrollDownPage")
    @Description("EnterOpenMRS3 button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickEnterOpenMRS() {
        homePage.clickEnterOpenMRS();
        LOGGER.info("EnterOpenMRS3 button clicked");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 5, groups = {"smoke"}, dependsOnMethods = "clickEnterOpenMRS")
    @Description("Verify that Login page is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginPage(){
        loginPage.checkPageUsername();
        LOGGER.info("Login page opened");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 6, groups = {"smoke"}, dataProvider = "LoginData", dataProviderClass = DataRepo.class, dependsOnMethods = "verifyLoginPage")
    @Description("Username entered successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void enterUsername(String username){
        loginPage.enterUsername(username);
        LOGGER.info("Username entered");
        BaseDriver.threadWait(3);
    }
    @Test(priority = 7, groups = {"smoke"}, dependsOnMethods = "enterUsername")
    @Description("Continue button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickContinueBtn(){
        loginPage.clickContinueBtn();
        LOGGER.info("Continue button clicked");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 8, groups = {"smoke"}, dataProvider = "LoginData", dataProviderClass = DataRepo.class, dependsOnMethods = "clickContinueBtn")
    @Description("Password entered successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void enterPassword(String password){
        loginPage.enterPassword(password);
        LOGGER.info("Password entered");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 9, groups = {"smoke"}, dependsOnMethods = "enterPassword")
    @Description("Login button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickLoginBtn(){
        loginPage.clickLoginBtn();
        LOGGER.info("Login button clicked");
    }

    @Test(priority = 10, groups = {"smoke"}, dependsOnMethods = "clickLoginBtn")
    @Description("Location selected successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void selectedLocation(){
        loginPage.outpatientClinic();
        LOGGER.info("Location selected");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 11, groups = {"smoke"}, dependsOnMethods = "selectedLocation")
    @Description("Confirm button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickConfirmBtn(){
        loginPage.clickConfirmBtn();
        LOGGER.info("Confirm button clicked");
        BaseDriver.threadWait(3);
    }







    @Attachment(value = "Adim sayisi", type = "text/plain")
    public String step(String message) {
        return message;
    }

}
