package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@class='zak-button']")
    private WebElement demoButton;

    @FindBy(xpath = "//*[@id=\"zak-content\"]/div/div/div/section[5]/div/div/div/div[2]/div/div/a/span/span")
    private WebElement enterOpenMRS3;

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

    public void clickEnterOpenMRS(){
        clickElement(enterOpenMRS3);
        LOGGER.info("Enter the OpenMRS Demo link clicked");
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        LOGGER.info("The scroll worked successfully.");
    }
}



