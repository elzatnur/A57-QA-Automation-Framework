package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePages {
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = ".playlist:nth-child(4)")
    WebElement getFirstPlaylist;
    @FindBy(css= "[.playlist:nth-child(4)]")
    WebElement playlistNameField;
    @FindBy(css = "div.success.show")
    WebElement renamePlaylistSuccessMsg;


    public PlaylistPage firstPlaylist(){
        actions.doubleClick(getFirstPlaylist).perform();
        return this;
    }
    public PlaylistPage playlistField(){
        String PlayListName = "Test111";
        actions.doubleClick(getFirstPlaylist).perform();
        //playlistNameField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.DELETE));
        //playlistNameField.sendKeys(PlayListName);
        actions.sendKeys(PlayListName).perform();
        //playlistNameField.sendKeys(Keys.ENTER);
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }
    public String newPlayListName(){
        renamePlaylistSuccessMsg.isDisplayed();
        return renamePlaylistSuccessMsg.getText();
    }
}
