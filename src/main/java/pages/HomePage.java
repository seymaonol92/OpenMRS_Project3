package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@class='zak-button']")
    private WebElement demoButton;

    @FindBy(xpath = "//span[contains(text(),'Explore OpenMRS 2')]")
    private WebElement exploreOpenMRS2;

    @FindBy(xpath = "//span[contains(text(),'Enter the OpenMRS 2')]")
    private WebElement enterOpenMRS2;

    public HomePage(final WebDriver driver){
        super(driver);
    }

    public void verifyHomePage() {
        verifyDisplayed(demoButton, "Home page not loaded");
        LOGGER.info("Home page verified successfully");
    }

    public void clickDemoBtn() {
        clickElement(demoButton);
        LOGGER.info("Demo button clicked");
    }

    public void clickExploreOpenMRS(){
        clickElement(exploreOpenMRS2);
        LOGGER.info("Explore OpenMRS button clicked");
    }

    public void clickEnterOpenMRS(){
        clickElement(enterOpenMRS2);
        LOGGER.info("Enter the OpenMRS Demo link clicked");
    }
}



