package registration.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDeletedPage {
    WebDriver driver;

    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
    }
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");
    private By deleteAccountMessage = By.xpath("//h2[@class='title text-center']");
    public AccountDeletedPage clickOnContinueButton(){
        driver.findElement(continueButton).click();
        return this;
    }
    @Step ("account Deleted Successfully")

    public AccountDeletedPage AssertDeleteAccount() {
        Assert.assertEquals(driver.getTitle(),"Automation Exercise - Account Created");
        //System.out.println(driver.findElement(By.xpath("//h2[@class='title text-center']")).getText()); //ACCOUNT DELETED!}
        return this;
    }
}
