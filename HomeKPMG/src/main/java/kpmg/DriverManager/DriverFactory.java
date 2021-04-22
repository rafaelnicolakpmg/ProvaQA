package kpmg.DriverManager;

import org.openqa.selenium.WebDriver;

public abstract class DriverFactory {
    protected WebDriver driver;
    protected abstract void setupDriver();
    protected abstract void createDriver();

    public void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver(){
        if (driver == null){
            setupDriver();
            createDriver();
        }
        return driver;
    }
}