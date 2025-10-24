package US407_PatientDeletion;

import org.testng.annotations.Test;
import pages.*;
import utility.BaseGUITest;

public class US_407 extends BaseGUITest {

    private final String username = "admin";
    private final String password = "Admin123";
    private final String deletionReason = "Test Automation Deletion";

    String name = "Delpiero";

    @Test(groups = {"Regression", "PatientManagement"})
    public void US_407_deletePatientTest() {

        LOGGER.info("US_407 Testi Başlıyor.");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        //Ae_SystemAdministrationPage sysAdminPage = new Ae_SystemAdministrationPage(driver);
        //Ae_LegacyAdminPage legacyAdminPage = new Ae_LegacyAdminPage(driver);
        //Ae_ManagePatientsPage managePatientsPage = new Ae_ManagePatientsPage(driver);

        LOGGER.info("Adım 1-8: Login işlemi yapılıyor.");
        homePage.clickDemoBtn();
        homePage.scrollDown();
        homePage.clickEnterOpenMRS();
        loginPage.enterUsername(username);
        loginPage.clickContinueBtn();
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();

        LOGGER.info("Adım 9: 'App Menu' tıklanıyor.");
        dashboardPage.clickAppMenu();

        LOGGER.info("Adım 10: 'System Administration' tıklanıyor.");
        dashboardPage.clickSystemAdministration();

        LOGGER.info("Adım 11: 'Legacy Admin' tıklanıyor.");
        /*sysAdminPage.verifyPage();
        sysAdminPage.clickLegacyAdmin();

        LOGGER.info("Adım 12: 'Manage Patients' tıklanıyor.");
        legacyAdminPage.clickManagePatients();

        managePatientsPage.verifyPage();

        LOGGER.info(name + " aranıyor ve seçiliyor.");
        managePatientsPage.searchAndSelectPatient(name);

        LOGGER.info("Adım 15: Silme nedeni giriliyor.");
        managePatientsPage.enterDeletionReason(deletionReason);

        LOGGER.info("Adım 16: 'Delete Patient' butonuna tıklanıyor.");
        managePatientsPage.clickDeletePatient();

        LOGGER.info("Test Başarılı: Hasta (Adı: " + name + ") başarıyla silindi.");*/
    }
}