package US408_PatientListing;


import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utility.BaseDriver;
import utility.BaseGUITest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class US_408_patientListVerify extends BaseGUITest {


    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    PatientDetailsPage patientDetailsPage;

    private static final Logger LOGGER = LogManager.getLogger(US_408_patientListVerify.class);

    @BeforeClass(alwaysRun = true)
    public void setupPages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        patientDetailsPage = new PatientDetailsPage(driver);
    }



    @Test(priority = 1, groups = {"smoke"})
    @Description("Verify that home page is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyHomePage() {
        homePage.verifyHomePage();
        LOGGER.info("Home page opened");
    }

    @Test(priority = 2, groups = {"smoke"}, dependsOnMethods = "verifyHomePage")
    @Description("Demo button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickDemoBtn() {
        homePage.clickDemoBtn();
        LOGGER.info("Demo button clicked");

    }

    @Test(priority = 3, groups = {"smoke"}, dependsOnMethods = "clickDemoBtn")
    @Description("Scroll down successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void scrollDownPage() {
        homePage.scrollDown();
        LOGGER.info("Scroll down");

    }

    @Test(priority = 4, groups = {"smoke"}, dependsOnMethods = "scrollDownPage")
    @Description("EnterOpenMRS3 button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickEnterOpenMRS() {
        homePage.clickEnterOpenMRS();
        LOGGER.info("EnterOpenMRS3 button clicked");

    }

    @Test(priority = 5, groups = {"smoke"}, dependsOnMethods = "clickEnterOpenMRS")
    @Description("Verify that Login page is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginPage() {
        loginPage.checkPageUsername();
        LOGGER.info("Login page opened");

    }

    @Test(priority = 6, groups = {"smoke"}, dataProvider = "UsernameData", dataProviderClass = DataRepo.class, dependsOnMethods = "verifyLoginPage")
    @Description("Username entered successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
        LOGGER.info("Username entered");

    }

    @Test(priority = 7, groups = {"smoke"}, dependsOnMethods = "enterUsername")
    @Description("Continue button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickContinueBtn() {
        loginPage.clickContinueBtn();
        LOGGER.info("Continue button clicked");

    }

    @Test(priority = 8, groups = {"Regression"})
    @Description("Password has been verified")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyPassword() {
        loginPage.checkPagePassword();
        LOGGER.info("Password has been verified");

    }

    @Test(priority = 9, groups = {"Regression"})
    @Description("Password entered successfully and clicked login button")
    @Severity(SeverityLevel.CRITICAL)
    public void passwordInput() {
        loginPage.enterPassword("Admin123");
        loginPage.clickLoginBtn();
        LOGGER.info("Password entered successfully and clicked login button");

    }

    @Test(priority = 10, groups = {"Regression"})
    @Description("The select buttons, the welcome admin message was verified, and the confirm button was pressed.")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyWelcomeAdmin() {
        loginPage.checkPageLocation();
        loginPage.outpatientClinic();
        loginPage.clickConfirmBtn();
        LOGGER.info("The select buttons, the welcome admin message was verified, and the confirm button was pressed.");

    }

    @Test(priority = 11, groups = {"Regression"})
    @Description("The texts have been checked.")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyDashboard() {
        dashboardPage.verifyOpenMRSText();
        dashboardPage.verifyLocationText();
        LOGGER.info("The texts have been checked.");
    }

    @Test(priority = 12, groups = {"Regression"})
    @Description("The patient list button was clicked.")
    @Severity(SeverityLevel.CRITICAL)
    public void clickPatientList() {
        dashboardPage.clickPatientLists();
        LOGGER.info("The patient list button was clicked.");

    }

    @Test(priority = 13, groups = {"Regression"})
    @Description("the patient list text checked")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyPatientList() {
        patientDetailsPage.verifyPatientList();
        LOGGER.info("the patient list text checked");
    }

    @Test(priority = 14, groups = {"Regression"})
    @Description("The mylist button was clicked")
    @Severity(SeverityLevel.CRITICAL)
    public void clickMyListBtn() {
        patientDetailsPage.clickMyListButton();
        LOGGER.info("The mylist button was clicked");
    }

    @Test(priority = 15, groups = {"Regression"})
    @Description("Clicked on the bariscansiz list")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyMyList() {
        patientDetailsPage.verifyPatientLists();
        LOGGER.info("Clicked on the bariscansiz list");
    }



    @Attachment(value = "Adim sayisi", type = "text/plain")
    public String step(String message) {
        return message;
    }

    @AfterClass
    public void quitTest() {
        driver.quit();
        LOGGER.info("Tarayici kapandi");
    }


}
