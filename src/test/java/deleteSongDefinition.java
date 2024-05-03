import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import stepDefinitons.BaseDefinition;

@Test
public class deleteSongDefinition extends BaseDefinition {
    public void deleteSong(){
        String expectedDeletedMsg = "Deleted playlist \"Test.\"";
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homepage =new HomePage(getDriver());
        loginpage.login();
        homepage.playListName("Test");
        homepage.deleteExistingPlaylist();
        homepage.getDeletedMessage();
        Assert.assertEquals(homepage.getDeletedMessage(),expectedDeletedMsg);
    }
}
