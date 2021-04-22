package kpmg.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory extends DriverFactory {
    private ChromeOptions options;

    public ChromeFactory() {
        setChromeOptions();
    }

    private void setChromeOptions() {
        options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--disable-features=VizDisplayCompositor");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.addArguments("--log-level=3");
        options.addArguments("--silent");
        options.addArguments("--no-sandbox");
    }

    @Override
    protected void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    protected void createDriver() {
        driver = new ChromeDriver(options);
    }
}