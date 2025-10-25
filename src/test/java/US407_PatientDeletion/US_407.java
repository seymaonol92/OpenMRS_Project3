package US407_PatientDeletion;

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

public class US_407 extends BaseGUITest {

    private static final Logger LOGGER = LogManager.getLogger(US_407.class);

    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    SystemAdministrationPage sysAdminPage;
    LegacyAdminPage legacyAdminPage;
    ManagePatientsPage managePatientsPage;

    @BeforeClass(alwaysRun = true)
    public void setupPages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        sysAdminPage = new SystemAdministrationPage(driver);
        legacyAdminPage = new LegacyAdminPage(driver);
        managePatientsPage = new ManagePatientsPage(driver);
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
    @Description("Enter Username")
    @Severity(SeverityLevel.CRITICAL)
    public void T5_enterUsername() {
        loginPage.enterUsername("admin");
        LOGGER.info("Username entered");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 6, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T5_enterUsername")
    @Description("Click Continue button")
    @Severity(SeverityLevel.CRITICAL)
    public void T6_clickContinueBtn() {
        loginPage.clickContinueBtn();
        LOGGER.info("Continue button clicked");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 7, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T6_clickContinueBtn")
    @Description("Enter Password")
    @Severity(SeverityLevel.CRITICAL)
    public void T7_enterPassword() {
        loginPage.enterPassword("Admin123");
        LOGGER.info("Password entered");
        BaseDriver.threadWait(3);
    }

    @Test(priority = 8, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T7_enterPassword")
    @Description("Click Login button")
    @Severity(SeverityLevel.CRITICAL)
    public void T8_clickLoginBtn() {
        loginPage.clickLoginBtn();
        LOGGER.info("Login button clicked");
    }

    @Test(priority = 9, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T8_clickLoginBtn")
    @Description("Click on 'App Menu' on Dashboard")
    @Severity(SeverityLevel.NORMAL)
    public void T9_clickAppMenu() {
        LOGGER.info("Adım 9: 'App Menu' tıklanıyor.");
        dashboardPage.clickAppMenu();
        BaseDriver.threadWait(3);
    }

    @Test(priority = 10, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T9_clickAppMenu")
    @Description("Click on 'System Administration'")
    @Severity(SeverityLevel.NORMAL)
    public void T10_clickSystemAdministration() {
        LOGGER.info("Adım 10: 'System Administration' tıklanıyor.");
        dashboardPage.clickSystemAdministration();
        BaseDriver.threadWait(3);
    }

    @Test(priority = 11, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T10_clickSystemAdministration")
    @Description("Click on 'Legacy Admin'")
    @Severity(SeverityLevel.NORMAL)
    public void T11_clickLegacyAdmin() {
        LOGGER.info("Adım 11: 'Legacy Admin' tıklanıyor.");
        sysAdminPage.verifyPage();
        sysAdminPage.clickLegacyAdmin();
        BaseDriver.threadWait(3);
    }

    @Test(priority = 12, groups = {"Regression", "PatientManagement"}, dependsOnMethods = "T11_clickLegacyAdmin")
    @Description("Click on 'Manage Patients'")
    @Severity(SeverityLevel.NORMAL)
    public void T12_clickManagePatients() {
        LOGGER.info("Adım 12: 'Manage Patients' tıklanıyor.");
        legacyAdminPage.clickManagePatients();
    }

    @Test(
            priority = 13,
            groups = {"Regression", "PatientManagement"},
            dependsOnMethods = "T12_clickManagePatients",
            dataProvider = "PatientDeletionData",
            dataProviderClass = DataRepo.class
    )
    @Description("Search, Enter Reason, and Delete Patient")
    @Severity(SeverityLevel.CRITICAL)
    public void T13_searchAndCompleteDeletion(String patientName, String reason) {

        
        LOGGER.info(patientName + " aranıyor ve seçiliyor.");
        managePatientsPage.searchAndSelectPatient(patientName);
        BaseDriver.threadWait(3);

        LOGGER.info("Adım 15: Silme nedeni giriliyor: " + reason);
        managePatientsPage.enterDeletionReason(reason);
        BaseDriver.threadWait(3);

        LOGGER.info("Adım 16: 'Delete Patient' butonuna tıklanıyor.");
        managePatientsPage.clickDeletePatient();
        BaseDriver.threadWait(3);
        LOGGER.info("Test Başarılı: Hasta (Adı: " + patientName + ") başarıyla silindi.");

    }
}