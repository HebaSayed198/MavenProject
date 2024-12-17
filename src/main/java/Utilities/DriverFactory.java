package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    static WebDriver driver;
    @Step("Initializing new driver ")
    public static WebDriver initializingDriver(String browserName,boolean maximize,boolean headlessExecution){

        if(browserName.equalsIgnoreCase("chrome")) {
            driver=new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("chrome") && headlessExecution) {
            System.out.println("HeadLess Chrome Driver initialized");
            ChromeOptions options= new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
            System.out.println("Title is: " +driver.getTitle());
            System.out.println("Headless Chrome Driver run started");
        }
        if(maximize){
            driver.manage().window().maximize();
        }
        return driver; }
}