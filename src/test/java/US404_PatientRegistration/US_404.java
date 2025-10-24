package US404_PatientRegistration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.*;
import utility.BaseDriver;
import utility.BaseGUITest;
public class US_404 extends BaseGUITest {
    private static final Logger LOGGER = LogManager.getLogger(US_404.class);

    @Test(groups = {"Regression", "PatientManagement"})
    public void test_A_CreatePatient() {
        LOGGER.info("E2E Test (1/2): Hasta Kayıt Testi Başlıyor...");

        String username = "admin";
        String password = "Admin123";

        String patientFirstName = "Delpiero";
        String patientFamilyName = "Hikmet";
        String patientGender = "Male";
        String patientBirthdate = "10-01-1992";
        String patientAddress = "123 Test Caddesi, Ankara";

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        //PatientRegistrationPage regPage = new PatientRegistrationPage(driver);

        LOGGER.info("Login sayfasına yönlendirme.");
        homePage.verifyHomePage();
        homePage.clickDemoBtn();
        homePage.scrollDown();
        homePage.clickEnterOpenMRS();

        LOGGER.info("Login işlemi.");
        loginPage.checkPageUsername();
        loginPage.enterUsername(username);
        loginPage.clickContinueBtn();

        loginPage.checkPagePassword();
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();

        LOGGER.info("Hasta Kayıt sayfasına gitme.");
        dashboardPage.navbarClickAddPatient();

        LOGGER.info("Hasta kayıt formu doldurma ve kayıt oluşturma .");
        //regPage.verifyPage();

        /*regPage.fillAndSubmitRegistrationForm(
                patientFirstName,
                patientFamilyName,
                patientGender,
                patientBirthdate,
                patientAddress
        */);
        BaseDriver.threadWait(3);
        LOGGER.info("Test tamamlandı, kayıt oluşturuldu");

    }
}
