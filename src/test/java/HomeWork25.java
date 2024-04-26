import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeWork25 extends BaseTest{
    @Test
    public void clickPlayList(){
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());
        loginpage.provideEmailLogin("elzat.nurmanbetova@testpro.io")
                .providePasswordLogin("kochkor123-Q!")
                .clickSubmitButton();
        homepage.playListName("Test");
    }
}
