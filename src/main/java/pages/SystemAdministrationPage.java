package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SystemAdministrationPage extends BasePage {

    public SystemAdministrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='-esm-system-admin__card__content___5RuBL']")
    private WebElement legacyAdminButton;

    @FindBy(xpath = "//*[@id=\"single-spa-application:@openmrs/esm-system-admin-app-page-0\"]/div/div[2]/div/div[2]/div/a/div[1]/div[1]")
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