package kpmg.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeFactory extends DriverFactory {
    private EdgeOptions options;

    public EdgeFactory() {
        setOptions();
    }

    private void setOptions() {
        options = new EdgeOptions();
    }

    @Override
    protected void setupDriver() {
        WebDriverManager.edgedriver().setup();
    }

    @Override
    protected void createDriver() {
        driver = new EdgeDriver(options);
    }
}
