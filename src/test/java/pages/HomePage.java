package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePages {
    public HomePage(WebDriver givenDriver) {

        super(givenDriver);
    }

    //webElements/locators
    By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }

    @FindBy(xpath = "//i[@data-testid='play-next-btn']")
    WebElement playNextBtn;
    @FindBy(xpath = "//span[@data-testid='play-btn']")
    WebElement playBtn;
    @FindBy(xpath = "//div[@data-testid='sound-bar-play']")
    WebElement soundBar;
    @FindBy(xpath = "//a[@href='#!/songs']")
    WebElement getAllSongPage;
    @FindBy(xpath = "//a[@href='#!/playlist/94287']")
    WebElement playlistTest;
    @FindBy(xpath = "//button[@class='del btn-delete-playlist']")
    WebElement deleteSong;
    @FindBy(xpath = "//div[@class='success show']")
    WebElement getDeleteMessage;
    @FindBy(xpath = "//div[@class='text']")
    WebElement emptyPage;
    @FindBy(xpath = "//a[@href='#!/songs']")
    WebElement allSongsPage;


    //Method using Page Factory
    public HomePage allSongPage(){
        allSongsPage.isDisplayed();
        return this;
    }

    public HomePage playListName(String name) {
        playlistTest.click();
        return this;
    }

    public HomePage deleteExistingPlaylist() {
        deleteSong.click();
        return this;
    }

    public String getDeletedMessage() {
        return getDeleteMessage.getText();
    }

    public HomePage allSongs() {
         getAllSongPage.click();
         return this;

    }
    public HomePage clickPlay(){
        playNextBtn.click();
        playBtn.click();
        return this;
    }
    public boolean isSongPlays(){
        soundBar.isDisplayed();
        return soundBar.isDisplayed();
    }

}


