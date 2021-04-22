package kpmg;

import kpmg.DriverManager.DriverFactory;
import kpmg.DriverManager.DriverFactoryManager;
import kpmg.Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class EndToEndTest {

    protected WebDriver driver;
    protected static String BINARY_NAME;
    private KPMGPage page;

    @BeforeMethod
    public void beforeMethod() {
        String url = "https://home.kpmg/br/pt/home";
        DriverFactory driverFactory = DriverFactoryManager.getDriverFactory("CHROME");
        driver = driverFactory.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        page = new KPMGPage(this.driver, 60);
    }

    @Test
    @Parameters()
    public void testMenuNavigation() {
        Assert.assertTrue(page.menuNavigation("Insights"), "FAILED opening the menu");
        Assert.assertTrue(page.menuNavigation("Indústrias"), "FAILED opening the menu");
        Assert.assertTrue(page.menuNavigation("Serviços"), "FAILED opening the menu");
        Assert.assertTrue(page.menuNavigation("Digital"), "FAILED opening the menu");
        Assert.assertTrue(page.menuNavigation("Carreiras"), "FAILED opening the menu");
        Assert.assertTrue(page.menuNavigation("Sobre a KPMG"), "FAILED opening the menu");
    }

    @Test
    @Parameters()
    public void testSignUpToday() {
        Assert.assertTrue(page.signUpToday(), "FAILED to sign up");
    }

    @Test
    @Parameters()
    public void testSignUpTodayByExistingAccount() {
        Assert.assertTrue(page.existingAccount(), "FAILED to sign up using existing account");
    }

    @Test
    @Parameters()
    public void testSearchContent() {
        Assert.assertTrue(page.searchContent("Trade & Customs"), "FAILED to sign up using existing account");
    }

    @AfterMethod
    public void afterMethod() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
            } else {
                System.out.println("driver is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
