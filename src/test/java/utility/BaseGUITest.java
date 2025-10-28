package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseGUITest {

    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
   public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void init(){
        driver  = BaseDriver.driver(" https://openmrs.org/");
        LOGGER.info("Web sitesi acildi");
    }

    @AfterClass(alwaysRun = true)
    public void quitTest() {
        driver.quit();
        LOGGER.info("Tarayici kapandi");
    }
}
