package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFacrory {
    static WebDriver driver;
    public static WebDriver initiateDriver(String browserName , boolean maximize) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        if (maximize) {
            driver.manage().window().maximize();
        }
        return driver;

        }
    }


