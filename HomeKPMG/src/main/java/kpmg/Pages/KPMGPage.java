package kpmg.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class KPMGPage {

    @FindBy(css = "[class='nav-link text-kpmg-blue pt-3 chrome']")
    private List<WebElement> menuOptions;
    @FindBy(css = "[title='Sign up today']")
    private WebElement signUpToday;
    @FindBy(css = "[title='Register now']")
    private WebElement registerNow;
    @FindBy(css = "[name='profile.firstName']")
    private List<WebElement> firstName;
    @FindBy(css = "[name='profile.lastName']")
    private List<WebElement> lastName;
    @FindBy(css = "[name='email']")
    private List<WebElement> email;
    @FindBy(css = "[name='password']")
    private List<WebElement> senha;
    @FindBy(css = "[name='passwordRetype']")
    private List<WebElement> confirmarSenha;
    @FindBy(css = "[name='profile.work.company']")
    private List<WebElement> empresa;
    @FindBy(css = "[id='Google_btn']")
    private WebElement googleBtn;
    @FindBy(css = "[class='arrow-label left-box field-valid-required']")
    private List<WebElement> politicaCheckbox;
    @FindBy(css = "[class='gigya-input-submit trackable']")
    private WebElement continueBtn;
    @FindBy(css = "[class='icon icon-search icon-fw px-2 py-1 text-kpmg-blue cursor-pointer chrome']")
    private WebElement searchBtn;
    @FindBy(css = "[id='desktop-search']")
    private WebElement searchBar;
    @FindBy(css = "[class='result desktopContainer col-md-12']")
    private List<WebElement> searchResults;

    private String current_system_time = "";

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static int iWaitIncrement = 1000;
    private static int iWaitRetries = 30;
    private PageObjectUtilities pou;

    public KPMGPage(WebDriver driver, int iTimeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, iTimeout);
        int iTimeoutInMilliseconds = 1000 * iTimeout;
        this.iWaitRetries = iTimeoutInMilliseconds / this.iWaitIncrement;
        this.driver.manage().timeouts().pageLoadTimeout(iTimeout, TimeUnit.SECONDS);
        PageFactory.initElements(this.driver, this);
        pou = new PageObjectUtilities(this.driver, iTimeout);
    }

    public boolean menuNavigation(String menu) {
        try {
            Thread.sleep(3 * iWaitIncrement);
            for (int i=0; i < menuOptions.size(); i++) {
                if (menuOptions.get(i).getText().contains(menu)) {
                    menuOptions.get(i).click();
                    return true;
                }
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean signUpToday() {
        menuNavigation("Insights");
        wait.until(ExpectedConditions.visibilityOf(signUpToday));
        try {
            Thread.sleep(3000);
            if (signUpToday.isDisplayed()) {
                pou.scrollToElement(signUpToday);
                signUpToday.click();
                Thread.sleep(3 * iWaitIncrement);
                registerNow.click();
                Thread.sleep(5 * iWaitIncrement);
                firstName.get(4).sendKeys("Tyrant");
                lastName.get(4).sendKeys("Tyrant");
                email.get(3).sendKeys("tyrant@tyrant.com");
                senha.get(5).sendKeys("!Q2w3e4r");
                confirmarSenha.get(5).sendKeys("!Q2w3e4r");
                empresa.get(4).sendKeys("BLA CIA");
                pou.scrollToElement(politicaCheckbox.get(4));
                if (pou.isCheckboxChecked(politicaCheckbox.get(4)) == false) politicaCheckbox.get(4).click();
                continueBtn.click();
                Thread.sleep(3 * iWaitIncrement);
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean existingAccountByGoogle() {
        menuNavigation("Insights");
        wait.until(ExpectedConditions.visibilityOf(signUpToday));
        try {
            Thread.sleep(3000);
            if (signUpToday.isDisplayed()) {
                pou.scrollToElement(signUpToday);
                signUpToday.click();
                Thread.sleep(3 * iWaitIncrement);
                registerNow.click();
                Thread.sleep(5 * iWaitIncrement);
                googleBtn.click();
                Thread.sleep(5 * iWaitIncrement);
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean existingAccount() {
        menuNavigation("Insights");
        wait.until(ExpectedConditions.visibilityOf(signUpToday));
        try {
            Thread.sleep(3000);
            if (signUpToday.isDisplayed()) {
                pou.scrollToElement(signUpToday);
                signUpToday.click();
                Thread.sleep(3 * iWaitIncrement);
                registerNow.click();
                Thread.sleep(5 * iWaitIncrement);
                googleBtn.click();
                Thread.sleep(5 * iWaitIncrement);
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean searchContent(String contentToSearch) {
        try {
            Thread.sleep(3 * iWaitIncrement);
            if (searchBtn.isDisplayed()) {
                searchBtn.click();
                Thread.sleep(iWaitIncrement);
                searchBar.sendKeys(contentToSearch);
                searchBar.sendKeys(Keys.ENTER);
                Thread.sleep(5 * iWaitIncrement);
                for (int i=0; i<searchResults.size(); i++) {
                    if (searchResults.get(i).getText().contains(contentToSearch)) {
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

