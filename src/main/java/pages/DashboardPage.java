package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//header//*[name()='svg' and @aria-label='OpenMRS Logo']")
    private WebElement openMRSText;

    @FindBy(xpath = "//span[contains(@class, 'currentLocationText')]")
    private WebElement locationText;

    @FindBy(xpath = "//*[@id=\"single-spa-application:@openmrs/esm-primary-navigation-app-page-0\"]/div/header/div[3]/div[1]/div[1]/div/div/span/div/button/svg")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id='search-input-:rer:']")
    private WebElement sendKeySearchBox;

    public DashboardPage(final WebDriver driver) {
        super(driver);
    }

    public void clickSearchBox(){
        clickElement(searchBox);
        LOGGER.info("Search box clicked");
    }
    public void sendKeySearchBox(final String patient) {
        sendKeysToElement(sendKeySearchBox, patient);
        LOGGER.info("Patient name entered");
    }
}
