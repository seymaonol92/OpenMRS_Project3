package US409_PatientRecordMerge;

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

public class US_409 extends BaseGUITest {
    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;
    MergePatientsPage mergePatientsPage;

    private static final Logger LOGGER = LogManager.getLogger(US_409.class);

    @BeforeClass(alwaysRun = true)
    public void setupPages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        mergePatientsPage = new MergePatientsPage(driver);
    }
    @Test(priority = 1, groups = {"regression","patient management"})
    @Description("Verify that home page is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyHomePage() {
        homePage.verifyHomePage();
        LOGGER.info("Home page opened");
    }

    @Test(priority = 2,groups = {"regression","patient management"},dependsOnMethods = "verifyHomePage")
    @Description("Demo button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickDemoBtn() {
        homePage.clickDemoBtn();
        LOGGER.info("Demo button clicked");
    }
    @Test(priority = 3, groups = {"regression","patient management"})
    @Description("Scroll down successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void scrollDownPage() {
        homePage.scrollDown();
        LOGGER.info("Scroll down");
    }
    @Test(priority = 4, groups = {"regression","patient management"})
    @Description("EnterOpenMRS3 button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickEnterOpenMRS() {
        homePage.clickEnterOpenMRS();
        LOGGER.info("EnterOpenMRS3 button clicked");
    }

    @Test(priority = 5, groups = {"regression","patient management"})
    @Description("Verify that Login page is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginPage(){
        loginPage.checkPageUsername();
        LOGGER.info("Login page opened");
    }

    @Test(priority = 6,groups = {"regression","patient management"}, dataProvider = "UsernameData", dataProviderClass = DataRepo.class, dependsOnMethods = "verifyLoginPage")
    @Description("Username entered successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void enterUsername(String username){
        loginPage.enterUsername(username);
        LOGGER.info("Username entered");
    }
    @Test(priority = 7, groups = {"regression","patient management"}, dependsOnMethods = "enterUsername")
    @Description("Continue button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickContinueBtn(){
        loginPage.clickContinueBtn();
        LOGGER.info("Continue button clicked");
        BaseDriver.threadWait(2);
    }

    @Test(priority = 8, groups = {"regression","patient management"}, dataProvider = "PasswordData", dataProviderClass = DataRepo.class, dependsOnMethods = "clickContinueBtn")
    @Description("Password entered successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void enterPassword(String password){
        loginPage.enterPassword(password);
        LOGGER.info("Password entered");
    }

    @Test(priority = 9, groups = {"regression","patient management"}, dependsOnMethods = "enterPassword")
    @Description("Login button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickLoginBtn(){
        loginPage.clickLoginBtn();
        LOGGER.info("Login button clicked");
        BaseDriver.threadWait(2);
    }
    @Test(priority = 10,groups = {"regression","patient management"})
    @Description("Verify that Dashboard page is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyDashboardPage(){
        dashboardPage.verifyOpenMRSText();
        LOGGER.info("Dashboard page opened");
    }
    @Test(priority = 11, groups = {"regression","patient management"})
    @Description("App Menu clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickAppMenu() {
        dashboardPage.clickAppMenu();
        LOGGER.info("App Menu clicked");
        BaseDriver.threadWait(2);
    }
    @Test(priority = 12, groups = {"regression","patient management"})
    @Description("System Administration clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickSystemAdministration() {
        dashboardPage.clickSystemAdministration();
        LOGGER.info("System Administration clicked");
        BaseDriver.threadWait(2);
    }

    @Test(priority = 13, groups = {"regression","patient management"})
    @Description("Legacy Admin clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickLegacyAdmin() {
        mergePatientsPage.clickLegacyAdmin();
        LOGGER.info("Legacy Admin clicked");
        BaseDriver.threadWait(2);
    }
    @Test(priority = 14, groups = {"regression","patient management"})
    @Description("Find Patient To Merge clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickFindPatientToMerge() {
        mergePatientsPage.clickFindPatientToMerge();
        LOGGER.info("Find Patient To Merge clicked");
        BaseDriver.threadWait(2);
    }
    @Test(priority = 15,groups = {"regression","patient management"})
    @Description("Verify that Identifier Text is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyIdentifier(){
        mergePatientsPage.verifyIdentifier();
        LOGGER.info("Identifier Text is visible.");
    }
    @Test(priority = 16, groups = {"regression","patient management"},dataProvider = "IDsData", dataProviderClass = DataRepo.class)
    @Description("Patient IDs were submitted successfully.")
    @Severity(SeverityLevel.CRITICAL)
    public void sendKeyIDs(String ID1, String ID2) {
        mergePatientsPage.sendKeyIDs(ID1, ID2);
        LOGGER.info("Patient IDs were submitted.");
        BaseDriver.threadWait(2);
    }
    @Test(priority = 17, groups = {"regression","patient management"})
    @Description("Search button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickSearchBtn() {
        mergePatientsPage.clickSearchBtn();
        LOGGER.info("Search button clicked");
    }
    @Test(priority = 18, groups = {"regression","patient management"})
    @Description("Checkbox1 clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void selectCheckbox1() {
        mergePatientsPage.selectCheckbox1();
        LOGGER.info("Checkbox1 clicked");
        BaseDriver.threadWait(2);
    }
    @Test(priority = 19, groups = {"regression","patient management"})
    @Description("Checkbox2 clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void selectCheckbox2() {
        mergePatientsPage.selectCheckbox2();
        LOGGER.info("Checkbox2 clicked");
    }
    @Test(priority = 20, groups = {"regression","patient management"})
    @Description("Continue button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickContinueButton() {
        mergePatientsPage.clickContinueButton();
        LOGGER.info("Continue button clicked");
        BaseDriver.threadWait(2);
    }
    @Test(priority = 21, groups = {"regression","patient management"})
    @Description("Preferred selected successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void selectPreferred() throws InterruptedException {
        mergePatientsPage.selectPreferred();
        LOGGER.info("Preferred selected");
    }
    @Test(priority = 22, groups = {"regression","patient management"})
    @Description("Merge patients button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickMergePatients() throws InterruptedException {
        mergePatientsPage.clickMergePatients();
        LOGGER.info("Merge patients button clicked");
        BaseDriver.threadWait(2);
    }
    @Test(priority = 23,groups = {"regression","patient management"})
    @Description("Verify that Merge Success Text is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyMergeSuccess(){
        mergePatientsPage.verifyMergeSuccess();
        LOGGER.info("Merge Success Text is visible.");
    }
}
