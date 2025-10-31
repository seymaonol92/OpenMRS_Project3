package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FindPatientPage extends BasePage{

    @FindBy(xpath = "//*[text()='Scarlett Johansson']")
    private WebElement patientName;

    @FindBy(xpath = "//*[@class='cds--tile -esm-patient-search__patient-search__emptySearchResultsTile___KHKBc']")
    private WebElement invalidPatientText;

    public void verifyPatientName(){
        verifyDisplayed(patientName, "Patient not found");
        Assert.assertTrue(patientName.isDisplayed(), "Patient is not visible");
        LOGGER.info("Searched Patient is found");
    }
    public void verifyInvalidPatient (){
        verifyDisplayed(invalidPatientText, "Invalid Patient Text is not visible");
        Assert.assertTrue(invalidPatientText.isDisplayed(), "İnavlid Patient text is not seen");
        LOGGER.info("Invalid Patient text is seen");
    }
    public FindPatientPage(WebDriver driver) {
        super(driver);
    }
}
