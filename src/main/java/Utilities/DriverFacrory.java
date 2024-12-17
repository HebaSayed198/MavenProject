package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFacrory {
    static WebDriver driver;

    public static WebDriver initiateDriver(String browserName, boolean maximize, boolean headless) {
        if (browserName.equalsIgnoreCase("chrome")) {
            // Configure ChromeOptions for headless mode
            ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("chrome") && headless) {
            System.out.println("HeadLess Chrome Driver initialized");
            ChromeOptions options= new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
            System.out.println("Title is: " +driver.getTitle());
            System.out.println("Headless Chrome Driver run started");
        }

        if (maximize && !headless) {
            // Maximize window only if not in headless mode
            driver.manage().window().maximize();
        }
        return driver;
    }
}



