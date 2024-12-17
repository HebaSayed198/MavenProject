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
    private JsonFileManager jsonFileManager;
    private HomePage homePage;
    private SignupOrLoginPage signupOrLoginPage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;
    private AccountDeletedPage accountDeletedPage;
    private Navbar navBar;

    @BeforeSuite
    public void beforeSuite() {
        PropertiesReader.loadProperties();
    }

    @BeforeMethod
    public void setup() {
        String browserName = System.getProperty("browserName", "chrome");
        boolean maximize = Boolean.parseBoolean(System.getProperty("maximize", "true"));
        boolean headlessExecution = Boolean.parseBoolean(System.getProperty("headlessExecution", "false"));

        driver = DriverFactory.initializingDriver(browserName, maximize, headlessExecution);
        jsonFileManager = new JsonFileManager("src/test/resources/TestData.json");

        // Initialize page objects
        homePage = new HomePage(driver);
        signupOrLoginPage = new SignupOrLoginPage(driver);
        signupPage = new SignupPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        accountDeletedPage = new AccountDeletedPage(driver);
        navBar = new Navbar(driver);
    }

    @Test
    public void registrationScenario() {
        homePage.navigateToHomePage();
        navBar.clickOnSignUpLoginButton();

        signupOrLoginPage
                .fillingInNewUserSignUpData(jsonFileManager.getTestData("username"), jsonFileManager.getTestData("email"))
                .clickOnSignUpButton();

        signupPage
                .enterAccountInformation("heba1981", "19", "August", "2001")
                .enterAddressInformation("heba", "sayed", "Giza Systems", "new cairo", "new cairo", "India", "Egypt", "Cairo", "123", "01115328356")
                .clickOnCreateAccountButton();

        accountCreatedPage
                .createAccountAssertions()
                .clickOnContinueButton();

        navBar.clickOnDeleteButton();

        accountDeletedPage
                .AssertDeleteAccount()
                .clickOnContinueButton();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
