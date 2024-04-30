package stepDefinitons;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefintions {

    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("-.c-disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I open Login Page")
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
        LoginPage loginpage = new LoginPage(driver);
        loginpage.provideEmail(email);
    }


    @And("i enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.providePassword(password);
    }


    @And("I submit")
    public void iSubmit() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.clickSubmit();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        HomePage homepage = new HomePage(driver);
        Assert.assertTrue(homepage.getUserAvatar().isDisplayed());
    }
    @After
    public void iCloseBrowser(){
        driver.quit();
    }

}
