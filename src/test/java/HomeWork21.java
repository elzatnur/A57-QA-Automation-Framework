import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;
@Test
public class HomeWork21 extends BaseTest{
    public void replacePlayListName () throws InterruptedException{
        String PlayListName = "Test111";
        String updatedPlaylistMsg = "Updated playlist \""+PlayListName+".\"";
        LoginPage loginpage = new LoginPage(getDriver());
        PlaylistPage playlistpage = new PlaylistPage(getDriver());
        loginpage.login();
        Thread.sleep(2000);
        playlistpage.firstPlaylist();
        Thread.sleep(2000);
        playlistpage.playlistField();
        Thread.sleep(2000);
        playlistpage.newPlayListName();
        Thread.sleep(2000);
        Assert.assertEquals(playlistpage.newPlayListName(), updatedPlaylistMsg );
    }
}
