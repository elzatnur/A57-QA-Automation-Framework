import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeWork18 extends BaseTest {

    @Test
    public void playSong()throws InterruptedException{
        //GIVEN
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());
        loginpage.provideEmail("elzat.nurmanbetova@testpro.io");
        loginpage.providePassword("kochkor123-Q!");
        loginpage.clickSubmit();
        homepage.clickPlay();
        Thread.sleep(20000);
        homepage.isSongPlays();
        Thread.sleep(20000);
        Assert.assertTrue(homepage.isSongPlays());
    }
}
