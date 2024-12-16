package registration.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class SignupOrLoginPage {
    private WebDriver driver;

    public SignupOrLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private String Url = "https://automationexercise.com/login";
    /////////Locators////////
    private By Username = By.xpath("//input[@data-qa='signup-name']");
    private By Email = By.xpath("//input[@data-qa='signup-email']");
    private By SignUpButton = By.xpath("//button[@data-qa='signup-button']");
    ///// Action Methods//////
    public void navigateToSignupLoginPage(){
        driver.get(Url);
    }
    @Step ("filling signup data")
    public SignupOrLoginPage fillingInNewUserSignUpData(String name, String email) {
        driver.findElement(Username).sendKeys(name);
        //locate the Email input field and sending data action on it
        driver.findElement(Email).sendKeys(email);
        return this;
    }
    @Step ("verify clicking on sign up button")
    public SignupOrLoginPage clickOnSignUpButton() {
        driver.findElement(SignUpButton).click();
        return this;
    }
}
