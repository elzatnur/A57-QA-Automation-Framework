import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeWork22 extends BaseTest{
        @Test
        public void loginValidTest(){
            LoginPage loginpage = new LoginPage(getDriver());
            HomePage homepage = new HomePage(getDriver());
            loginpage.provideEmail("elzat.nurmanbetova@testpro.io");
            loginpage.providePassword("kochkor123-Q!");
            loginpage.clickSubmit();

        }

    }