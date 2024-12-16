package registration.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class AccountCreatedPage {
    private WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    String Url = "https://automationexercise.com/account_created";
    /// //Locators//////
    private By successMessage = By.xpath("//b[text()='Account Created!']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");

    /// //Action Methods/////
    public void navigateToAccountCreatedPage() {
        driver.get(Url);
    }

    /// ///Validations////////
    @Step("Account Created successfully")
    public AccountCreatedPage createAccountAssertions() {
        String ActualSuccess_Message = driver.findElement(successMessage).getText();
        String ExpectedSuccess_Message = "ACCOUNT CREATED!";
        Assert.assertEquals(ActualSuccess_Message, ExpectedSuccess_Message, "ERROR");
        return this;

        //System.out.println(ActualSuccess_Message);

    }
    @Step ("verify clicking on continue button")
    public AccountCreatedPage clickOnContinueButton(){
        driver.findElement(continueButton).click();
        return this;
    }
}
