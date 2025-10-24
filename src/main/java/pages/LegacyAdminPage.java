package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LegacyAdminPage extends BasePage {

    public LegacyAdminPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "adminui-managePatients-app") // ID'ye göre daha stabil olabilir
    private WebElement managePatientsButton;

    @FindBy(xpath = "//h1[contains(text(), 'Legacy Administration')]")
    private WebElement pageHeader;

    public void verifyPage() {
        verifyDisplayed(pageHeader, "Legacy Administration sayfası yüklenemedi (header bulunamadı).");
        verifyDisplayed(managePatientsButton, "'Manage Patients' butonu bulunamadı.");
        LOGGER.info("Legacy Administration sayfası doğrulandı.");
    }

    public void clickManagePatients() {
        clickElement(managePatientsButton);
        LOGGER.info("'Manage Patients' butonuna tıklandı.");
    }
}
