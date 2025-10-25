package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LegacyAdminPage extends BasePage {

    public LegacyAdminPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='adminMenuList']//h4[normalize-space(text())='Patients']/following-sibling::ul//a[normalize-space(text())='Manage Patients']")
    private WebElement managePatientsButton;

    @FindBy(xpath = "//h1[contains(text(), 'Legacy Administration')]")
    private WebElement pageHeader;

    public void verifyPage() {
        verifyDisplayed(pageHeader, "Legacy Administration sayfası yüklenemedi (header bulunamadı).");
        verifyDisplayed(managePatientsButton, "'Manage Patients' butonu bulunamadı.");
        LOGGER.info("Legacy Administration sayfası doğrulandı.");
    }

    public void clickManagePatients() {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        clickElement(managePatientsButton);
        LOGGER.info("'Manage Patients' butonuna tıklandı.");
    }
}
