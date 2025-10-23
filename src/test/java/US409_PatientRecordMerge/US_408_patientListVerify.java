package US409_PatientRecordMerge;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utility.BaseGUITest;

public class US_408_patientListVerify extends BaseGUITest {

    public HomePage homePage;
    public LoginPage loginPage;
    WebDriver driver;
    @BeforeClass
    public void pages(){

        homePage=new HomePage(driver);
         loginPage=new LoginPage(driver);
    }

    @Test(priority = 1, description = "")
    public void homePage(){
        homePage.verifyHomePage();
    }
    @Test(priority = 2, description = "")
    public void clickDemoButtn(){
    homePage.clickDemoBtn();
    }
    @Test(priority = 3,description = "")
    public void scrollEnterMRS3(){
        homePage.scrollDown();
    }

    @Test(priority = 4, description = "")
    public void clickEnterOpenMRS(){
        homePage.clickEnterOpenMRS();
    }

    /*@Test(priority = 5, description = "")
    public void


     */






}
