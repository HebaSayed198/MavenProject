package registration.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
     WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private String Url = "https://automationexercise.com/";

    /////Action Methods////
 @Step("Navigating to Home Page")
    public HomePage navigateToHomePage(){
        driver.get(Url);
        return this;
    }


}
