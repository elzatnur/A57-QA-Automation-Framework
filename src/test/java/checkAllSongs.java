import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import stepDefinitons.BaseDefinition;

@Test
public class checkAllSongs extends BaseDefinition {
  public void viewAllSongs(){
      LoginPage loginpage = new LoginPage(driver);
      HomePage homepage = new HomePage(driver);
      loginpage.provideEmail("elzat.nurmanbetova@testpro.io");
      loginpage.providePassword("kochkor123-Q!");
      loginpage.clickSubmit();
      homepage.allSongs();

  }
}
