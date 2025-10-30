package US401_CheckingLoginErrorsInTheSystem;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DataRepo;
import pages.HomePage;
import pages.LoginPage;
import utility.BaseDriver;
import utility.BaseGUITest;

public class US_401 extends BaseGUITest {

    private HomePage homePage;
    private LoginPage loginPage;

    private static final Logger LOGGER = LogManager.getLogger(US_401.class);

    @BeforeClass
    public void setupPages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    @Test(priority =1 , groups = {"smoke"})
    @Description("Verify that home page is visible successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyHomePage(){homePage.verifyHomePage();
        LOGGER.info("Home page opened");
    }
    @Test(priority = 2, groups = {"smoke"})
    @Description("Demo button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickDemoBtn(){homePage.clickDemoBtn();
        LOGGER.info("Demo button clicked");
    }

    @Test(priority = 3, groups = {"smoke"})
    @Description("EnterOpenMRS3 button clicked successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clickEnterOpenMRS(){homePage.clickEnterOpenMRS();
        LOGGER.info("Mrs3 demo button clicked");
    }


    @Test(priority = 4,groups = {"Login"}, dataProvider = "invalid login credentials",
            dataProviderClass = DataRepo.class)
    @Description("Verify not login with wrong credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void checkLoginWithInvalidData(String username, String password) {
        loginPage.fillLoginMask(username, password);
        LOGGER.info("Username and password entered");

        loginPage.clickLoginBtn();
        LOGGER.info("Login button clicked");

        loginPage.checkInvalidCredentialsMessage();
        LOGGER.info("Invalid message displayed");

        BaseDriver.threadWait(2);
    }
    @Attachment(value = "Adim sayisi", type = "text/plain")
    public String step(String message) {
        return message;
    }
}
