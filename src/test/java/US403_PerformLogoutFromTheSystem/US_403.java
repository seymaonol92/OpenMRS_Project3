package US403_PerformLogoutFromTheSystem;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import utility.BaseDriver;
import utility.BaseGUITest;

    public class US_403 extends BaseGUITest {

        LoginPage loginPage;
        HomePage homePage;
        DashboardPage dashboardPage;
        final String username="admin";
        final String password="Admin123";

        private static final Logger LOGGER = LogManager.getLogger(US_403.class);

        @BeforeClass
        public void setupPages() {
            homePage = new HomePage(driver);
            loginPage = new LoginPage(driver);
            dashboardPage = new DashboardPage(driver);
        }

        @Test(priority = 1, groups = {"smoke"})
        @Description("Verify that home page is visible successfully")
        @Severity(SeverityLevel.CRITICAL)
        public void verifyHomePage() {
            homePage.verifyHomePage();
            LOGGER.info("Home page opened");
        }

        @Test(priority = 2, dependsOnMethods = "verifyHomePage")
        public void clickDemoBtn() {
            homePage.clickDemoBtn();
            LOGGER.info("Demo button clicked");
        }

        @Test(priority = 3, dependsOnMethods = "clickDemoBtn")
        public void scrollDownPage() {
            homePage.scrollDown();
            LOGGER.info("Scroll down");
        }

        @Test(priority = 4, dependsOnMethods = "scrollDownPage")
        public void clickEnterOpenMRS() {
            homePage.clickEnterOpenMRS();
            LOGGER.info("Enter OpenMRS3 button clicked");
        }

        @Test(priority = 5, dependsOnMethods = "clickEnterOpenMRS")
        public void verifyLoginPage() {
            loginPage.checkPageUsername();
            LOGGER.info("Login page opened successfully");
        }

        @Test(priority = 6, dependsOnMethods = "verifyLoginPage")
        public void enterUsername() {
            loginPage.enterUsername(username);
            LOGGER.info("Username entered");
        }

        @Test(priority = 7, dependsOnMethods = "enterUsername")
        public void clickContinueBtn() {
            loginPage.clickContinueBtn();
            LOGGER.info("Continue button clicked");
        }

        @Test(priority = 8,  dependsOnMethods = "clickContinueBtn")
        public void enterPassword() {
            loginPage.enterPassword(password);
            LOGGER.info("Password entered");
        }

        @Test(priority = 9, dependsOnMethods = "enterPassword")
        public void clickLoginBtn() {
            loginPage.clickLoginBtn();
            LOGGER.info("Login button clicked");
        }

        @Test(priority = 10, dependsOnMethods = "clickLoginBtn")
        public void clickMyAccountBtn() {
            dashboardPage.clickMyAccountLink();
            LOGGER.info("Confirm button clicked");
        }
        @Test(priority = 11,dependsOnMethods = "clickMyAccountBtn")
        public void clickLogoutBtn(){
            dashboardPage.clickLogOut();
            LOGGER.info("Clicked Logout Button");
        }
        @Test(priority = 12,dependsOnMethods = "clickLogoutBtn")
        public void verifyLoginPageAgain(){
            loginPage.checkPageUsername();
            LOGGER.info("Login page opened successfully");
            BaseDriver.threadWait(3);
        }

        @Attachment(value = "Step", type = "text/plain")
        public String step(String message) {
            return message;
        }
    }