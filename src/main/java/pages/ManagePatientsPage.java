package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManagePatientsPage extends BasePage {

    public ManagePatientsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "patient-search") // Tahmini locator
    private WebElement searchInput;

    @FindBy(xpath = "//table[@id='patient-search-results']//tr[1]/td[1]") // Tahmini locator
    private WebElement firstSearchResult;

    @FindBy(name = "deleteReason") // Tahmini locator
    private WebElement deleteReasonInput;

    @FindBy(xpath = "//button[contains(text(), 'Delete Patient')]") // Tahmini locator
    private WebElement deletePatientButton;

    @FindBy(id = "info-message") // Tahmini locator
    private WebElement successMessage;

    public void verifyPage() {
        verifyDisplayed(searchInput, "Manage Patients sayfası yüklenemedi (Arama kutusu bulunamadı).");
        LOGGER.info("Manage Patients sayfası doğrulandı.");
    }

    public void searchAndSelectPatient(String patientNameOrId) {
        sendKeysToElement(searchInput, patientNameOrId);
        LOGGER.info("Hasta arandı: " + patientNameOrId);

        clickElement(firstSearchResult);
        LOGGER.info("Arama sonucundaki ilk hasta seçildi.");
    }

    public void enterDeletionReason(String reason) {
        sendKeysToElement(deleteReasonInput, reason);
        LOGGER.info("Silme nedeni girildi: " + reason);
    }

    public void clickDeletePatient() {
        clickElement(deletePatientButton);
        LOGGER.info("'Delete Patient' butonuna tıklandı.");
    }

    public String getSuccessMessageText() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        String message = successMessage.getText();
        LOGGER.info("Başarı mesajı okundu: " + message);
        return message;
    }
}