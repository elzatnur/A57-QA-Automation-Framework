
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    @Test
    public void loginValidTest(){
        //LoginPage loginPage = new LoginPage(driver);
        //HomePage homePage = new HomePage(driver);
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());
        loginpage.provideEmail("elzat.nurmanbetova@testpro.io");
        loginpage.providePassword("kochkor123-Q!");
        loginpage.clickSubmit();
        Assert.assertTrue(homepage.getUserAvatar().isDisplayed());
    }
}
