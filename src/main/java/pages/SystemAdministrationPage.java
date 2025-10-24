package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SystemAdministrationPage extends BasePage {

    public SystemAdministrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Legacy Admin")
    private WebElement legacyAdminButton;

    @FindBy(xpath = "//h1[contains(text(), 'System Administration')]")
    private WebElement pageHeader;

    public void verifyPage() {
        verifyDisplayed(pageHeader, "System Administration sayfası yüklenemedi (header bulunamadı).");
        verifyDisplayed(legacyAdminButton, "'Legacy Admin' butonu bulunamadı.");
        LOGGER.info("System Administration sayfası doğrulandı.");
    }

    public void clickLegacyAdmin() {
        clickElement(legacyAdminButton);
        LOGGER.info("'Legacy Admin' butonuna tıklandı.");
    }
}