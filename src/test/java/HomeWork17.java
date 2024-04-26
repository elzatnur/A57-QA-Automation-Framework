import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
@Test
public class HomeWork17 extends BaseTest{
  public void viewAllSongs(){
      LoginPage loginpage = new LoginPage(getDriver());
      HomePage homepage = new HomePage(getDriver());
      loginpage.provideEmail("elzat.nurmanbetova@testpro.io");
      loginpage.providePassword("kochkor123-Q!");
      loginpage.clickSubmit();
      homepage.allSongs();
  }
}
