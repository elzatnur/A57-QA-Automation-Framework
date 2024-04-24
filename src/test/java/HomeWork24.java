
import org.testng.annotations.Test;
import pages.LoginPage;
@Test
public class HomeWork24 extends BaseTest{
    public void BrowserFactory(){
        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.provideEmail("elzat.nurmanbetova@testpro.io");
        loginpage.providePassword("kochkor123-Q!");
        loginpage.clickSubmit();

    }
}
