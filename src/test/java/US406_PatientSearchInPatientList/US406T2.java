package US406_PatientSearchInPatientList;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utility.BaseDriver;
import utility.BaseGUITest;

public class US406T2 extends BaseGUITest{


    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;
    FindPatientPage findPatientPage;

    private static final Logger LOGGER = LogManager.getLogger(US406T1.class);

    @BeforeClass(alwaysRun = true)
    public void setupPages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        findPatientPage = new FindPatientPage(driver);
    }

    @Test(priority = 1, groups = {"smoke"})
    @Description("Verify that home page is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyHomePage() {
        homePage.verifyHomePage();
        LOGGER.info("Home page opened");
    }

    @Test(priority = 2, groups = {"smoke"})
    @Description("Demo button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickDemoBtn() {
        homePage.clickDemoBtn();
        LOGGER.info("Demo button clicked");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 3, groups = {"smoke"})
    @Description("Scroll down successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void scrollDownPage() {
        homePage.scrollDown();
        LOGGER.info("Scroll down");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 4, groups = {"smoke"})
    @Description("EnterOpenMRS3 button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickEnterOpenMRS() {
        homePage.clickEnterOpenMRS();
        LOGGER.info("EnterOpenMRS3 button clicked");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 5, groups = {"smoke"})
    @Description("Verify that Login page is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginPage() {
        loginPage.checkPageUsername();
        LOGGER.info("Login page opened");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 6, groups = {"smoke"}, dataProvider = "UsernameData", dataProviderClass = DataRepo.class)
    @Description("Username entered successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
        LOGGER.info("Username entered");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 7, groups = {"smoke"})
    @Description("Continue button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickContinueBtn() {
        loginPage.clickContinueBtn();
        LOGGER.info("Continue button clicked");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 8, groups = {"smoke"}, dataProvider = "PasswordData", dataProviderClass = DataRepo.class)
    @Description("Password entered successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
        LOGGER.info("Password entered");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 9, groups = {"smoke"})
    @Description("Login button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickLoginBtn() {
        loginPage.clickLoginBtn();
        LOGGER.info("Login button clicked");
    }

    @Test(priority = 10, groups = {"smoke"})
    @Description("Verify that Dashboard page is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyDashboardPage() {
        dashboardPage.verifyOpenMRSText();
        LOGGER.info("Dashboard page opened");
        BaseDriver.threadWait(3);
    }


    @Test(priority = 11, groups = {"Patient Management"})
    @Description("Click on search button")
    @Severity(SeverityLevel.NORMAL)
    public void clickSearchBox() {
        dashboardPage.clickSearchBox();
        LOGGER.info("Search Box clicked");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 12, groups = {"Patient Management"}, dataProvider = "InvalidPatientData", dataProviderClass = DataRepo.class)
    @Description("Searched Patient entered")
    @Severity(SeverityLevel.NORMAL)
    public void searchPatient(String patient) {
        dashboardPage.sendKeySearchBox("Invalid Patient");
        LOGGER.info("Invalid Search patient done");
        BaseDriver.threadWait(3);}

    @Test(priority = 13, groups = {"Patient Management"})
            @Description("Invalid Patient Text is seen")
    @Severity(SeverityLevel.NORMAL)
    public void verifyInvalidPatientText(){
        findPatientPage.verifyInvalidPatient();
        LOGGER.info("Invalied Patient Text seen");
        BaseDriver.threadWait(3);

    }


}
