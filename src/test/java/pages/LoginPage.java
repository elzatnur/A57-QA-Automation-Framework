package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePages{
    //constructor
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    //webElements
     By emailField = By.cssSelector("input[type='email']");
     By passwordField = By.cssSelector("input[type='password']");
     By loginBtn = By.cssSelector("button[type='submit']");

    //using page factory
    @FindBy(css = "input[type='email']")
    WebElement emailFieldLocator;
    @FindBy(css = "input[type='password']")
    WebElement passwordFieldLocator;
    @FindBy(css = "button[type='submit']")
    WebElement loginBtnLocator;
    @FindBy(xpath = "//a[@href='registration']")
    WebElement registrationLink;

    //helper page methods

    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit(){
        findElement(loginBtn).click();

    }
    public WebElement getRegistrationLink(){
        return registrationLink;
    }
}
