package kpmg.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxFactory extends DriverFactory {
    @Override
    protected void setupDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Override
    protected void createDriver() {
        driver = new FirefoxDriver();
    }
}
