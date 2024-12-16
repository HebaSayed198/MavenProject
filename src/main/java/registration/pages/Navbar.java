package registration.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navbar {
    private WebDriver driver;

    public Navbar(WebDriver driver) {
        this.driver = driver;
    }
    ///// Locators /////
    private By SignUporLoginButton = By.partialLinkText("Signup");
    private By deletebutton = By.xpath("//a[@href='/delete_account']");
    /// /Action Methods/////
    @Step ("verify clicking on login Button")
    public Navbar clickOnSignUpLoginButton() {
        //locate the sign-up link then perform action "clicking" on it
        driver.findElement(SignUporLoginButton).click();
        return this;
    }
    @Step ("verify clicking on Delete button")
    public Navbar clickOnDeleteButton(){
        driver.findElement(deletebutton).click();
        return this;

    }
}
