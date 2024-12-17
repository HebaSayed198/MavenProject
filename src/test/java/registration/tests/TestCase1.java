package registration.tests;

import Utilities.JsonFileManager;
import Utilities.PropertiesReader;
import org.openqa.selenium.WebDriver;
import Utilities.DriverFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import registration.pages.*;

public class TestCase1 {
    private WebDriver driver;
    private JsonFileManager jsonFileManager ;
    private HomePage homePage;
    private SignupOrLoginPage signupOrLoginPage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;
    private AccountDeletedPage accountDeletedPage;
    private Navbar navBar;
    @BeforeMethod
    public void setup(){
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
        driver = DriverFactory.initializingDriver(System.getProperty("browserName"),Boolean.parseBoolean(System.getProperty("maximize")),Boolean.parseBoolean(System.getProperty("headlessExecution")));
        jsonFileManager = new JsonFileManager("D:\\Users\\hiba.makboul\\Desktop\\RegistrationForm\\src\\test\\resources\\TestData.json");
        homePage = new HomePage(driver);
        signupOrLoginPage = new SignupOrLoginPage(driver);
        signupPage = new SignupPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        accountDeletedPage = new AccountDeletedPage(driver);
        navBar = new Navbar(driver);


    }
    @Test

    public void registrationScenario(){
        new HomePage(driver).navigateToHomePage();
        new Navbar(driver).clickOnSignUpLoginButton();
//                        .clickOnDeleteButton();
        new SignupOrLoginPage(driver).fillingInNewUserSignUpData(jsonFileManager.getTestData("username"),jsonFileManager.getTestData("email"))
                         .clickOnSignUpButton();
        new SignupPage(driver).enterAccountInformation("heba1981", "19", "August", "2001")
             .enterAddressInformation("heba", "sayed", "Giza Systems", "new cairo", "new cairo", "India", "Egypt", "Cairo", "123", "01115328356")
              .clickOnCreateAccountButton();
        new AccountCreatedPage(driver).createAccountAssertions()
                .clickOnContinueButton();
        new Navbar(driver).clickOnDeleteButton();
        new AccountDeletedPage(driver).AssertDeleteAccount()
              .clickOnContinueButton();

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @BeforeSuite
    public void BeforeSuite () {
        PropertiesReader.loadProperties();


    }


}
