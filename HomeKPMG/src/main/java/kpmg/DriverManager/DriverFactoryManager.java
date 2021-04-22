package kpmg.DriverManager;

public class DriverFactoryManager {
    public static DriverFactory getDriverFactory(String driver_type) {
        switch (driver_type) {
            case "FIREFOX":
                return new FirefoxFactory();
            case "EDGE":
                return new EdgeFactory();
            default:
                return new ChromeFactory();
        }
    }
}
