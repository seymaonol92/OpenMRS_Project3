package US404_PatientRegistration;
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

public class US_404 extends BaseGUITest {

    private static final Logger LOGGER = LogManager.getLogger(US_404.class);

    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    PatientRegistrationPage regPage;

    @BeforeClass(alwaysRun = true)
    public void setupPages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        regPage = new PatientRegistrationPage(driver);
    }

    @Test(priority = 1, groups = {"Regression", "PatientManagement"})
    @Description("Verify that home page is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void T1_verifyHomePage() {
        homePage.verifyHomePage();
        LOGGER.info("Home page opened");
    }

    @Test(priority = 2, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T1_verifyHomePage")
    @Description("Click Demo button on Home Page")
    @Severity(SeverityLevel.CRITICAL)
    public void T2_clickDemoBtn() {
        homePage.clickDemoBtn();
        LOGGER.info("Demo button clicked");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 3, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T2_clickDemoBtn")
    @Description("Scroll down Home Page")
    @Severity(SeverityLevel.NORMAL)
    public void T3_scrollDownPage() {
        homePage.scrollDown();
        LOGGER.info("Scroll down");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 4, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T3_scrollDownPage")
    @Description("Click Enter OpenMRS button")
    @Severity(SeverityLevel.CRITICAL)
    public void T4_clickEnterOpenMRS() {
        homePage.clickEnterOpenMRS();
        LOGGER.info("EnterOpenMRS button clicked");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 5, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T4_clickEnterOpenMRS")
    @Description("Verify Login page is visible (Username field checked)")
    @Severity(SeverityLevel.CRITICAL)
    public void T5_verifyLoginPage() {
        loginPage.checkPageUsername();
        LOGGER.info("Login page opened");
    }

    @Test(priority = 6, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T5_verifyLoginPage")
    @Description("Enter Username")
    @Severity(SeverityLevel.CRITICAL)
    public void T6_enterUsername() {
        loginPage.enterUsername("admin");
        LOGGER.info("Username entered");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 7, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T6_enterUsername")
    @Description("Click Continue button")
    @Severity(SeverityLevel.CRITICAL)
    public void T7_clickContinueBtn() {
        loginPage.clickContinueBtn();
        LOGGER.info("Continue button clicked");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 8, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T7_clickContinueBtn")
    @Description("Enter Password")
    @Severity(SeverityLevel.CRITICAL)
    public void T8_enterPassword() {
        loginPage.enterPassword("Admin123");
        LOGGER.info("Password entered");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 9, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T8_enterPassword")
    @Description("Click Login button")
    @Severity(SeverityLevel.CRITICAL)
    public void T9_clickLoginBtn() {
        loginPage.clickLoginBtn();
        LOGGER.info("Login button clicked");
    }

    @Test(priority = 10, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T9_clickLoginBtn")
    @Description("Navigate to Add Patient page from Dashboard")
    @Severity(SeverityLevel.NORMAL)
    public void T10_navigateAddPatient() {
        dashboardPage.navbarClickAddPatient();
        LOGGER.info("Go to the Patient Registration page.");
    }

    @Test(
            priority = 11,
            groups = {"Regression", "PatientManagement"},
            dependsOnMethods = "T10_navigateAddPatient",
            dataProvider = "PatientRegistrationData",
            dataProviderClass = DataRepo.class
    )
    @Description("Fill and Submit Patient Registration Form")
    @Severity(SeverityLevel.CRITICAL)
    public void T11_fillAndSubmitForm(String firstName, String familyName, String gender, String birthdate, String address) {
        LOGGER.info("Filling out the patient registration form: " + firstName + " " + familyName);
        regPage.verifyPage();

        regPage.fillAndSubmitRegistrationForm(
                firstName,
                familyName,
                gender,
                birthdate,
                address
        );
        BaseDriver.threadWait(3);
        LOGGER.info("The record has been created.");
    }
}
