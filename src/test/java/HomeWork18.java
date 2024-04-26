import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class HomeWork18 extends BaseTest {

    @Test
    public void playSong  () {
        //GIVEN
        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.provideEmail("elzat.nurmanbetova@testpro.io");
        loginpage.providePassword("kochkor123-Q!");
        loginpage.clickSubmit();

    }
     //WHEN
    public void clickPlay () {
        WebElement playNextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playNextBtn.click();
        playBtn.click();

    }
    //THEN


    public boolean isSongPlays (){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }
}
