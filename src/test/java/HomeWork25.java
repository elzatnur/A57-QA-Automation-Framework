import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeWork25 extends BaseTest{
    @Test
    public void allSongs(){
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        loginpage.provideEmailLogin("elzat.nurmanbetova@testpro.io")
                .providePasswordLogin("kochkor123-Q!")
                .clickSubmitButton();
        homepage.allSongs();
    }
}
