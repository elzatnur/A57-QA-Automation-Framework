import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeWork18 extends BaseTest {

    @Test
    public void playSong () {
        //GIVEN
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());
        loginpage.provideEmail("elzat.nurmanbetova@testpro.io");
        loginpage.providePassword("kochkor123-Q!");
        loginpage.clickSubmit();
        homepage.clickPlay();
        homepage.isSongPlays();
        Assert.assertTrue(homepage.isSongPlays());
    }
}
