package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MergePatientsPage extends BasePage {


    @FindBy(xpath = "//a[@class='cds--link cds--tile cds--tile--clickable -esm-system-admin__card__overviewCard___9oWKP']")
    private WebElement clickLegacyAdmin;

    @FindBy(xpath = "//h2[contains(text(), 'Administration')] | //div[@id='content']/h2")
    private WebElement verifyAdministrationText;

    @FindBy(xpath = "//a[contains(text(), 'Find Patients to Merge')] | //a[contains(@href, 'mergePatients')]")
    private WebElement clickFindPatientToMerge;

    @FindBy(xpath = "//input[@id='identifiers']")
    private WebElement verifyIdentifier;

    @FindBy(xpath = "//input[@id='identifiers']")
    private WebElement sendKeyIDs;

    @FindBy(xpath = "//input[@onclick='searchByIndentifier(event)']")
    private WebElement clickSearchBtn;

    @FindBy(xpath = "(//input[@name='patientId'])[1]")
    private WebElement selectCheckbox1;

    @FindBy(xpath = "(//input[@name='patientId'])[2]")
    private WebElement selectCheckbox2;

    @FindBy(xpath = "//input[@type='submit' and @value='Continue']")
    private WebElement clickContinueBtn;

    @FindBy(xpath = "//input[contains(@id, 'preferred')]")
    private WebElement selectPreferred;

    @FindBy(xpath = "//input[@id='mergeButton']")
    private WebElement clickMergePatients;

    @FindBy(xpath = "//div[@id='openmrs_msg']")
    private WebElement verifyMergeSuccess;


    public MergePatientsPage(WebDriver driver) {
        super(driver);
    }

    public void clickLegacyAdmin() {
        String originalWindow = driver.getWindowHandle();
        LOGGER.info("Original window: " + originalWindow);

        clickElement(clickLegacyAdmin);
        LOGGER.info("Clicked on 'Legacy Admin' button successfully.");

        try {
            Thread.sleep(2000);

            java.util.Set<String> allWindows = driver.getWindowHandles();
            LOGGER.info("Total windows: " + allWindows.size());

            if (allWindows.size() > 1) {
                for (String windowHandle : allWindows) {
                    if (!windowHandle.equals(originalWindow)) {
                        driver.switchTo().window(windowHandle);
                        LOGGER.info("Switched to new window/tab");
                        break;
                    }
                }
            }

            Thread.sleep(1000);
            LOGGER.info("Current URL after Legacy Admin: " + driver.getCurrentUrl());

        } catch (Exception e) {
            LOGGER.error("Error in clickLegacyAdmin: " + e.getMessage());
        }
    }

    public void verifyAdministrationText() {
        try {
            // Log all links on the page to see what's available
            java.util.List<WebElement> allLinks = driver.findElements(org.openqa.selenium.By.tagName("a"));
            LOGGER.info("Total links found on page: " + allLinks.size());

            int count = 0;
            for (WebElement link : allLinks) {
                try {
                    String linkText = link.getText();
                    String linkHref = link.getAttribute("href");
                    if (linkText != null && !linkText.trim().isEmpty()) {
                        LOGGER.info("Link " + (++count) + ": " + linkText + " -> " + linkHref);
                    }
                } catch (Exception e) {
                    // Skip if element is stale
                }
            }

            verifyDisplayed(verifyAdministrationText, "Administration Text is not visible");
            LOGGER.info("Administration text is displayed correctly.");
        } catch (Exception e) {
            LOGGER.error("Error in verifyAdministrationText: " + e.getMessage());
            throw e;
        }
    }
    public void clickFindPatientToMerge() {
        try {
            LOGGER.info("Attempting to find 'Find Patients to Merge' element...");
            LOGGER.info("Current URL before finding element: " + driver.getCurrentUrl());
            LOGGER.info("Current window handles: " + driver.getWindowHandles().size());

            clickElement(clickFindPatientToMerge);
            LOGGER.info("Clicked on 'Find Patients to Merge' link successfully.");
        } catch (Exception e) {
            LOGGER.error("Failed to click 'Find Patients to Merge': " + e.getClass().getName());
            LOGGER.error("Error message: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
    public void verifyIdentifier() {
        verifyDisplayed(verifyIdentifier, "Identifier Text is not visible");
        LOGGER.info("Identifier text is displayed correctly.");
    }
    public void sendKeyIDs(final String ID1, String ID2) {
        String combinedIDs = ID1 + ", " + ID2;
        sendKeysToElement(sendKeyIDs, combinedIDs);
        LOGGER.info("Entered patient IDs: {} and {}", ID1, ID2);
    }
    public void clickSearchBtn() {
        clickElement(clickSearchBtn);
        LOGGER.info("Clicked on 'Search' button successfully.");
    }
    public void selectCheckbox1() {
        clickElement(selectCheckbox1);
        LOGGER.info("Checkbox1 selected successfully.");
    }
    public void selectCheckbox2() {
        clickElement(selectCheckbox2);
        LOGGER.info("Checkbox2 selected successfully.");
    }
    public void clickContinueButton() {
        clickElement(clickContinueBtn);
        LOGGER.info("Clicked on 'Continue' button successfully.");

        try {
            Thread.sleep(3000);

            LOGGER.info("Looking for mergePatientPopupIframe...");
            wait.until(org.openqa.selenium.support.ui.ExpectedConditions.frameToBeAvailableAndSwitchToIt("mergePatientPopupIframe"));
            LOGGER.info("Switched to mergePatientPopupIframe successfully");

            Thread.sleep(2000);
            LOGGER.info("Iframe content loaded");

        } catch (Exception e) {
            LOGGER.error("Error in clickContinueButton: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void selectPreferred() throws InterruptedException {
        try {
            LOGGER.info("Attempting to select Preferred element...");

            wait.until(org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated(
                org.openqa.selenium.By.xpath("//input[contains(@id, 'preferred')]")));

            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", selectPreferred);
            LOGGER.info("Scrolled to Preferred element");

            Thread.sleep(1000);

            clickElement(selectPreferred);
            LOGGER.info("Preferred selected successfully.");

            Thread.sleep(1500);
            LOGGER.info("Waiting for Merge Patients button to appear after selecting Preferred");

            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", clickMergePatients);
            LOGGER.info("Scrolled to Merge Patients button");
            Thread.sleep(1000);

        } catch (Exception e) {
            LOGGER.error("Failed to select Preferred: " + e.getClass().getName());
            LOGGER.error("Error message: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
    public void clickMergePatients() throws InterruptedException {
        try {
            LOGGER.info("Attempting to click Merge Patients button...");

            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", clickMergePatients);
            LOGGER.info("Scrolled to Merge Patients button");

            Thread.sleep(1000);

            clickElement(clickMergePatients);
            LOGGER.info("Clicked on 'Merge Patients' button successfully.");

            Thread.sleep(1000);
            try {
                org.openqa.selenium.Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                LOGGER.info("Alert appeared with text: " + alertText);
                alert.accept();
                LOGGER.info("Accepted alert successfully");
            } catch (org.openqa.selenium.NoAlertPresentException e) {
                LOGGER.info("No alert present, continuing...");
            }

        } catch (Exception e) {
            LOGGER.error("Failed to click Merge Patients: " + e.getMessage());
            throw new RuntimeException("Could not click Merge Patients button", e);
        }
    }
    public void verifyMergeSuccess() {
        verifyDisplayed(verifyMergeSuccess, "Merge success text is not visible");
        LOGGER.info("Merge success text is displayed correctly.");
    }
}
