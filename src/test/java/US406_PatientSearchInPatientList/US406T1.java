package US406_PatientSearchInPatientList;


import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.*;
import utility.BaseGUITest;

public class US406T1 extends BaseGUITest {

    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    FindPatientPage findPatientPage;
    private static final Logger LOGGER = LogManager.getLogger(US406T1.class);

    @Test(priority = 1, groups = {"smoke"})
    @Description("Verify Home page is visible")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyHomePage() {
        homePage.verifyHomePage();
        LOGGER.info("Home page is visible");
    }

    @Test(priority = 2, groups = {"smoke", "login"}, dependsOnMethods = "verifyHomePage")
    @Description("Click on the Demo button")
    @Severity(SeverityLevel.CRITICAL)
    public void clickDemoBtn() {
        homePage.clickDemoBtn();
        LOGGER.info("Demo button clicked");
    }

    @Test(priority = 3, groups = {"smoke", "login"}, dependsOnMethods = "clickDemoBtn")
    @Description("Scroll down")
    @Severity(SeverityLevel.MINOR)
    public void scrollDown() {
        homePage.scrollDown();
        LOGGER.info("Scrolled Down");
    }

    @Test(priority = 4, groups = {"smoke", "login"}, dependsOnMethods = "scrollDown")
    @Description("EnterOpenMRS3 button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickEnterOpenMRS() {
        homePage.clickEnterOpenMRS();
        LOGGER.info("EnterOpenMRS3 button clicked");
    }

    @Test(priority = 5, groups = {"smoke", "login"}, dependsOnMethods = "clickEnterOpenMRS")
    @Description("Verify that Login page is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginPage() {
        loginPage.checkPageUsername();
        LOGGER.info("Login page opened");
    }

    @Test(priority = 6, groups = {"smoke"}, dataProvider = "LoginData", dataProviderClass = DataRepo.class, dependsOnMethods = "verifyLoginPage")
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

    @Test(priority = 8, groups = {"smoke"}, dataProvider = "LoginData", dataProviderClass = DataRepo.class, dependsOnMethods = "clickContinueBtn")
    @Description("Password entered successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void enterPassword(String password) {
        loginPage.enterPassword(password);

    }

    @Test(priority = 9, groups = {"smoke"}, dependsOnMethods = "enterPassword")
    @Description("Login button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickLoginBtn() {
        loginPage.clickLoginBtn();
        LOGGER.info("Login button clicked");
    }

    @Test(priority = 10, groups = {"Patient Management"}, dependsOnGroups = {"smoke", "login"})
    @Description("Search Button clicked successfullu")
    @Severity(SeverityLevel.NORMAL)
    public void clickSearchBtn() {
        dashboardPage.clickSearchBox();
        LOGGER.info("Search Button clicked");
    }

    @Test(priority = 11, groups = {"Patient Management"}, dependsOnGroups = {"smoke", "login"}, dataProvider = "PatientData", dataProviderClass = DataRepo.class)
    @Description("Searched Patient entered")
    @Severity(SeverityLevel.NORMAL)
    public void searchPatient(String patient) {
        dashboardPage.sendKeySearchBox(patient);
        LOGGER.info("Search patient done");
    }

    @Test(priority = 12, groups = {"Patient Management"})
    @Description("Searched patient successfully found")
    @Severity(SeverityLevel.NORMAL)
    public void verifyPatientFound() {
        findPatientPage.verifyPatientName();
        LOGGER.info("Patient found successfully");
    }

    @Test(priority = 13, groups = {"Patient Management"})
    @Description("Appointments is visible")
    @Severity(SeverityLevel.NORMAL)
    public void verifyAppointments() {
        findPatientPage.appointments();
    }

    @Attachment(value = "Adim sayisi", type = "text/plain")
    public String step(String message) {
        return message;
    }
}
