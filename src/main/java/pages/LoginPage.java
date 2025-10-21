package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//legend[@class='w-auto']")
    private WebElement loginHeaderText;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "loginButton")
    private WebElement loginBtn;

    @FindBy(xpath = "//li[@id='Inpatient Ward']")
    private WebElement inpatientWardLocation;

    @FindBy(id = "error-message")
    private WebElement invalidMessage;

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    public void checkPage() {
        verifyDisplayed(usernameInput, "The login page did not open (username field not found).");
        verifyDisplayed(passwordInput, "he login page did not open (password field not found).");
        verifyDisplayed(loginBtn,      "The login page did not open (login button not found).");
        LOGGER.info("Login page verified");
    }

    public void fillLoginForm(final String username, final String password) {
        sendKeysToElement(usernameInput, username);
        LOGGER.info("Username entered");
        sendKeysToElement(passwordInput, password);
        LOGGER.info("Password entered");
    }

    public void selectInpatientWard() {
        verifyDisplayed(inpatientWardLocation, "The ‘Inpatient Ward’ location is not visible.");
        clickElement(inpatientWardLocation);
        LOGGER.info("'Inpatient Ward' location selected");
    }

    public void clickLoginBtn(){
        clickElement(loginBtn);
        LOGGER.info("Login button clicked");
    }
    public void checkInvalidCredentialsMessage() {
        verifyDisplayed(invalidMessage, "The invalid username/password warning is not visible.");
        LOGGER.info("Invalid credentials message visible");
    }

}

