package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PatientDetailsPage extends BasePage{

@FindBy (xpath = "//div[@class='cds--tab--list']/button[3]")
private WebElement myListButton;

@FindBy(xpath = "//*[@id=\"single-spa-application:@openmrs/esm-home-app-page-0\"]/main/div/section/div[2]/div/main/section/div[2]/div[2]/section/div/table/tbody/tr[5]/td[1]/a")
private WebElement barisCansizButton;

@FindBy(xpath = "//div[@class='E6QoCxKy3JK7VOI-2yhNXA==']/p[@class='P5kBN-q2g2nkNYCgydQ1vg==']")
private WebElement verifyPatientList;

@FindBy(xpath = "//button[@tabindex='0']")
private WebElement verifyMyList;

public void verifyPatientLists(){
verifyDisplayed(verifyMyList, "my list is not opened.");
}
    public void clickMyListButton() {
        clickElement(myListButton);
    }


public void verifyList(){
    verifyDisplayed(barisCansizButton,"The list didn't appear.");
}

public void verifyPatientList(){
    verifyDisplayed(verifyPatientList,"The patient list text is not visible.");
}

    public PatientDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickBarisCansizBtn(){
    clickElement(barisCansizButton);
    }
}
